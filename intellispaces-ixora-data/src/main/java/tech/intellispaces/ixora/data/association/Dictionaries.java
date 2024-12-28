package tech.intellispaces.ixora.data.association;

public interface Dictionaries {

  static UnmovableDictionary of(java.util.Map<String, Object> map) {
    return new MapBasedDictionaryImpl(map);
  }
}
