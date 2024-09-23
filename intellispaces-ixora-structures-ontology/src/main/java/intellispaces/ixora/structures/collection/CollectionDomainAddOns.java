package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnsTo = CollectionDomain.class, artifact = "ObjectHandle")
public interface CollectionDomainAddOns<E> {

  java.util.Collection<E> nativeCollection();
}
