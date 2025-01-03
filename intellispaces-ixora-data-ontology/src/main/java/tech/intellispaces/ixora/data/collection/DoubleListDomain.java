package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.general.type.Type;
import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Domain;

/**
 * Alias for the domains NumberListDomain&lt;Double&gt;.
 */
@Domain("019081ff-e48c-773d-b6af-f6f3ec15ced9")
public interface DoubleListDomain extends NumberListDomain<Double> {

  /**
   * Downgrade mapping.
   */
  @Override
  @Channel("01909080-c97f-77f1-9a5a-f20dba6ed8a6")
  CollectionDomain<Double> asCollection();

  @Override
  @Channel(value = "7f2c28d4-a738-432b-8afa-f47e7e00a933", name = "DoubleListToElementChannel")
  Double get(Integer index);

  @Override
  @Channel("7e733832-f05f-46ce-abf3-b13ea4d53316")
  Type<Double> elementDomain();
}
