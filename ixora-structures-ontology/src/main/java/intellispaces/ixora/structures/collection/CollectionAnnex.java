package intellispaces.ixora.structures.collection;

import tech.intellispaces.core.annotation.Preprocessing;

@Preprocessing(annexFor = Collection.class, artifact = "ObjectHandle")
public interface CollectionAnnex<E> {

  java.util.Collection<E> nativeCollection();
}
