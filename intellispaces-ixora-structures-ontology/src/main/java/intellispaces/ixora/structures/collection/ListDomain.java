package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;

/**
 * Homogeneous ordered list.
 *
 * @param <E> list element domain type.
 */
@Domain("f260fb9d-fd6f-4421-a609-71c672c8fffc")
public interface ListDomain<E> extends CollectionDomain<E> {

  /**
   * Downgrade mapping.
   */
  @Transition("01909079-ab91-75ba-8fd0-4a2cb5391791")
  CollectionDomain<E> asCollection();

  @Transition(value = "a8b23e74-2f8a-41eb-9427-a50e8274dc09", name = "ListToElementTransition")
  E get(int index);
}
