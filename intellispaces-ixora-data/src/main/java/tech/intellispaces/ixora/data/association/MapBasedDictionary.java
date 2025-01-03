package tech.intellispaces.ixora.data.association;

import tech.intellispaces.ixora.data.collection.DoubleList;
import tech.intellispaces.ixora.data.collection.IntegerList;
import tech.intellispaces.ixora.data.collection.List;
import tech.intellispaces.ixora.data.collection.Lists;
import tech.intellispaces.ixora.data.exception.InvalidPropertyException;
import tech.intellispaces.ixora.data.exception.InvalidPropertyExceptions;
import tech.intellispaces.jaquarius.annotation.Mapper;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;

import java.util.Collections;
import java.util.Map;

@ObjectHandle(DictionaryDomain.class)
abstract class MapBasedDictionary implements UnmovableDictionary {
  private final java.util.Map<String, Object> map;

  MapBasedDictionary(java.util.Map<String, Object> map) {
    this.map = (map != null ? map : Map.of());
  }

  public java.util.Map<String, Object> nativeMap() {
    return Collections.unmodifiableMap(map);
  }

  Map<String, Object> map() {
    return map;
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
    } else if (result instanceof java.util.List<?> list) {
      return convertObjectToList(path, list);
    } else if (result instanceof Map<?, ?>) {
      return new MapBasedDictionaryImpl((java.util.Map<String, Object>) result);
    } else {
      throw new UnsupportedOperationException("Not implemented");
    }
  }

  private List<?> convertObjectToList(String path, java.util.List<?> list) {
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
      return dictionaryList(path, list);
    } else {
      throw new UnsupportedOperationException("Not implemented");
    }
  }

  @Mapper
  @Override
  public Integer integerValue(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    validateSingleValueType(path, value, Integer.class);
    return (int) value;
  }

  @Mapper
  @Override
  public Double doubleValue(String path) throws InvalidPropertyException {
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
  public Dictionary dictionaryValue(String path) throws InvalidPropertyException {
    if (path.isEmpty()) {
      return this;
    }
    Object value = traverse(path);
    validateSingleValueType(path, value, java.util.Map.class);
    return new MapBasedDictionaryImpl((java.util.Map<String, Object>) value);
  }

  @Mapper
  @Override
  public IntegerList integerList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return integerList(path, value);
  }

  @SuppressWarnings("unchecked")
  private IntegerList integerList(String path, Object value) {
    validateListValueType(path, value, Integer.class);
    return Lists.ofIntegers((java.util.List<Integer>) value);
  }

  @Mapper
  @Override
  public DoubleList doubleList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return doubleList(path, value);
  }

  @SuppressWarnings("unchecked")
  private DoubleList doubleList(String path, Object value) {
    validateListValueType(path, value, Double.class);
    return Lists.ofDoubles((java.util.List<Double>) value);
  }

  @Mapper
  @Override
  public List<String> stringList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return stringList(path, value);
  }

  @SuppressWarnings("unchecked")
  private List<String> stringList(String path, Object value) {
    validateListValueType(path, value, String.class);
    return Lists.of((java.util.List<String>) value, String.class);
  }

  @Mapper
  @Override
  public List<Dictionary> dictionaryList(String path) throws InvalidPropertyException {
    Object value = traverse(path);
    return dictionaryList(path, value);
  }

  @SuppressWarnings("unchecked")
  private List<Dictionary> dictionaryList(String path, Object value) {
    validateListValueType(path, value, Map.class);
    var values = (java.util.List<Map<String, Object>>) value;
    java.util.List<Dictionary> propertyList = values.stream()
        .map(MapBasedDictionaryImpl::new)
        .map(p -> (Dictionary) p)
        .toList();
    return Lists.of(propertyList, Dictionary.class);
  }

  @Mapper
  @Override
  public Integer size() {
    return nativeMap().size();
  }

  private void validateSingleValueType(String path, Object value, Class<?> expectedType) {
    if (value == null) {
      throw InvalidPropertyExceptions.withMessage("Property does not exist. Path '{0}'", path);
    }
    if (value instanceof DictionaryDomain & expectedType != java.util.Map.class) {
      throw InvalidPropertyExceptions.withMessage("Expected property value of {0} type, " +
              "but actual is {1}. Path '{2}'",
          expectedType.getCanonicalName(), DictionaryDomain.class.getCanonicalName(), path);

    }
    if (!expectedType.isAssignableFrom(value.getClass())) {
      throw InvalidPropertyExceptions.withMessage("Expected property value of {0} type, " +
              "but actual is {1}. Path '{2}'",
          expectedType.getCanonicalName(), getActualType(value).getCanonicalName(), path);
    }
  }

  private void validateListValueType(String path, Object value, Class<?> expectedElementType) {
    if (value == null) {
      throw InvalidPropertyExceptions.withMessage("Property does not exist. Path '{0}'", path);
    }

    if (!java.util.List.class.isAssignableFrom(value.getClass())) {
      throw InvalidPropertyExceptions.withMessage("Expected property list values of type {0}, " +
              "but actual is single value of type {1}. Path '{2}'",
          expectedElementType.getCanonicalName(), getActualType(value).getCanonicalName(), path);
    }

    var list = (java.util.List<?>) value;
    for (Object element : list) {
      if (!expectedElementType.isAssignableFrom(element.getClass())) {
        throw InvalidPropertyExceptions.withMessage("Expected property list of {0} values, " +
                "but actual is list contained {1} values. Path '{2}'",
            expectedElementType.getCanonicalName(), getActualType(element).getCanonicalName(), path);
      }
    }
  }

  private static Class<?> getActualType(Object value) {
    final Class<?> actualType;
    if (Dictionary.class.isAssignableFrom(value.getClass())) {
      actualType = Dictionary.class;
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
    java.util.Map<String, Object> curMap = nativeMap();
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
