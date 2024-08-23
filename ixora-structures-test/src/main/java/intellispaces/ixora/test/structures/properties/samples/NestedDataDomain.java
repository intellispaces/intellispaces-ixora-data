package intellispaces.ixora.test.structures.properties.samples;

import intellispaces.core.annotation.Data;
import intellispaces.core.annotation.Domain;
import intellispaces.core.annotation.Transition;

@Data
@Domain("b833c1fc-e71e-43fc-b996-f8869642c807")
public interface NestedDataDomain {

  @Transition("8119ce95-9bc3-4825-858b-babdab0014ed")
  String stringValue();

  @Transition("8a17ef38-5f5b-4bd4-9c3a-a4c0c3fa37ef")
  NestedDataDomain nestedValue();
}
