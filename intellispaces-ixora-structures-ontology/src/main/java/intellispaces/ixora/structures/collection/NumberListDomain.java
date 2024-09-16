package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;

/**
 * List of numbers.
 *
 * @param <E> list element domain type.
 */
@Domain("01908c74-4692-7fe2-8f51-375bda2efc40")
public interface NumberListDomain<E extends Number> extends ListDomain<E> {

  /**
   * Downgrade mapping.
   */
  @Transition("01908c74-6c7e-7890-96cd-9dc2531999ef")
  ListDomain<E> asList();
}
