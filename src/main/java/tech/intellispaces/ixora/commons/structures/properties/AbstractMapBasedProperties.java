package tech.intellispaces.ixora.commons.structures.properties;

import tech.intellispaces.framework.core.annotation.Mapper;
import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.ixora.commons.structures.collection.InheritedDoubleList;
import tech.intellispaces.ixora.commons.structures.collection.InheritedIntegerList;
import tech.intellispaces.ixora.commons.structures.collection.InheritedPropertiesList;
import tech.intellispaces.ixora.commons.structures.collection.InheritedStringList;
import tech.intellispaces.ixora.commons.structures.collection.JavaList;
import tech.intellispaces.ixora.structures.collection.DoubleListUnmovableHandle;
import tech.intellispaces.ixora.structures.collection.IntegerListUnmovableHandle;
import tech.intellispaces.ixora.structures.collection.StringListUnmovableHandle;
import tech.intellispaces.ixora.structures.exception.InvalidPropertyException;
import tech.intellispaces.ixora.structures.properties.Properties;
import tech.intellispaces.ixora.structures.properties.PropertiesListUnmovableHandle;
import tech.intellispaces.ixora.structures.properties.PropertiesUnmovableHandle;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@ObjectHandle("MapBasedProperties")
public abstract class AbstractMapBasedProperties implements PropertiesUnmovableHandle {
  private final java.util.Map<String, Object> map;

  public AbstractMapBasedProperties(java.util.Map<String, Object> map) {
    this.map = (map != null ? map : Map.of());
  }

  public java.util.Map<String, Object> map() {
    return Collections.unmodifiableMap(map);
  }

  @Mapper
  @Override
  @SuppressWarnings("unchecked")
  public Object value(String path) throws InvalidPropertyException {
    if (path.isEmpty()) {
      return this;
    }
    Object result = traverse(path);
    if (result == null) {
      return null;
    } else if (result instanceof Integer) {
      return result;
    } else if (result instanceof Double) {
      return result;
    } else if (result instanceof String) {
      return result;
    } else if (result instanceof List<?> list) {
      return convertObjectToList(path, list);
    } else if (result instanceof Map<?, ?>) {
      return new MapBasedProperties((java.util.Map<String, Object>) result);
    } else {
      throw new UnsupportedOperationException("Not implemented");
    }
  }

  private tech.intellispaces.ixora.structures.collection.List<?> convertObjectToList(String path, List<?> list) {
    if (list.isEmpty()) {
      throw new UnsupportedOperationException("Not implemented");
    }
    Object firstElement = list.get(0);
    if (firstElement instanceof Integer) {
      return integerList(path, list);
    } else if (firstElement instanceof Double) {
      return doubleList(path, list);
    } else if (firstElement instanceof String) {
      return stringList(path, list);
    } else if (firstElement instanceof Map<?, ?>) {
      return propertiesList(path, list);
    } else {
      throw new UnsupportedOperationException("Not implemented");
    }
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
  public AbstractMapBasedProperties propertiesValue(String path) throws InvalidPropertyException {
    if (path.isEmpty()) {
      return this;
    }
    Object value = traverse(path);
    validateSingleValueType(path, value, java.util.Map.class);
    return new MapBasedProperties((java.util.Map<String, Object>) value);
  }

  @Mapper
  @Override
  public IntegerListUnmovableHandle integerList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return integerList(path, value);
  }

  @SuppressWarnings("unchecked")
  private IntegerListUnmovableHandle integerList(String path, Object value) {
    validateListValueType(path, value, Integer.class);
    return new InheritedIntegerList(new JavaList<>((List<Integer>) value, Integer.class));
  }

  @Mapper
  @Override
  public DoubleListUnmovableHandle doubleList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return doubleList(path, value);
  }

  @SuppressWarnings("unchecked")
  private DoubleListUnmovableHandle doubleList(String path, Object value) {
    validateListValueType(path, value, Double.class);
    return new InheritedDoubleList(new JavaList<>((List<Double>) value, Double.class));
  }

  @Mapper
  @Override
  public StringListUnmovableHandle stringList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return stringList(path, value);
  }

  @SuppressWarnings("unchecked")
  private StringListUnmovableHandle stringList(String path, Object value) {
    validateListValueType(path, value, String.class);
    return new InheritedStringList(new JavaList<>((List<String>) value, String.class));
  }

  @Mapper
  @Override
  public PropertiesListUnmovableHandle propertiesList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return propertiesList(path, value);
  }

  @SuppressWarnings("unchecked")
  private PropertiesListUnmovableHandle propertiesList(String path, Object value) {
    validateListValueType(path, value, Map.class);
    var values = (List<Map<String, Object>>) value;
    List<Properties> propertyList = values.stream()
        .map(MapBasedProperties::new)
        .map(p -> (Properties) p)
        .toList();
    return new InheritedPropertiesList(new JavaList<>(propertyList, Properties.class));
  }

  @Mapper
  @Override
  public int size() {
    return map().size();
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
