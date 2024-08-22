package intellispaces.ixora.structures.collection;

import tech.intellispaces.core.annotation.Domain;
import tech.intellispaces.core.annotation.Transition;
import tech.intellispaces.javastatements.type.Type;
import tech.intellispaces.javastatements.type.Types;

@Domain("019081ff-e48c-773d-b6af-f6f3ec15ced9")
public interface DoubleList extends NumberList<Double> {

  /**
   * Downgrade mapping.
   */
  @Transition("eefb92ad-01ff-4600-b475-4d689f4c79be")
  NumberList<Double> asNumberList();

  /**
   * Downgrade mapping.
   */
  @Transition("01908254-ac97-7643-8cce-d058caad1aba")
  List<Double> asList();

  /**
   * Downgrade mapping.
   */
  @Override
  @Transition("01909080-c97f-77f1-9a5a-f20dba6ed8a6")
  Collection<Double> asCollection();

  @Override
  default Type<Double> elementDomain() {
    return Types.of(Double.class);
  }

  @Override
  Double element(int index);
}
