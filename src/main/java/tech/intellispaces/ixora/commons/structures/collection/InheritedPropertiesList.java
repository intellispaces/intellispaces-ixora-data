package tech.intellispaces.ixora.commons.structures.collection;

import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.ixora.structures.collection.ListHandle;
import tech.intellispaces.ixora.structures.collection.ListUnmovableHandle;
import tech.intellispaces.ixora.structures.properties.Properties;
import tech.intellispaces.ixora.structures.properties.PropertiesHandle;
import tech.intellispaces.ixora.structures.properties.PropertiesListUnmovableHandle;

@ObjectHandle
public class InheritedPropertiesList implements PropertiesListUnmovableHandle {
  private final ListUnmovableHandle<Properties> backList;

  public InheritedPropertiesList(ListUnmovableHandle<Properties> backList) {
    this.backList = backList;
  }

  @Override
  public ListHandle<Properties> asList() {
    return backList;
  }

  @Override
  public PropertiesHandle element(int index) {
    return (PropertiesHandle) backList.element(index);
  }

  @Override
  public int size() {
    return backList.size();
  }
}
