package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnsTo = ByteListDomain.class, artifact = "ObjectHandle")
public interface ByteListAddOns {

  byte[] asArray();
}
