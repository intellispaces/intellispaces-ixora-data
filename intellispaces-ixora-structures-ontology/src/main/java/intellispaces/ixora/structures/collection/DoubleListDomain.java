package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.javastatement.type.Types;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;

/**
 * Synonym for the domains NumberListDomain&lt;Double&gt; and ListDomain&lt;Byte&gt;.
 */
@Domain("019081ff-e48c-773d-b6af-f6f3ec15ced9")
public interface DoubleListDomain extends NumberListDomain<Double> {

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
