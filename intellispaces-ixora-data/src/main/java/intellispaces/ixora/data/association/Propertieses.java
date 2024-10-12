package intellispaces.ixora.data.association;

public interface Propertieses {

  static UnmovableProperties of(java.util.Map<String, Object> map) {
    return new MapBasedPropertiesHandleImpl(map);
  }
}
