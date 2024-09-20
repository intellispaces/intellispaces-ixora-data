package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.ObjectHandle;

@ObjectHandle(value = CollectionDomain.class, name = "JavaCollectionHandleImpl")
public abstract class JavaCollectionHandle<E> implements UnmovableCollection<E> {
  private final java.util.Collection<E> collection;
  private final Type<E> elementDomain;

  public JavaCollectionHandle(java.util.Collection<E> collection, Class<E> elementClass) {
    this.collection = collection;
    this.elementDomain = Types.of(elementClass);
  }

  public JavaCollectionHandle(java.util.Collection<E> collection, Type<E> elementType) {
    this.collection = collection;
    this.elementDomain = elementType;
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
  public int size() {
    return collection.size();
  }

  @Override
  public java.util.Collection<E> nativeCollection() {
    return collection;
  }
}
