package intellispaces.ixora.data.datastream;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Unmovable;
import intellispaces.framework.core.traverse.TraverseTypes;
import intellispaces.ixora.data.collection.ByteListDomain;

@Domain("e414189a-f906-49bd-9a89-116c7c19debd")
public interface ByteInputStreamDomain extends InputDataStreamDomain<Byte> {

  @Channel(
      value = "47a07883-5660-4e7e-81f1-24d48d215285",
      name = "ByteInputStreamReadChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  @Override
  Byte read();

  @Channel(
      value = "2c9b4074-f83b-4d4f-983d-3107e26dc8ee",
      name = "ByteInputStreamReadMultipleChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  @Unmovable
  @Override
  ByteListDomain readMultiple(int number);

  @Channel(
      value = "0ffb808a-2749-43f8-9afe-b43337faf280",
      name = "ByteInputStreamReadAllChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  @Unmovable
  @Override
  ByteListDomain readAll();
}
