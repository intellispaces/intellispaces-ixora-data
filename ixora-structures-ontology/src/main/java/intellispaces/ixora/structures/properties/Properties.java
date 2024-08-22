package intellispaces.ixora.structures.properties;

import intellispaces.ixora.core.Point;
import intellispaces.ixora.structures.collection.DoubleList;
import intellispaces.ixora.structures.collection.IntegerList;
import intellispaces.ixora.structures.collection.List;
import intellispaces.ixora.structures.exception.InvalidPropertyException;
import tech.intellispaces.core.annotation.Domain;
import tech.intellispaces.core.annotation.Transition;

/**
 * Properties are a hierarchical set of named properties.
 */
@Domain("eccd18a1-ec7a-4949-9acd-2b2fa9576da1")
public interface Properties extends Point {

  @Transition("ea111b97-c025-4d74-8466-d462c4c87efd")
  Object value(String path) throws InvalidPropertyException;

  @Transition("4e01aa7a-3fd4-4509-9387-921c30ecf5f9")
  int integerValue(String path) throws InvalidPropertyException;

  @Transition("ffcd77b5-032f-49db-8dfd-c792a19d1005")
  double doubleValue(String path) throws InvalidPropertyException;

  @Transition("4cc73514-1a59-4560-ba50-7045360b853c")
  String stringValue(String path) throws InvalidPropertyException;

  @Transition("e033ddc5-7f4d-4bbd-8958-8b9c34fdfc95")
  Properties propertiesValue(String path) throws InvalidPropertyException;

  @Transition("e8e1fb09-b22e-4e66-bee5-34db85e4ada3")
  IntegerList integerList(String path) throws InvalidPropertyException;

  @Transition("101bf792-aa89-4114-ba58-26d78487a4a5")
  DoubleList doubleList(String path) throws InvalidPropertyException;

  @Transition("f6d6c228-cfe0-4bcd-80b8-b0bd23e606c7")
  List<String> stringList(String path) throws InvalidPropertyException;

  @Transition("b48ef2de-6bbc-4c9c-a0b1-e3f1c6ca33d1")
  List<Properties> propertiesList(String path) throws InvalidPropertyException;

  @Transition("d1b7dcf8-b8d5-41d0-8d19-6faee74a852c")
  int size();
}
