package intellispaces.ixora.structures.association;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(annexFor = MapDomain.class, artifact = "ObjectHandle")
public interface MapAnnex<K, V> {

  java.util.Map<K, V> nativeMap();
}
