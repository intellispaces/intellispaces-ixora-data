package intellispaces.ixora.structures.association;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnsTo = MapDomain.class, artifact = "ObjectHandle")
public interface MapAddOns<K, V> {

  java.util.Map<K, V> nativeMap();
}
