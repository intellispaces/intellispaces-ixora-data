package intellispaces.ixora.data.datastream;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.MapperOfMoving;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.framework.core.exception.TraverseException;

import java.io.IOException;
import java.io.InputStream;

@ObjectHandle(ByteInputStreamDomain.class)
abstract class ByteInputStreamHandle implements MovableByteInputStream {
  private final InputStream is;
  private int buffer;
  private boolean buffered;

  ByteInputStreamHandle(InputStream is) {
    this.is = is;
  }

  @Mapper
  @Override
  public Type<Byte> elementDomain() {
    return Types.of(Byte.class);
  }

  @Mapper
  @Override
  public Boolean isExhausted() {
    return hasNextElement();
  }

  @Mapper
  @Override
  public boolean isExhaustedPrimitive() {
    return hasNextElement();
  }

  @Override
  @MapperOfMoving
  public Byte read() {
    return nextElement();
  }

  @Override
  @MapperOfMoving
  public byte readPrimitive() {
    return nextElement();
  }

  private boolean hasNextElement() {
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

  private byte nextElement() {
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
