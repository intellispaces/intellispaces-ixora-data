package tech.intellispaces.ixora.data.association;

import tech.intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(value = PropertiesDomain.class, artifact = "ObjectHandle", type = "addon")
public interface PropertiesDomainAddOn<E> {

  java.util.Map<String, Object> nativeMap();
}
