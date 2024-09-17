package intellispaces.ixora.structures.association;

import intellispaces.common.javastatement.type.Type;
import intellispaces.common.javastatement.type.Types;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.ixora.structures.collection.Collection;

import java.util.Collections;
import java.util.Map;

@ObjectHandle(value = MapDomain.class, name = "JavaMap")
public abstract class AbstractJavaMap<K, V> implements UnmovableMap<K, V> {
  private final java.util.Map<K, V> map;
  private final Type<K> keyDomain;
  private final Type<V> valueDomain;

  public AbstractJavaMap(java.util.Map<K, V> map, Class<K> keyDomain, Class<V> valueDomain) {
    this.map = Collections.unmodifiableMap(map);
    this.keyDomain = Types.of(keyDomain);
    this.valueDomain = Types.of(valueDomain);
  }

  public AbstractJavaMap(java.util.Map<K, V> map, Type<K> keyDomain, Type<V> valueDomain) {
    this.map = Collections.unmodifiableMap(map);
    this.keyDomain = keyDomain;
    this.valueDomain = valueDomain;
  }

  @Override
  public Type<MapDomain<K, V>> domain() {
    return Types.of(MapDomain.class, keyDomain, valueDomain);
  }

  @Override
  public Collection<KeyValuePair<K, V>> keyValuePairs() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public Map<K, V> nativeMap() {
    return map;
  }
}
