package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.entity.type.Type;
import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Domain;

/**
 * Homogeneous collection of elements.
 *
 * @param <E> collection element domain type.
 */
@Domain("715d235a-b6ee-4a0a-8166-dd908d6bf026")
public interface CollectionDomain<E> {

  @Channel("855a617e-1281-4f23-ac3b-be45e045b337")
  Type<E> elementDomain();

  @Channel("ac251f1d-ecd8-45a0-bd05-972c71ed26aa")
  Integer size();
}
