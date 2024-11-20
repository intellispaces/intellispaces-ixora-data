package intellispaces.ixora.data.collection;

import intellispaces.jaquarius.annotation.Channel;
import intellispaces.jaquarius.annotation.Domain;
import tech.intellispaces.entity.type.Type;

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
  Byte get(int index);

  @Override
  @Channel("e151b008-acd1-4dda-9ddb-e7c78b5e34ef")
  Type<Byte> elementDomain();
}
