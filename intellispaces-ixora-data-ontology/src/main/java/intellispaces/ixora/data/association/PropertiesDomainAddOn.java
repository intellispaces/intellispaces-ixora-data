package intellispaces.ixora.data.association;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnFor = PropertiesDomain.class, artifact = "ObjectHandle")
public interface PropertiesDomainAddOn<E> {

  java.util.Map<String, Object> nativeMap();
}
