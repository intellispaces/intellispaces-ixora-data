package intellispaces.ixora.structures.collection;

import intellispaces.core.annotation.Mapper;
import intellispaces.core.annotation.UnmovableObjectHandle;
import intellispaces.ixora.structures.collection.UnmovableCollectionHandle;
import intellispaces.javastatements.type.Type;
import intellispaces.javastatements.type.Types;

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
