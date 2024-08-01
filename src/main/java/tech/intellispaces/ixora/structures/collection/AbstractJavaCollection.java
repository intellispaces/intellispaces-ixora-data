package tech.intellispaces.ixora.structures.collection;

import intellispaces.ixora.structures.collection.Collection;
import intellispaces.ixora.structures.collection.UnmovableCollectionHandle;
import tech.intellispaces.core.annotation.UnmovableObjectHandle;
import tech.intellispaces.javastatements.type.Type;
import tech.intellispaces.javastatements.type.Types;

@UnmovableObjectHandle("JavaCollection")
public abstract class AbstractJavaCollection<E> implements UnmovableCollectionHandle<E> {
  private final java.util.Collection<E> collection;
  private final Type<E> elementDomain;

  public AbstractJavaCollection(java.util.Collection<E> collection, Class<E> elementDomain) {
    this.collection = collection;
    this.elementDomain = Types.of(elementDomain);
  }

  public AbstractJavaCollection(java.util.Collection<E> collection, Type<E> elementDomain) {
    this.collection = collection;
    this.elementDomain = elementDomain;
  }

  @Override
  public Type<Collection<E>> domain() {
    return Types.of(Collection.class, elementDomain);
  }

  @Override
  public Type<E> elementDomain() {
    return elementDomain;
  }

  @Override
  public int size() {
    return collection.size();
  }

  @Override
  public java.util.Collection<E> nativeCollection() {
    return collection;
  }
}
