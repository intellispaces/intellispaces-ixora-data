package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.javastatement.type.Types;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;

/**
 * Synonym for the domains NumberListDomain&lt;Byte&gt; and ListDomain&lt;Byte&gt;.
 */
@Domain("46127f8a-6396-4bb8-8af4-d85ebd37f143")
public interface ByteListDomain extends NumberListDomain<Byte> {

  /**
   * Downgrade mapping.
   */
  @Transition("327223ba-35ce-4cc7-b2b0-cd8109946454")
  ListDomain<Byte> asList();

  /**
   * Downgrade mapping.
   */
  @Override
  @Transition("306a5434-65fc-4c81-8ec5-2804ffff99b6")
  CollectionDomain<Byte> asCollection();

  @Override
  default Type<Byte> elementDomain() {
    return Types.of(Byte.class);
  }

  @Override
  Byte element(int index);
}
