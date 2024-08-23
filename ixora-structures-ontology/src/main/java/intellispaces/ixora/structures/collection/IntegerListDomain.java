package intellispaces.ixora.structures.collection;

import intellispaces.core.annotation.Domain;
import intellispaces.core.annotation.Transition;
import intellispaces.javastatements.type.Type;
import intellispaces.javastatements.type.Types;

@Domain("019081b8-bfb3-7089-9d6c-6537ab3fca07")
public interface IntegerListDomain extends NumberListDomain<Integer> {

  /**
   * Downgrade mapping.
   */
  @Transition("35c4c1c4-0bae-489a-9a20-2259eb58c135")
  NumberListDomain<Integer> asNumberList();

  /**
   * Downgrade mapping.
   */
  @Transition("0190824d-8716-7f90-8c49-fa9a6ee24bcb")
  ListDomain<Integer> asList();

  /**
   * Downgrade mapping.
   */
  @Override
  @Transition("01909080-8b2e-798a-8467-150465a39848")
  CollectionDomain<Integer> asCollection();

  @Override
  default Type<Integer> elementDomain() {
    return Types.of(Integer.class);
  }

  @Override
  Integer element(int index);
}
