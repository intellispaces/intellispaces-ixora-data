package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.entity.collection.ArraysFunctions;
import tech.intellispaces.entity.type.Type;
import tech.intellispaces.entity.type.Types;
import tech.intellispaces.jaquarius.annotation.Mapper;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;

import java.util.List;

@ObjectHandle(ByteListDomain.class)
abstract class ByteListHandle implements UnmovableByteList {
  private final Type<Byte> elementType = Types.get(Byte.class);
  private final byte[] array;
  private List<Byte> list;

  ByteListHandle(byte[] array) {
    this.array = array;
  }

  ByteListHandle(List<Byte> list) {
    this.array = ArraysFunctions.toByteArray(list);
    this.list = list;
  }

  public byte[] array() {
    return array;
  }

  @Mapper
  @Override
  public UnmovableCollection<Byte> asCollection() {
    return new CollectionHandleImpl<>(nativeList(), elementType);
  }

  @Mapper
  @Override
  public Type<Byte> elementDomain() {
    return elementType;
  }

  @Mapper
  @Override
  public Byte get(int index) {
    return getElement(index);
  }

  @Mapper
  @Override
  public byte getPrimitive(int index) {
    return getElement(index);
  }

  private byte getElement(int index) {
    return array[index];
  }

  @Mapper
  @Override
  public Integer size() {
    return getSize();
  }

  @Mapper
  @Override
  public int sizePrimitive() {
    return getSize();
  }

  private int getSize() {
    return array.length;
  }

  @Override
  public List<Byte> nativeList() {
    if (list == null) {
      list = ArraysFunctions.toByteList(array);
    }
    return list;
  }

  @Override
  public java.util.Collection<Byte> nativeCollection() {
    return List.of();
  }
}

