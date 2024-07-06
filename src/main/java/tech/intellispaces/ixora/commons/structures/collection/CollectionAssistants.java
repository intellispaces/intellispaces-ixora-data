package tech.intellispaces.ixora.commons.structures.collection;

import tech.intellispaces.framework.commons.exception.UnexpectedViolationException;
import tech.intellispaces.ixora.structures.collection.ListHandle;

import java.util.List;

public interface CollectionAssistants {

  static <E> List<E> javaList(ListHandle<E> listHandle) {
    if (listHandle instanceof AbstractJavaList<E>) {
      return ((AbstractJavaList<E>) listHandle).javaList();
    }
    throw UnexpectedViolationException.withMessage("Not implemented");
  }
}
