package tech.intellispaces.ixora.commons.structures.properties;

import tech.intellispaces.ixora.commons.structures.collection.JavaListHandleImpl;
import tech.intellispaces.ixora.structures.collection.ListHandle;
import tech.intellispaces.ixora.structures.properties.InvalidPropertyException;
import tech.intellispaces.ixora.structures.properties.Properties;
import tech.intellispaces.ixora.structures.properties.PropertiesHandle;
import tech.intellispacesframework.core.annotation.Mapper;
import tech.intellispacesframework.core.annotation.ObjectHandle;

import java.util.Collections;

@ObjectHandle
public abstract class MapBasedPropertiesHandle implements PropertiesHandle {
  private final java.util.Map<String, Object> map;

  public MapBasedPropertiesHandle(java.util.Map<String, Object> map) {
    this.map = map;
  }

  public java.util.Map<String, Object> map() {
    return Collections.unmodifiableMap(map);
  }

  @Mapper
  @Override
  public int integerValue(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateSingleValueType(path, value, Integer.class);
    return (int) value;
  }

  @Mapper
  @Override
  public double doubleValue(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateSingleValueType(path, value, Double.class);
    return (double) value;
  }

  @Mapper
  @Override
  public String stringValue(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateSingleValueType(path, value, String.class);
    return (String) value;
  }

  @Mapper
  @Override
  @SuppressWarnings("unchecked")
  public MapBasedPropertiesHandle propertiesValue(String path) throws InvalidPropertyException {
    if (path.isEmpty()) {
      return this;
    }
    Object value = traverse(path);
    validateSingleValueType(path, value, java.util.Map.class);
    return new MapBasedPropertiesHandleImpl((java.util.Map<String, Object>) value);
  }

  @Mapper
  @Override
  @SuppressWarnings("unchecked")
  public ListHandle<Integer> integerList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateListValueType(path, value, Integer.class);
    return new JavaListHandleImpl<>((java.util.List<Integer>) value, Integer.class);
  }

  @Mapper
  @Override
  @SuppressWarnings("unchecked")
  public ListHandle<Double> doubleList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateListValueType(path, value, Double.class);
    return new JavaListHandleImpl<>((java.util.List<Double>) value, Double.class);
  }

  @Mapper
  @Override
  @SuppressWarnings("unchecked")
  public ListHandle<String> stringList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateListValueType(path, value, String.class);
    return new JavaListHandleImpl<>((java.util.List<String>) value, String.class);
  }

  @Mapper
  @Override
  @SuppressWarnings("unchecked")
  public ListHandle<PropertiesHandle> propertiesList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateListValueType(path, value, java.util.Map.class);
    var values = (java.util.List<java.util.Map<String, Object>>) value;
    java.util.List<PropertiesHandle> propertyList = values.stream()
        .map(MapBasedPropertiesHandleImpl::new)
        .map(p -> (PropertiesHandle) p)
        .toList();
    return new JavaListHandleImpl<>(propertyList, PropertiesHandle.class);
  }

  private void validateSingleValueType(String path, Object value, Class<?> expectedType) {
    if (value == null) {
      throw InvalidPropertyException.withMessage("Property does not exist. Path '{}'", path);
    }
    if (value instanceof Properties & expectedType != java.util.Map.class) {
      throw InvalidPropertyException.withMessage("Expected property value of {} type, but actual is {}. Path '{}'",
          expectedType.getCanonicalName(), Properties.class.getCanonicalName(), path);

    }
    if (!expectedType.isAssignableFrom(value.getClass())) {
      throw InvalidPropertyException.withMessage("Expected property value of {} type, but actual is {}. Path '{}'",
          expectedType.getCanonicalName(), getActualType(value).getCanonicalName(), path);
    }
  }

  private void validateListValueType(String path, Object value, Class<?> expectedElementType) {
    if (value == null) {
      throw InvalidPropertyException.withMessage("Property does not exist. Path '{}'", path);
    }

    if (!java.util.List.class.isAssignableFrom(value.getClass())) {
      throw InvalidPropertyException.withMessage("Expected property list values of type {}, but actual is single value of type {}. Path '{}'",
          expectedElementType.getCanonicalName(), getActualType(value).getCanonicalName(), path);
    }

    var list = (java.util.List<?>) value;
    for (Object element : list) {
      if (!expectedElementType.isAssignableFrom(element.getClass())) {
        throw InvalidPropertyException.withMessage("Expected property list of {} values, but actual is list contained {} values. Path '{}'",
            expectedElementType.getCanonicalName(), getActualType(element).getCanonicalName(), path);
      }
    }
  }

  private static Class<?> getActualType(Object value) {
    final Class<?> actualType;
    if (Properties.class.isAssignableFrom(value.getClass())) {
      actualType = Properties.class;
    } else if (java.util.Map.class.isAssignableFrom(value.getClass())) {
      actualType = java.util.Map.class;
    } else if (java.util.List.class.isAssignableFrom(value.getClass())) {
      actualType = java.util.List.class;
    } else {
      actualType = value.getClass();
    }
    return actualType;
  }

  @SuppressWarnings("unchecked")
  private Object traverse(String path) {
    if (path == null) {
      return null;
    }
    if (path.isEmpty()) {
      return this;
    }

    Object result = null;
    java.util.Map<String, Object> curMap = map();
    String[] parts = path.split("\\.");
    for (String part : parts) {
      if (curMap == null) {
        result = null;
        break;
      } else {
        Object target = curMap.get(part);
        if (target == null) {
          result = null;
          break;
        } else if (target instanceof java.util.Map) {
          result = target;
          curMap = (java.util.Map<String, Object>) target;
        } else {
          result = target;
          curMap = null;
        }
      }
    }
    return result;
  }
}
