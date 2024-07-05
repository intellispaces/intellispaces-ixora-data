package tech.intellispaces.ixora.commons.structures.collection;

import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.ixora.structures.collection.ListHandle;
import tech.intellispaces.ixora.structures.collection.ListUnmovableHandle;
import tech.intellispaces.ixora.structures.collection.StringListUnmovableHandle;

@ObjectHandle
public class BasicStringListUnmovableHandle implements StringListUnmovableHandle {
  private final ListUnmovableHandle<String> backList;

  public BasicStringListUnmovableHandle(ListUnmovableHandle<String> backList) {
    this.backList = backList;
  }

  @Override
  public ListHandle<String> asList() {
    return backList;
  }

  @Override
  public String element(int index) {
    return backList.element(index);
  }

  @Override
  public int size() {
    return backList.size();
  }
}
