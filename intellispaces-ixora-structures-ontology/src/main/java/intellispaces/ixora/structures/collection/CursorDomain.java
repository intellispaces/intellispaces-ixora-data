package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;
import intellispaces.framework.core.traverse.TraverseTypes;
import intellispaces.ixora.base.PointDomain;

/**
 * One-way cursor.
 *
 * @param <E> cursor element type.
 */
@Domain("3826cfd5-1b2a-4441-86b7-6ff0a9b2a7cd")
public interface CursorDomain<E> extends PointDomain {

  @Transition("4d445fd4-4088-49a5-b0ba-fffd8c443b13")
  CollectionDomain<E> collection();

  @Transition("8816842b-3aa7-4421-b2c5-3ac5b3da9b24")
  Class<E> elementDomain();

  @Transition("3089ff8a-0bfc-4ad0-ad58-093b84690e66")
  E value();

  @Transition("de7656ee-b072-431e-935e-176fd42bfbe7")
  ListDomain<E> values(int count);

  @Transition("22a53488-46f1-4727-bebf-1ed04c76a51e")
  boolean hasNext();

  @Transition(value = "493c84b9-36cc-4312-b887-a37f8e21123e", allowedTraverse = TraverseTypes.Moving)
  CursorDomain<E> shift();
}
