package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.annotation.Preprocessing;

@Preprocessing(addOnFor = ByteListDomain.class, artifact = "ObjectHandle")
public interface ByteListAddOn {

  byte[] asByteArray();
}
