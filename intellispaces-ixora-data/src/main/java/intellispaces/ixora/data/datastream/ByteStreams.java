package intellispaces.ixora.data.datastream;

import java.io.InputStream;

public interface ByteStreams {

  static MovableByteInputStream get(InputStream is) {
    return new ByteInputStreamHandleImpl(is);
  }

  static MovableByteInputStream empty() {
    return get(InputStream.nullInputStream());
  }
}
