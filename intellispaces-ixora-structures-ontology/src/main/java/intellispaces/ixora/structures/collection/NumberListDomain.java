package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Domain;

/**
 * List of numbers.</p>
 *
 * Alias for the domain ListDomain&lt;Number&gt;.
 *
 * @param <N> list element domain type.
 */
@Domain("01908c74-4692-7fe2-8f51-375bda2efc40")
public interface NumberListDomain<N extends Number> extends ListDomain<N> {

  /**
   * Downgrade mapping.
   */
  @Override
  @Channel("390f8f03-3622-4bbf-8df4-11e48c897d94")
  CollectionDomain<N> asCollection();

  @Override
  @Channel("2c16d0ca-619d-4a17-a680-655bd98d78f1")
  Type<N> elementDomain();
}
