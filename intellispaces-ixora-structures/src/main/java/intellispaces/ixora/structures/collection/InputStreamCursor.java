package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.MapperOfMoving;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.framework.core.exception.TraverseException;

import java.io.IOException;
import java.io.InputStream;

@ObjectHandle(value = ByteCursorDomain.class, name = "InputStreamCursorImpl")
abstract class InputStreamCursor implements MovableByteCursor {
  private final InputStream stream;
  private int buffer;

  InputStreamCursor(InputStream stream) {
    this.stream = stream;
  }

  @Mapper
  @Override
  public Class<Byte> elementDomain() {
    return Byte.class;
  }

  @Override
  @MapperOfMoving
  public Boolean next() {
    return hasNext();
  }

  @Override
  @MapperOfMoving
  public boolean nextPrimitive() {
    return hasNext();
  }

  private boolean hasNext() {
    try {
      buffer = stream.read();
      return (buffer != -1);
    } catch (IOException e) {
      throw TraverseException.withCauseAndMessage(e, "Could not go to the next element");
    }
  }

  @Mapper
  @Override
  public Byte value() {
    return getValue();
  }

  @Mapper
  @Override
  public byte valuePrimitive() {
    return getValue();
  }

  private byte getValue() {
    if (buffer == -1) {
      throw TraverseException.withMessage("End of the collection has been reached");
    }
    return (byte) buffer;
  }
}
