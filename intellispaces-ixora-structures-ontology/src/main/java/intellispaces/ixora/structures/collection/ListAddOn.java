package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnFor = ListDomain.class, artifact = "ObjectHandle")
public interface ListAddOn<E> {

  java.util.List<E> nativeList();
}
