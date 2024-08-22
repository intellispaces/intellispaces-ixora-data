package intellispaces.ixora.structures.collection;

import tech.intellispaces.core.annotation.Domain;
import tech.intellispaces.core.annotation.Transition;

/**
 * List of numbers.
 *
 * @param <E> list element domain type.
 */
@Domain("01908c74-4692-7fe2-8f51-375bda2efc40")
public interface NumberList<E extends Number> extends List<E> {

  /**
   * Downgrade mapping.
   */
  @Transition("01908c74-6c7e-7890-96cd-9dc2531999ef")
  List<E> asList();
}
