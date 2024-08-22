package intellispaces.ixora.structures.collection;

public interface Cursors {

  /**
   * Creates new cursor.
   *
   * @param collection source collection.
   * @return created cursor.
   * @param <E> collection elements type.
   */
  static <E> Cursor<E> get(Collection<E> collection) {
    return null;
  }
}
