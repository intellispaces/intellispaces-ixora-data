package intellispaces.ixora.data.datastream;

import intellispaces.common.base.type.Type;
import intellispaces.jaquarius.annotation.Channel;
import intellispaces.jaquarius.annotation.Domain;

@Domain("4db5d8e0-4411-4ba9-a3a9-de975542c5c9")
public interface DataStreamDomain<E> {

  @Channel("fc977e28-105b-4169-a445-e81b3f89b6fc")
  Type<E> elementDomain();
}
