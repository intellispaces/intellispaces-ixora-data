package tech.intellispaces.ixora.data.association;

import tech.intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(addOnFor = PropertiesDomain.class, artifact = "ObjectHandle")
public interface PropertiesDomainAddOn<E> {

  java.util.Map<String, Object> nativeMap();
}
