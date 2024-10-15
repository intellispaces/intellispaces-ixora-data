package intellispaces.ixora.data.cursor;

import intellispaces.ixora.data.collection.CollectionDomain;

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

  static ByteCursor get(InputStream is) {
    return new InputStreamCursorHandleImpl(is);
  }
}
