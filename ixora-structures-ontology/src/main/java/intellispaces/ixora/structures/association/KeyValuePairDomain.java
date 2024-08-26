package intellispaces.ixora.structures.association;

import intellispaces.core.annotation.Domain;
import intellispaces.core.annotation.Transition;

@Domain("8f00a2aa-f70d-4064-b517-e7f15642c805")
public interface KeyValuePairDomain<K, V> {

  @Transition("ac7048b7-9967-4eba-877b-019d19e16d05")
  K key();

  @Transition("9e331b76-deae-4411-98ad-ca402a747a2e")
  V value();
}
