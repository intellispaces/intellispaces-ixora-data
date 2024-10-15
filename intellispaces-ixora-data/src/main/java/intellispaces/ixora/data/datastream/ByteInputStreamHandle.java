package intellispaces.ixora.data.datastream;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.MapperOfMoving;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.ixora.data.cursor.AbstractInputStreamCursor;

import java.io.InputStream;

@ObjectHandle(ByteInputStreamDomain.class)
abstract class ByteInputStreamHandle extends AbstractInputStreamCursor implements MovableByteInputStream {

  ByteInputStreamHandle(InputStream is) {
    super(is);
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
}
