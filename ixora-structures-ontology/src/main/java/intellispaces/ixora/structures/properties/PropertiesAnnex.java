package intellispaces.ixora.structures.properties;

import tech.intellispaces.core.annotation.Preprocessing;

@Preprocessing(annexFor = Properties.class, artifact = "ObjectHandle")
public interface PropertiesAnnex<E> {

  java.util.Map<String, Object> nativeMap();
}
