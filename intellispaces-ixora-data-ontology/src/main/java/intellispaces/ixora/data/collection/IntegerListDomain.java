package intellispaces.ixora.data.collection;

import intellispaces.jaquarius.annotation.Channel;
import intellispaces.jaquarius.annotation.Domain;
import tech.intellispaces.entity.type.Type;

/**
 * Alias for the domain ListDomain&lt;Integer&gt;.
 */
@Domain("019081b8-bfb3-7089-9d6c-6537ab3fca07")
public interface IntegerListDomain extends NumberListDomain<Integer> {

  /**
   * Downgrade mapping.
   */
//  @Override
//  @Channel("01909080-8b2e-798a-8467-150465a39848")
//  CollectionDomain<Integer> asCollection();

  @Override
  @Channel(value = "fa8d530a-7e9d-49e1-a7f3-0956d3460ac5", name = "IntegerListToElementChannel")
  Integer get(int index);

  @Override
  @Channel("a3299ab9-f126-45ce-af23-e2d7be814bce")
  Type<Integer> elementDomain();
}
