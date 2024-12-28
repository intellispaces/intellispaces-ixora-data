package tech.intellispaces.ixora.data.association;

import tech.intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(value = DictionaryDomain.class, artifact = "ObjectHandle", type = "addon")
public interface DictionaryDomainAddOn<E> {

  java.util.Map<String, Object> nativeMap();
}
