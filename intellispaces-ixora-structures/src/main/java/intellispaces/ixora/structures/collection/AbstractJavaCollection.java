package intellispaces.ixora.structures.collection;

import intellispaces.common.javastatement.type.Type;
import intellispaces.common.javastatement.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.ObjectHandle;

@ObjectHandle(value = CollectionDomain.class, name = "JavaCollection")
public abstract class AbstractJavaCollection<E> implements UnmovableCollection<E> {
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
