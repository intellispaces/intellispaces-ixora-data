package tech.intellispaces.ixora.commons.structures.collection;

import tech.intellispaces.framework.commons.exception.UnexpectedViolationException;
import tech.intellispaces.ixora.structures.collection.ListHandle;

import java.util.List;

public interface CollectionFunctions {

  static <E> List<E> javaList(ListHandle<E> listHandle) {
    if (listHandle instanceof JavaListHandle<E>) {
      return ((JavaListHandle<E>) listHandle).javaList();
    }
    throw UnexpectedViolationException.withMessage("Not implemented");
  }
}
