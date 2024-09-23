package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnsTo = ListDomain.class, artifact = "ObjectHandle")
public interface ListAddOns<E> {

  java.util.List<E> nativeList();
}
