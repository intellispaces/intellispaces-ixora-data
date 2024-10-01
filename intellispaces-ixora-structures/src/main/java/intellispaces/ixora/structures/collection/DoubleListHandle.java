package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.ObjectHandle;

import java.util.Arrays;

@ObjectHandle(value = DoubleListDomain.class, name = "DoubleListHandleImpl")
abstract class DoubleListHandle implements UnmovableDoubleList {
  private final double[] array;
  private final Type<Double> elementType = Types.of(Double.class);
  private java.util.List<Double> list;

  DoubleListHandle(double[] array) {
    this.array = array;
  }

  DoubleListHandle(java.util.List<Double> list) {
    this.array = list.stream().mapToDouble(d -> d).toArray();
    this.list = list;
  }

  double[] array() {
    return array;
  }

  @Mapper
  @Override
  public Collection<Double> asCollection() {
    return new CollectionHandleImpl<>(nativeList(), elementType);
  }

  @Mapper
  @Override
  public Type<Double> elementDomain() {
    return elementType;
  }

  @Mapper
  @Override
  public Double get(int index) {
    return getPrimitive(index);
  }

//  @Mapper
//  @Override
  public double getPrimitive(int index) {
    return array[index];
  }

  @Mapper
  @Override
  public Integer size() {
    return array.length;
  }

  @Override
  public java.util.List<Double> nativeList() {
    if (list == null) {
      list = Arrays.stream(array).boxed().toList();
    }
    return list;
  }

  @Override
  public java.util.Collection<Double> nativeCollection() {
    return nativeList();
  }
}