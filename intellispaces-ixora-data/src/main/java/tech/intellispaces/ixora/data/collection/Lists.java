package tech.intellispaces.ixora.data.collection;

import tech.intellispaces.entity.type.Type;

public interface Lists {

  /**
   * Creates handle of unmovable list based on Java list.
   *
   * @param list origin list.
   * @param elementClass elements class.
   * @return handle to list.
   * @param <E> element type.
   */
  static <E> UnmovableList<E> of(java.util.List<E> list, Class<E> elementClass) {
    return new ListHandleImpl<>(list, elementClass);
  }

  /**
   * Creates handle of unmovable list based on Java list.
   *
   * @param list origin list.
   * @param elementType elements type.
   * @return handle to list.
   * @param <E> element type.
   */
  static <E> UnmovableList<E> of(java.util.List<E> list, Type<E> elementType) {
    return new ListHandleImpl<>(list, elementType);
  }

  static <E> UnmovableList<E> empty(Class<E> elementClass) {
    return ListProvider.empty(elementClass);
  }

  static UnmovableByteList ofBytes(byte[] array) {
    return new ByteListHandleImpl(array);
  }

  static UnmovableByteList ofBytes(java.util.List<Byte> list) {
    return new ByteListHandleImpl(list);
  }

  static UnmovableByteList ofBytes(byte value1, byte value2) {
    return new ByteListHandleImpl(new byte[] { value1, value2 });
  }

  static UnmovableByteList ofBytes(byte value1, byte value2, byte value3) {
    return new ByteListHandleImpl(new byte[] { value1, value2, value3 });
  }

  static UnmovableIntegerList ofIntegers(int[] array) {
    return new IntegerListHandleImpl(array);
  }

  static UnmovableIntegerList ofIntegers(java.util.List<Integer> list) {
    return new IntegerListHandleImpl(list);
  }

  static UnmovableIntegerList ofIntegers(int value1, int value2) {
    return new IntegerListHandleImpl(new int[] { value1, value2 });
  }

  static UnmovableIntegerList ofIntegers(int value1, int value2, int value3) {
    return new IntegerListHandleImpl(new int[] { value1, value2, value3 });
  }

  static UnmovableDoubleList ofDoubles(double[] array) {
    return new DoubleListHandleImpl(array);
  }

  static UnmovableDoubleList ofDoubles(java.util.List<Double> list) {
    return new DoubleListHandleImpl(list);
  }
}
