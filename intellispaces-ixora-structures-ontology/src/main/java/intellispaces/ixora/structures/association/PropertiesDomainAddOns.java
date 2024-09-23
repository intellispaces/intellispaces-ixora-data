package intellispaces.ixora.structures.association;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnsTo = PropertiesDomain.class, artifact = "ObjectHandle")
public interface PropertiesDomainAddOns<E> {

  java.util.Map<String, Object> nativeMap();
}
