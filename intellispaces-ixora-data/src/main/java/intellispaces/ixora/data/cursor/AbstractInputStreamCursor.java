package intellispaces.ixora.data.cursor;

import intellispaces.framework.core.exception.TraverseException;

import java.io.IOException;
import java.io.InputStream;

public class AbstractInputStreamCursor {
  private final InputStream is;
  private int buffer;
  private boolean buffered;

  protected AbstractInputStreamCursor(InputStream is) {
    this.is = is;
  }

  protected boolean hasNextElement() {
    if (buffered) {
      return true;
    }

    try {
      buffer = is.read();
      buffered = (buffer != -1);
      return buffered;
    } catch (IOException e) {
      throw TraverseException.withCauseAndMessage(e, "Could not read the next element of input stream");
    }
  }

  protected byte nextElement() {
    if (buffered) {
      buffered = false;
      return (byte) buffer;
    }

    try {
      buffer = is.read();
      if (buffer == -1) {
        throw TraverseException.withMessage("The input stream is exhausted");
      }
      buffered = false;
      return (byte) buffer;
    } catch (IOException e) {
      throw TraverseException.withCauseAndMessage(e, "Could not read the next element of input stream");
    }
  }
}
