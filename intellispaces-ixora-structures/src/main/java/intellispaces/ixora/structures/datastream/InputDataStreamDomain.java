package intellispaces.ixora.structures.datastream;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.traverse.TraverseTypes;

@Domain("671f5295-423a-4b26-a579-6c3087c02e88")
public interface InputDataStreamDomain<E> extends DataStreamDomain<E> {

  @Channel(
      value = "e9dc6abd-5f7c-42f8-8e4b-d0ceb90adf06",
      name = "InputDataStreamToNextElementChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  E read();
}
