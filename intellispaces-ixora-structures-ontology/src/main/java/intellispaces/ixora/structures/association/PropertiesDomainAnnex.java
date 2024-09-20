package intellispaces.ixora.structures.association;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(annexFor = PropertiesDomain.class, artifact = "ObjectHandle")
public interface PropertiesDomainAnnex<E> {

  java.util.Map<String, Object> nativeMap();
}
