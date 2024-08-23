package ixora.structures.collection;

import intellispaces.core.annotation.Preprocessing;

@Preprocessing(annexFor = CollectionDomain.class, artifact = "ObjectHandle")
public interface CollectionDomainAnnex<E> {

  java.util.Collection<E> nativeCollection();
}
