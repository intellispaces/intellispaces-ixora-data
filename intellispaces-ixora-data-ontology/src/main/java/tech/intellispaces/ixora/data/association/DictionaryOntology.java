package tech.intellispaces.ixora.data.association;

import tech.intellispaces.ixora.data.exception.InvalidPropertyException;
import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Ontology;

@Ontology
public interface DictionaryOntology {

  @Channel("1830e924-2c78-4f18-b9eb-39f002cbeea6")
  DictionaryDomain yamlStringToDictionary(String string) throws InvalidPropertyException;

  @Channel("cafc0a2e-a1da-44e1-997f-2db62f7e385c")
  <D> D dictionaryToData(DictionaryDomain dictionary, Class<? extends D> dataClass);
}
