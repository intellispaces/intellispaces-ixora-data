package tech.intellispaces.ixora.commons.structures.collection;

import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.ixora.structures.collection.IntegerListUnmovableHandle;
import tech.intellispaces.ixora.structures.collection.ListHandle;
import tech.intellispaces.ixora.structures.collection.ListUnmovableHandle;

@ObjectHandle
public class InheritedIntegerList implements IntegerListUnmovableHandle {
  private final ListUnmovableHandle<Integer> backList;

  public InheritedIntegerList(ListUnmovableHandle<Integer> backList) {
    this.backList = backList;
  }

  @Override
  public ListHandle<Integer> asList() {
    return backList;
  }

  @Override
  public Integer element(int index) {
    return backList.element(index);
  }

  @Override
  public int size() {
    return backList.size();
  }
}
