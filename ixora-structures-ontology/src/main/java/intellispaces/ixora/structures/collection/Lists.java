package intellispaces.ixora.structures.collection;

import tech.intellispaces.actions.getter.Getter;

public final class Lists {
//  private static final Getter<ObjectProvider2<UnmovableListHandle, java.util.List, Class>> LIST_BY_NATIVE_LIST_GETTER;

  private Lists() {}

  /**
   * Creates handle of unmovable list on base Java list.
   *
   * @param javaList origin list.
   * @param elementClass class of list elements.
   * @return handle to list.
   * @param <E> type of list elements.
   */
  static <E> UnmovableListHandle<E> of(java.util.List<E> javaList, Class<E> elementClass) {
//    return LIST_BY_NATIVE_LIST_GETTER.get().of(nativeList, elementClass);
    return null;
  }

  static <E> UnmovableListHandle<E> empty(Class<E> elementClass) {
    return null;
  }
}
