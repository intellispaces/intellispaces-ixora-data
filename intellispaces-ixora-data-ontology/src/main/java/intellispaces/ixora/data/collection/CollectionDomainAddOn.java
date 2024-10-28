package intellispaces.ixora.data.collection;

import intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(addOnFor = CollectionDomain.class, artifact = "ObjectHandle")
public interface CollectionDomainAddOn<E> {

  java.util.Collection<E> nativeCollection();
}
