package tech.intellispaces.ixora.commons.structures;

import intellispaces.ixora.structures.collection.ListHandle;
import intellispaces.ixora.structures.properties.PropertiesHandle;
import tech.intellispaces.framework.commons.exception.UnexpectedViolationException;
import tech.intellispaces.ixora.commons.structures.collection.AbstractJavaList;
import tech.intellispaces.ixora.commons.structures.properties.AbstractMapBasedProperties;

import java.util.List;
import java.util.Map;

public interface StructuresFunctions {

  static <E> List<E> javaList(ListHandle<E> listHandle) {
    if (listHandle instanceof AbstractJavaList<E>) {
      return ((AbstractJavaList<E>) listHandle).javaList();
    }
    throw UnexpectedViolationException.withMessage("Not implemented");
  }

  static Map<String, Object> javaMap(PropertiesHandle propertiesHandle) {
    if (propertiesHandle instanceof AbstractMapBasedProperties) {
      return ((AbstractMapBasedProperties) propertiesHandle).javaMap();
    }
    throw UnexpectedViolationException.withMessage("Not implemented");
  }
}
