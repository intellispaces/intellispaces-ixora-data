package intellispaces.ixora.structures.properties;

import intellispaces.framework.core.annotation.Ontology;
import intellispaces.framework.core.annotation.Transition;
import intellispaces.ixora.structures.exception.InvalidPropertyException;

@Ontology
public interface PropertiesOntology {

  @Transition("1830e924-2c78-4f18-b9eb-39f002cbeea6")
  PropertiesDomain yamlStringToProperties(String string) throws InvalidPropertyException;

  @Transition("cafc0a2e-a1da-44e1-997f-2db62f7e385c")
  <D> D propertiesToData(PropertiesDomain properties, Class<? extends D> dataClass);
}
