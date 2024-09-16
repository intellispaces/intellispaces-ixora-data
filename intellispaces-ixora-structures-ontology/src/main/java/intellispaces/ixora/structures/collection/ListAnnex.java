package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(annexFor = ListDomain.class, artifact = "ObjectHandle")
public interface ListAnnex<E> {

  java.util.List<E> nativeList();
}
