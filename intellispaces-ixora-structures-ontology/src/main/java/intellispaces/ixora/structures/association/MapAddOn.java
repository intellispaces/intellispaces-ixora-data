package intellispaces.ixora.structures.association;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnFor = MapDomain.class, artifact = "ObjectHandle")
public interface MapAddOn<K, V> {

  java.util.Map<K, V> nativeMap();
}
