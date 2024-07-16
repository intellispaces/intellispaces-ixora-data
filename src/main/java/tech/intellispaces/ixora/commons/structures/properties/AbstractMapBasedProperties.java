package tech.intellispaces.ixora.commons.structures.properties;

import intellispaces.ixora.structures.collection.DoubleListBasedOnList;
import intellispaces.ixora.structures.collection.DoubleListHandle;
import intellispaces.ixora.structures.collection.IntegerListBasedOnList;
import intellispaces.ixora.structures.collection.IntegerListHandle;
import intellispaces.ixora.structures.collection.StringListBasedOnList;
import intellispaces.ixora.structures.collection.StringListHandle;
import intellispaces.ixora.structures.exception.InvalidPropertyException;
import intellispaces.ixora.structures.properties.Properties;
import intellispaces.ixora.structures.properties.PropertiesHandle;
import intellispaces.ixora.structures.properties.PropertiesListBasedOnList;
import intellispaces.ixora.structures.properties.PropertiesListHandle;
import intellispaces.ixora.structures.properties.UnmovablePropertiesHandle;
import tech.intellispaces.framework.core.annotation.Mapper;
import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.ixora.commons.structures.collection.JavaList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@ObjectHandle("MapBasedProperties")
public abstract class AbstractMapBasedProperties implements UnmovablePropertiesHandle {
  private final java.util.Map<String, Object> map;

  public AbstractMapBasedProperties(java.util.Map<String, Object> map) {
    this.map = (map != null ? map : Map.of());
  }

  public java.util.Map<String, Object> javaMap() {
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

  private intellispaces.ixora.structures.collection.List<?> convertObjectToList(String path, List<?> list) {
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
  public PropertiesHandle propertiesValue(String path) throws InvalidPropertyException {
    if (path.isEmpty()) {
      return this;
    }
    Object value = traverse(path);
    validateSingleValueType(path, value, java.util.Map.class);
    return new MapBasedProperties((java.util.Map<String, Object>) value);
  }

  @Mapper
  @Override
  public IntegerListHandle integerList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return integerList(path, value);
  }

  @SuppressWarnings("unchecked")
  private IntegerListHandle integerList(String path, Object value) {
    validateListValueType(path, value, Integer.class);
    return new IntegerListBasedOnList(new JavaList<>((List<Integer>) value, Integer.class));
  }

  @Mapper
  @Override
  public DoubleListHandle doubleList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return doubleList(path, value);
  }

  @SuppressWarnings("unchecked")
  private DoubleListHandle doubleList(String path, Object value) {
    validateListValueType(path, value, Double.class);
    return new DoubleListBasedOnList(new JavaList<>((List<Double>) value, Double.class));
  }

  @Mapper
  @Override
  public StringListHandle stringList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return stringList(path, value);
  }

  @SuppressWarnings("unchecked")
  private StringListHandle stringList(String path, Object value) {
    validateListValueType(path, value, String.class);
    return new StringListBasedOnList(new JavaList<>((List<String>) value, String.class));
  }

  @Mapper
  @Override
  public PropertiesListHandle propertiesList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return propertiesList(path, value);
  }

  @SuppressWarnings("unchecked")
  private PropertiesListHandle propertiesList(String path, Object value) {
    validateListValueType(path, value, Map.class);
    var values = (List<Map<String, Object>>) value;
    List<Properties> propertyList = values.stream()
        .map(MapBasedProperties::new)
        .map(p -> (Properties) p)
        .toList();
    return new PropertiesListBasedOnList(new JavaList<>(propertyList, Properties.class));
  }

  @Mapper
  @Override
  public int size() {
    return javaMap().size();
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
    java.util.Map<String, Object> curMap = javaMap();
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
