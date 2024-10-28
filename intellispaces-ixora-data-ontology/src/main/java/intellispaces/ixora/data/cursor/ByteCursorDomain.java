package intellispaces.ixora.data.cursor;

import intellispaces.jaquarius.annotation.Channel;
import intellispaces.jaquarius.annotation.Domain;

@Domain("d280760e-013f-4dbb-a817-8b784561d058")
public interface ByteCursorDomain extends CursorDomain<Byte> {

  @Override
  @Channel("29d7623b-4a5b-4a6b-97e9-e877ec2cb4cc")
  Byte next();
}
