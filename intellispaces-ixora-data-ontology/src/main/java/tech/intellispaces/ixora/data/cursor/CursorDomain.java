package tech.intellispaces.ixora.data.cursor;

import tech.intellispaces.general.type.Type;
import tech.intellispaces.ixora.data.collection.CollectionDomain;
import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Domain;
import tech.intellispaces.jaquarius.traverse.TraverseTypes;

/**
 * One-sided cursor.
 *
 * @param <E> cursor element type.
 */
@Domain("3826cfd5-1b2a-4441-86b7-6ff0a9b2a7cd")
public interface CursorDomain<E> {

  @Channel("4d445fd4-4088-49a5-b0ba-fffd8c443b13")
  CollectionDomain<E> collection();

  @Channel("8816842b-3aa7-4421-b2c5-3ac5b3da9b24")
  Type<E> elementDomain();

  @Channel(
      value = "493c84b9-36cc-4312-b887-a37f8e21123e",
      name = "hasCursorNextElementChannel"
  )
  Boolean hasNext();

  /**
   * Moves cursor to the next item in the collection and return next item.
   */
  @Channel(
      value = "2bb07e04-f49d-4a13-85c3-f86f9a00f60c",
      allowedTraverse = TraverseTypes.MappingOfMoving
  )
  E next();
}
