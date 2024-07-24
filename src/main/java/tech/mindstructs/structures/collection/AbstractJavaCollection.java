package tech.mindstructs.structures.collection;

import intellispaces.ixora.mindstructs.structures.collection.UnmovableCollectionHandle;
import tech.intellispaces.framework.core.annotation.ObjectHandle;

import java.util.Collection;

@ObjectHandle("JavaCollection")
public abstract class AbstractJavaCollection<E> implements UnmovableCollectionHandle<E> {
  private final java.util.Collection<E> collection;
  private final Class<E> elementDomainClass;

  public AbstractJavaCollection(Collection<E> collection, Class<E> elementDomainClass) {
    this.collection = collection;
    this.elementDomainClass = elementDomainClass;
  }

  @Override
  public Collection<? extends E> nativeCollection() {
    return collection;
  }

  @Override
  public Class<? extends E> elementDomain() {
    return elementDomainClass;
  }

  @Override
  public int size() {
    return collection.size();
  }
}
