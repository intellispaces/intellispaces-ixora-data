package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(value = CollectionDomain.class, artifact = "ObjectHandle", type = "addon")
public interface CollectionAddOn<E> {

  java.util.Collection<E> nativeCollection();
}
