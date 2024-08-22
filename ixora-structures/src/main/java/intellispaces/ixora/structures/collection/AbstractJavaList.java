package intellispaces.ixora.structures.collection;

import intellispaces.core.annotation.Mapper;
import intellispaces.core.annotation.UnmovableObjectHandle;
import intellispaces.ixora.structures.collection.CollectionHandle;
import intellispaces.ixora.structures.collection.UnmovableListHandle;
import intellispaces.javastatements.type.Type;
import intellispaces.javastatements.type.Types;

import java.util.Collections;

@UnmovableObjectHandle("JavaList")
public abstract class AbstractJavaList<E> implements UnmovableListHandle<E> {
  private final java.util.List<E> list;
  private final Type<E> elementDomain;

  public AbstractJavaList(java.util.List<E> list, Class<E> elementDomain) {
    this.list = Collections.unmodifiableList(list);
    this.elementDomain = Types.of(elementDomain);
  }

  public AbstractJavaList(java.util.List<E> list, Type<E> elementDomain) {
    this.list = Collections.unmodifiableList(list);
    this.elementDomain = elementDomain;
  }

  @Mapper
  @Override
  public CollectionHandle<E> asCollection() {
    return new JavaCollection<>(list, elementDomain);
  }

  @Override
  public Type<List<E>> domain() {
    return Types.of(List.class, elementDomain);
  }

  @Mapper
  @Override
  public Type<E> elementDomain() {
    return elementDomain;
  }

  @Mapper
  @Override
  public E element(int index) {
    return list.get(index);
  }

  @Mapper
  @Override
  public int size() {
    return list.size();
  }

  @Override
  public java.util.List<E> nativeList() {
    return list;
  }

  @Override
  public java.util.Collection<E> nativeCollection() {
    return list;
  }
}
