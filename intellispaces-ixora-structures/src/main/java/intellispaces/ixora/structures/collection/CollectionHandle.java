package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.ObjectHandle;

import java.util.Collection;

@ObjectHandle(value = CollectionDomain.class, name = "CollectionHandleImpl")
abstract class CollectionHandle<E> implements UnmovableCollection<E> {
  private final java.util.Collection<E> collection;
  private final Type<E> elementDomain;

  CollectionHandle(java.util.Collection<E> collection, Class<E> elementClass) {
    this.collection = collection;
    this.elementDomain = Types.of(elementClass);
  }

  CollectionHandle(java.util.Collection<E> collection, Type<E> elementType) {
    this.collection = collection;
    this.elementDomain = elementType;
  }

  Collection<E> collection() {
    return collection;
  }

  @Override
  public Type<CollectionDomain<E>> domain() {
    return Types.of(CollectionDomain.class, elementDomain);
  }

  @Mapper
  @Override
  public Type<E> elementDomain() {
    return elementDomain;
  }

  @Mapper
  @Override
  public Integer size() {
    return collection.size();
  }

  @Override
  public java.util.Collection<E> nativeCollection() {
    return collection;
  }
}
