package intellispaces.ixora.data.datastream;

import java.io.InputStream;

public interface DataStreams {

  static ByteInputStream get(InputStream is) {
    return new ByteInputStreamHandleImpl(is);
  }
}
