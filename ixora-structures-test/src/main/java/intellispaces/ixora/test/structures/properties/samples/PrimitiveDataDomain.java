package intellispaces.ixora.test.structures.properties.samples;

import intellispaces.core.annotation.Data;
import intellispaces.core.annotation.Domain;
import intellispaces.core.annotation.Transition;

@Data
@Domain
public interface PrimitiveDataDomain {

  @Transition("756b6fa0-5d0c-4143-bf40-fcf171ae9fe9")
  int intValue();

  @Transition("3b17bdd4-525c-4616-890f-444045e65346")
  double doubleValue();
}
