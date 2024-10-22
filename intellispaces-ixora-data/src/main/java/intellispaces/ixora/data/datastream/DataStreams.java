package intellispaces.ixora.data.datastream;

import java.io.InputStream;

public interface DataStreams {

  static MovableByteInputStream get(InputStream is) {
    return new ByteInputStreamHandleImpl(is);
  }
}
