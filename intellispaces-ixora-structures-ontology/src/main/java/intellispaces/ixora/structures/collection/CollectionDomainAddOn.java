package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnFor = CollectionDomain.class, artifact = "ObjectHandle")
public interface CollectionDomainAddOn<E> {

  java.util.Collection<E> nativeCollection();
}
