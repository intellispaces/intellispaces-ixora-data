package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.ObjectHandle;

import java.util.Collections;

@ObjectHandle(value = ListDomain.class, name = "JavaListHandleImpl")
abstract class JavaListHandle<E> implements UnmovableList<E> {
  private final java.util.List<E> list;
  private final Type<E> elementType;

  JavaListHandle(java.util.List<E> list, Class<E> elementClass) {
    this.list = Collections.unmodifiableList(list);
    this.elementType = Types.of(elementClass);
  }

  JavaListHandle(java.util.List<E> list, Type<E> elementType) {
    this.list = Collections.unmodifiableList(list);
    this.elementType = elementType;
  }

  @Mapper
  @Override
  public Collection<E> asCollection() {
    return new JavaCollectionHandleImpl<>(list, elementType);
  }

  @Override
  public Type<ListDomain<E>> domain() {
    return Types.of(ListDomain.class, elementType);
  }

  @Mapper
  @Override
  public Type<E> elementDomain() {
    return elementType;
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
