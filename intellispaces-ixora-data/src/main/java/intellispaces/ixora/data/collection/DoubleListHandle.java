package intellispaces.ixora.data.collection;

import intellispaces.jaquarius.annotation.Mapper;
import intellispaces.jaquarius.annotation.ObjectHandle;
import tech.intellispaces.entity.type.Type;
import tech.intellispaces.entity.type.Types;

import java.util.Arrays;

@ObjectHandle(DoubleListDomain.class)
abstract class DoubleListHandle implements UnmovableDoubleList {
  private final double[] array;
  private final Type<Double> elementType = Types.get(Double.class);
  private java.util.List<Double> list;

  DoubleListHandle(double[] array) {
    this.array = array;
  }

  DoubleListHandle(java.util.List<Double> list) {
    this.array = list.stream().mapToDouble(d -> d).toArray();
    this.list = list;
  }

  public double[] array() {
    return array;
  }

  @Mapper
  @Override
  public UnmovableCollection<Double> asCollection() {
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
    return getElement(index);
  }

  @Mapper
  @Override
  public double getPrimitive(int index) {
    return getElement(index);
  }

  private double getElement(int index) {
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
