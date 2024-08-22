package intellispaces.ixora.structures.collection;

import intellispaces.ixora.core.Point;
import tech.intellispaces.core.annotation.Domain;
import tech.intellispaces.core.annotation.Transition;
import tech.intellispaces.javastatements.type.Type;

/**
 * Homogeneous collection of elements.
 *
 * @param <E> collection element domain type.
 */
@Domain("715d235a-b6ee-4a0a-8166-dd908d6bf026")
public interface Collection<E> extends Point {

  @Transition("855a617e-1281-4f23-ac3b-be45e045b337")
  Type<E> elementDomain();

  @Transition("ac251f1d-ecd8-45a0-bd05-972c71ed26aa")
  int size();
}
