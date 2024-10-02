package intellispaces.ixora.structures.association;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Ontology;
import intellispaces.ixora.structures.exception.InvalidPropertyException;

@Ontology
public interface PropertiesOntology {

  @Channel("1830e924-2c78-4f18-b9eb-39f002cbeea6")
  PropertiesDomain yamlStringToProperties(String string) throws InvalidPropertyException;

  @Channel("cafc0a2e-a1da-44e1-997f-2db62f7e385c")
  <D> D propertiesToData(PropertiesDomain properties, Class<? extends D> dataClass);
}
