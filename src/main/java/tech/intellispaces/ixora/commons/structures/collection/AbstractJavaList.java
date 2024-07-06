package tech.intellispaces.ixora.commons.structures.collection;

import tech.intellispaces.framework.core.annotation.Mapper;
import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.ixora.structures.collection.ListUnmovableHandle;

import java.util.Collections;

@ObjectHandle("JavaList")
public abstract class AbstractJavaList<E> implements ListUnmovableHandle<E> {
  private final java.util.List<E> javaList;
  private final Class<E> elementDomainClass;

  public AbstractJavaList(java.util.List<E> javaList, Class<E> elementDomainClass) {
    this.javaList = Collections.unmodifiableList(javaList);
    this.elementDomainClass = elementDomainClass;
  }

  @Mapper
  @Override
  public Class<E> elementDomain() {
    return elementDomainClass;
  }

  @Mapper
  @Override
  public E element(int index) {
    return javaList.get(index);
  }

  @Mapper
  @Override
  public int size() {
    return javaList.size();
  }

  public java.util.List<E> javaList() {
    return javaList;
  }
}
