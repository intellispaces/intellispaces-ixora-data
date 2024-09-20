package intellispaces.ixora.structures.association;

public interface Propertieses {

  static UnmovableProperties of(java.util.Map<String, Object> map) {
    return new MapBasedPropertiesHandleImpl(map);
  }
}
