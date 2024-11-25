package tech.intellispaces.ixora.data.datastream;

import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Domain;
import tech.intellispaces.jaquarius.traverse.TraverseTypes;

@Domain("fd292568-d88e-4ba3-be18-e02300e33681")
public interface OutputDataStreamDomain<E> extends DataStreamDomain<E> {

  @Channel("03cb13da-399e-4367-8538-99bd28899cb3")
  DataStreamDomain<E> asDataStream();

  @Channel(
      value = "84038791-42f2-48e1-8a39-500e06cc8f0b",
      name = "OutputDataStreamWriteElementChannel",
      allowedTraverse = TraverseTypes.Moving)
  OutputDataStreamDomain<E> write(E element);
}
