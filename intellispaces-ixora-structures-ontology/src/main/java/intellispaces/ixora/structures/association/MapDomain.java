package intellispaces.ixora.structures.association;

import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;
import intellispaces.ixora.structures.collection.CollectionDomain;

@Domain(value = "7fe5d4bb-a298-45a2-acc8-75b6bb4cb2f0")
public interface MapDomain<K, V> {

  @Transition("b766a35c-b544-4b84-9b5e-51dc8386e3cd")
  CollectionDomain<KeyValuePairDomain<K, V>> keyValuePairs();
}
