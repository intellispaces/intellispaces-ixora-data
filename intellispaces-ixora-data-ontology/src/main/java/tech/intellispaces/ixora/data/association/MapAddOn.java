package tech.intellispaces.ixora.data.association;

import tech.intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(addOnFor = MapDomain.class, artifact = "ObjectHandle")
public interface MapAddOn<K, V> {

  java.util.Map<K, V> nativeMap();
}
