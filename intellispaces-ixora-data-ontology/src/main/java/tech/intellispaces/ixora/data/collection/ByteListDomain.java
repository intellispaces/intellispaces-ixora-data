package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.general.type.Type;
import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Domain;

/**
 * Alias for the domains NumberListDomain&lt;Byte&gt;.
 */
@Domain("46127f8a-6396-4bb8-8af4-d85ebd37f143")
public interface ByteListDomain extends NumberListDomain<Byte> {

  /**
   * Downgrade mapping.
   */
  @Override
  @Channel("306a5434-65fc-4c81-8ec5-2804ffff99b6")
  CollectionDomain<Byte> asCollection();

  @Override
  @Channel(value = "f5bf6431-109a-4906-a54d-d30755a623c9", name = "ByteListToElementChannel")
  Byte get(Integer index);

  @Override
  @Channel("e151b008-acd1-4dda-9ddb-e7c78b5e34ef")
  Type<Byte> elementDomain();
}
