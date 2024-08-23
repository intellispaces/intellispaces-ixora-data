package ixora.structures.collection;

import intellispaces.core.annotation.Domain;
import intellispaces.core.annotation.Transition;
import intellispaces.javastatements.type.Type;
import intellispaces.javastatements.type.Types;

@Domain("019081ff-e48c-773d-b6af-f6f3ec15ced9")
public interface DoubleListDomain extends NumberListDomain<Double> {

  /**
   * Downgrade mapping.
   */
  @Transition("eefb92ad-01ff-4600-b475-4d689f4c79be")
  NumberListDomain<Double> asNumberList();

  /**
   * Downgrade mapping.
   */
  @Transition("01908254-ac97-7643-8cce-d058caad1aba")
  ListDomain<Double> asList();

  /**
   * Downgrade mapping.
   */
  @Override
  @Transition("01909080-c97f-77f1-9a5a-f20dba6ed8a6")
  CollectionDomain<Double> asCollection();

  @Override
  default Type<Double> elementDomain() {
    return Types.of(Double.class);
  }

  @Override
  Double element(int index);
}
