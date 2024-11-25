package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(addOnFor = ListDomain.class, artifact = "ObjectHandle")
public interface ListAddOn<E> {

  java.util.List<E> nativeList();
}
