package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.jaquarius.annotation.Preprocessing;

@Preprocessing(value = ListDomain.class, artifact = "ObjectHandle", type = "addon")
public interface ListAddOn<E> {

  java.util.List<E> nativeList();
}
