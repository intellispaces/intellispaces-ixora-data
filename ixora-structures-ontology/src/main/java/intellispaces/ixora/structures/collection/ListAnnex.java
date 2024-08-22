package intellispaces.ixora.structures.collection;

import tech.intellispaces.core.annotation.Preprocessing;

@Preprocessing(annexFor = List.class, artifact = "ObjectHandle")
public interface ListAnnex<E> {

  java.util.List<E> nativeList();
}
