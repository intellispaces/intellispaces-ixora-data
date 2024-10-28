package intellispaces.ixora.data.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.jaquarius.annotation.Mapper;
import intellispaces.jaquarius.annotation.ObjectHandle;

import java.util.List;

@ObjectHandle(ListDomain.class)
abstract class ListHandle<E> implements UnmovableList<E> {
  private final java.util.List<E> list;
  private final Type<E> elementType;

  ListHandle(java.util.List<E> list, Class<E> elementClass) {
    this.list = java.util.Collections.unmodifiableList(list);
    this.elementType = Types.of(elementClass);
  }

  ListHandle(java.util.List<E> list, Type<E> elementType) {
    this.list = java.util.Collections.unmodifiableList(list);
    this.elementType = elementType;
  }

  List<E> list() {
    return list;
  }

  @Mapper
  @Override
  public UnmovableCollection<E> asCollection() {
    return Collections.of(list, elementType);
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
  public E get(int index) {
    return list.get(index);
  }

  @Mapper
  @Override
  public Integer size() {
    return list.size();
  }

  @Mapper
  @Override
  public int sizePrimitive() {
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
