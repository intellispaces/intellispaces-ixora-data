package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;

public interface Lists {

  /**
   * Creates handle of unmovable list based on Java list.
   *
   * @param javaList origin list.
   * @param elementClass elements class.
   * @return handle to list.
   * @param <E> element type.
   */
  static <E> UnmovableList<E> of(java.util.List<E> javaList, Class<E> elementClass) {
    return new JavaListHandleImpl<>(javaList, elementClass);
  }

  /**
   * Creates handle of unmovable list based on Java list.
   *
   * @param javaList origin list.
   * @param elementType elements type.
   * @return handle to list.
   * @param <E> element type.
   */
  static <E> UnmovableList<E> of(java.util.List<E> javaList, Type<E> elementType) {
    return new JavaListHandleImpl<>(javaList, elementType);
  }

  static <E> UnmovableList<E> empty(Class<E> elementClass) {
    return ListProvider.empty(elementClass);
  }
}
