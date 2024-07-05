package tech.intellispaces.ixora.commons.structures.collection;

import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.ixora.structures.collection.DoubleListUnmovableHandle;
import tech.intellispaces.ixora.structures.collection.ListHandle;
import tech.intellispaces.ixora.structures.collection.ListUnmovableHandle;

@ObjectHandle
public class BasicDoubleListUnmovableHandle implements DoubleListUnmovableHandle {
  private final ListUnmovableHandle<Double> backList;

  public BasicDoubleListUnmovableHandle(ListUnmovableHandle<Double> backList) {
    this.backList = backList;
  }

  @Override
  public ListHandle<Double> asList() {
    return backList;
  }

  @Override
  public Double element(int index) {
    return backList.element(index);
  }

  @Override
  public int size() {
    return backList.size();
  }
}
