package intellispaces.ixora.data.datastream;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.traverse.TraverseTypes;

@Domain("e414189a-f906-49bd-9a89-116c7c19debd")
public interface ByteInputStreamDomain extends InputDataStreamDomain<Byte> {

  @Override
  @Channel(
      value = "47a07883-5660-4e7e-81f1-24d48d215285",
      name = "InputByteStreamToNextElementChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  Byte read();
}
