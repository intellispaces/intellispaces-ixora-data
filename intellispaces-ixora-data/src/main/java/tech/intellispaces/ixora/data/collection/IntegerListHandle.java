package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.general.type.Type;
import tech.intellispaces.general.type.Types;
import tech.intellispaces.jaquarius.annotation.Mapper;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;

import java.util.Arrays;
import java.util.List;

@ObjectHandle(IntegerListDomain.class)
abstract class IntegerListHandle implements UnmovableIntegerList {
  private final int[] array;
  private final Type<Integer> elementType = Types.get(Integer.class);
  private java.util.List<Integer> list;

  IntegerListHandle(int[] array) {
    this.array = array;
  }

  IntegerListHandle(java.util.List<Integer> list) {
    this.array = list.stream().mapToInt(i -> i).toArray();
    this.list = list;
  }

  public int[] array() {
    return array;
  }

  @Mapper
  @Override
  public UnmovableCollection<Integer> asCollection() {
    return new CollectionHandleImpl<>(nativeList(), elementType);
  }

  @Mapper
  @Override
  public Type<Integer> elementDomain() {
    return elementType;
  }

  @Mapper
  @Override
  public Integer get(int index) {
    return getElement(index);
  }

  @Mapper
  @Override
  public int getPrimitive(int index) {
    return getElement(index);
  }

  private int getElement(int index) {
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
  public java.util.List<Integer> nativeList() {
    if (list == null) {
      list = Arrays.stream(array).boxed().toList();
    }
    return list;
  }

  @Override
  public java.util.Collection<Integer> nativeCollection() {
    return List.of();
  }
}

