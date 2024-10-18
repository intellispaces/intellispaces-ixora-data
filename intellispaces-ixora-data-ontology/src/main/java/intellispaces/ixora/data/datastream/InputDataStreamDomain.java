package intellispaces.ixora.data.datastream;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Unmovable;
import intellispaces.framework.core.traverse.TraverseTypes;
import intellispaces.ixora.data.collection.ListDomain;

@Domain("671f5295-423a-4b26-a579-6c3087c02e88")
public interface InputDataStreamDomain<E> extends DataStreamDomain<E> {

  @Channel(
      value = "2d698e68-bb86-4e5b-9888-203c530b7fd2",
      name = "InputDataStreamIsExhaustedChannel")
  Boolean isExhausted();

  @Channel(
      value = "e9dc6abd-5f7c-42f8-8e4b-d0ceb90adf06",
      name = "InputDataStreamReadChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  E read();

  @Channel(
      value = "f7415895-f183-43e0-8fc6-c50fe08e3c98",
      name = "InputDataStreamReadMultipleChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  @Unmovable
  ListDomain<E> readMultiple(int number);

  @Channel(
      value = "56d9023d-2045-4b8b-96d7-f2beb64cb378",
      name = "InputDataStreamReadAllChannel",
      allowedTraverse = TraverseTypes.MappingOfMoving)
  @Unmovable
  ListDomain<E> readAll();
}
