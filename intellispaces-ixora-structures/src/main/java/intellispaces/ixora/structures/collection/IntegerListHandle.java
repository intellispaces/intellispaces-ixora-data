package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.ObjectHandle;

import java.util.Arrays;
import java.util.List;

@ObjectHandle(value = IntegerListDomain.class, name = "IntegerListHandleImpl")
abstract class IntegerListHandle implements UnmovableIntegerList {
  private final int[] array;
  private final Type<Integer> elementType = Types.of(Integer.class);
  private java.util.List<Integer> list;

  IntegerListHandle(int[] array) {
    this.array = array;
  }

  IntegerListHandle(java.util.List<Integer> list) {
    this.array = list.stream().mapToInt(i -> i).toArray();
    this.list = list;
  }

  int[] array() {
    return array;
  }

  @Mapper
  @Override
  public Collection<Integer> asCollection() {
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
    return getPrimitive(index);
  }

//  @Mapper
//  @Override
  public int getPrimitive(int index) {
    return array[index];
  }

  @Mapper
  @Override
  public Integer size() {
    return array.length;
  }

  @Override
  public java.util.List<Integer> nativeList() {
    if (list == null) {
      list = Arrays.stream(array).boxed().toList();
    }
    return list;
  }

//  @Override
//  public java.util.Collection<Integer> nativeCollection() {
//    return nativeList();
//  }


  @Override
  public java.util.Collection<Integer> nativeCollection() {
    return List.of();
  }
}