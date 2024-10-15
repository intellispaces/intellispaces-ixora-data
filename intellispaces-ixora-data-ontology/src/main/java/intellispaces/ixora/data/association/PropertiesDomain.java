package intellispaces.ixora.data.association;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.ixora.data.collection.DoubleListDomain;
import intellispaces.ixora.data.collection.IntegerListDomain;
import intellispaces.ixora.data.collection.ListDomain;
import intellispaces.ixora.data.exception.InvalidPropertyException;
import intellispaces.ixora.space.PointDomain;

/**
 * Properties are a hierarchical set of named properties.
 */
@Domain("eccd18a1-ec7a-4949-9acd-2b2fa9576da1")
public interface PropertiesDomain extends PointDomain {

  @Channel("ea111b97-c025-4d74-8466-d462c4c87efd")
  Object value(String path) throws InvalidPropertyException;

  @Channel("4e01aa7a-3fd4-4509-9387-921c30ecf5f9")
  Integer integerValue(String path) throws InvalidPropertyException;

  @Channel("ffcd77b5-032f-49db-8dfd-c792a19d1005")
  Double doubleValue(String path) throws InvalidPropertyException;

  @Channel("4cc73514-1a59-4560-ba50-7045360b853c")
  String stringValue(String path) throws InvalidPropertyException;

  @Channel("e033ddc5-7f4d-4bbd-8958-8b9c34fdfc95")
  PropertiesDomain propertiesValue(String path) throws InvalidPropertyException;

  @Channel("e8e1fb09-b22e-4e66-bee5-34db85e4ada3")
  IntegerListDomain integerList(String path) throws InvalidPropertyException;

  @Channel("101bf792-aa89-4114-ba58-26d78487a4a5")
  DoubleListDomain doubleList(String path) throws InvalidPropertyException;

  @Channel("f6d6c228-cfe0-4bcd-80b8-b0bd23e606c7")
  ListDomain<String> stringList(String path) throws InvalidPropertyException;

  @Channel("b48ef2de-6bbc-4c9c-a0b1-e3f1c6ca33d1")
  ListDomain<PropertiesDomain> propertiesList(String path) throws InvalidPropertyException;

  @Channel("d1b7dcf8-b8d5-41d0-8d19-6faee74a852c")
  Integer size();
}
