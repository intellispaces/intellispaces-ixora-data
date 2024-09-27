package intellispaces.ixora.structures.collection;

import java.io.InputStream;

public interface Cursors {

  /**
   * Creates new cursor.
   *
   * @param collection source collection.
   * @return created cursor.
   * @param <E> collection elements type.
   */
  static <E> Cursor<E> get(CollectionDomain<E> collection) {
    throw new RuntimeException("Not implemented");
  }

  static ByteCursor get(InputStream stream) {
    return new InputStreamCursorImpl(stream);
  }
}
