package tech.mindstructs.structures;

import intellispaces.ixora.mindstructs.structures.collection.ListHandle;
import intellispaces.ixora.mindstructs.structures.properties.PropertiesHandle;
import tech.intellispaces.framework.commons.exception.UnexpectedViolationException;
import tech.mindstructs.structures.collection.AbstractJavaList;
import tech.mindstructs.structures.properties.AbstractMapBasedProperties;

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
