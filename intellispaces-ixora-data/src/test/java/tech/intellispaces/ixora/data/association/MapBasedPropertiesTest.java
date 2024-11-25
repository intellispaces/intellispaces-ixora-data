package tech.intellispaces.ixora.data.association;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.intellispaces.ixora.data.exception.InvalidPropertyException;
import tech.intellispaces.jaquarius.system.Modules;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link MapBasedPropertiesHandle} class.
 */
public class MapBasedPropertiesTest {

  @BeforeEach
  public void init() {
    Modules.get().start();
  }

  @AfterEach
  public void deinit() {
    Modules.current().stop();
  }

  @Test
  public void test_whenEmptyMap_andEmptyPath() {
    // Given
    String path = "";
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of());

    // Then
    assertThat(properties.propertiesValue(path)).isSameAs(properties);

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            Properties.class.getCanonicalName() + ". Path ''");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            Properties.class.getCanonicalName() + ". Path ''");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual is " +
            Properties.class.getCanonicalName() + ". Path ''");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Integer, but actual is single value of type " +
            Properties.class.getCanonicalName() + ". Path ''");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Double, but actual is single value of type " +
            Properties.class.getCanonicalName() + ". Path ''");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.String, but actual is single value of type " +
            Properties.class.getCanonicalName() + ". Path ''");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.util.Map, but actual is single value of type " +
            Properties.class.getCanonicalName() + ". Path ''");
  }

  @Test
  public void test_whenEmptyMap_andNotEmptyPath() {
    // Given
    String path = "key";
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of());

    // Then
    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Property does not exist. Path '" + path + "'");
  }

  @Test
  public void test_whenIntegerValue() {
    // Given
    String path = "key";
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, 123));

    // Then
    assertThat(properties.integerValue(path)).isEqualTo(123);

    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            "java.lang.Integer. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual is " +
            "java.lang.Integer. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.util.Map type, but actual is " +
            "java.lang.Integer. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Integer, but actual is " +
            "single value of type java.lang.Integer. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Double, but actual is " +
            "single value of type java.lang.Integer. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.String, but actual is " +
            "single value of type java.lang.Integer. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.util.Map, but actual is " +
            "single value of type java.lang.Integer. Path '" + path + "'");
  }

  @Test
  public void test_whenDoubleValue() {
    // Given
    String path = "key";
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, 3.14));

    // Then
    assertThat(properties.doubleValue(path)).isEqualTo(3.14);

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            "java.lang.Double. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual is " +
            "java.lang.Double. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.util.Map type, but actual is " +
            "java.lang.Double. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Integer, but actual is " +
            "single value of type java.lang.Double. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Double, but actual is " +
            "single value of type java.lang.Double. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.String, but actual is " +
            "single value of type java.lang.Double. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.util.Map, but actual is " +
            "single value of type java.lang.Double. Path '" + path + "'");
  }

  @Test
  public void test_whenStringValue() {
    // Given
    String path = "key";
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, "def"));

    // Then
    assertThat(properties.stringValue(path)).isEqualTo("def");

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            "java.lang.String. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            "java.lang.String. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.util.Map type, but actual is " +
            "java.lang.String. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Integer, but actual is " +
            "single value of type java.lang.String. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Double, but actual is " +
            "single value of type java.lang.String. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.String, but actual is " +
            "single value of type java.lang.String. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.util.Map, but actual is " +
            "single value of type java.lang.String. Path '" + path + "'");
  }

  @Test
  public void test_whenPropertiesValue() {
    // Given
    String path = "key";
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, Map.of()));

    // Then
    assertThat(properties.propertiesValue(path).nativeMap()).isEqualTo(Map.of());

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            "java.util.Map. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            "java.util.Map. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual is " +
            "java.util.Map. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Integer, but actual is " +
            "single value of type java.util.Map. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.Double, but actual is " +
            "single value of type java.util.Map. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.lang.String, but actual is " +
            "single value of type java.util.Map. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list values of type java.util.Map, but actual is " +
            "single value of type java.util.Map. Path '" + path + "'");
  }

  @Test
  public void test_whenIntegerList() {
    // Given
    String path = "key";
    List<Integer> list = List.of(1, 2, 3);
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, list));

    // Then
    assertThat(properties.integerList(path).nativeList()).isEqualTo(list);

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.util.Map type, but actual is " +
            "java.util.List. Path '" + path + "'");

    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.Double values, but actual is " +
            "list contained java.lang.Integer values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.String values, but actual is " +
            "list contained java.lang.Integer values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.util.Map values, but actual is " +
            "list contained java.lang.Integer values. Path '" + path + "'");
  }

  @Test
  public void test_whenDoubleList() {
    // Given
    String path = "key";
    List<Double> list = List.of(1.1, 2.2, 3.3);
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, list));

    // Then
    assertThat(properties.doubleList(path).nativeList()).isEqualTo(list);

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual " +
            "is java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.util.Map type, but actual " +
            "is java.util.List. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.Integer values, but actual " +
            "is list contained java.lang.Double values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.String values, but actual " +
            "is list contained java.lang.Double values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.util.Map values, but actual is " +
            "list contained java.lang.Double values. Path '" + path + "'");
  }

  @Test
  public void test_whenStringList() {
    // Given
    String path = "key";
    List<String> list = List.of("a", "b", "c");
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, list));

    // Then
    assertThat(properties.stringList(path).nativeList()).isEqualTo(list);

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.util.Map type, but actual is " +
            "java.util.List. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.Integer values, but actual is " +
            "list contained java.lang.String values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.Double values, but actual is " +
            "list contained java.lang.String values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.util.Map values, but actual is " +
            "list contained java.lang.String values. Path '" + path + "'");
  }

  @Test
  public void test_whenPropertiesList() {
    // Given
    String path = "root";
    List<Map<String, Object>> list = List.of(Map.of("key1", 1), Map.of("key2", 2), Map.of("key3", 3));
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(path, list));

    // Then
    assertThat(properties.propertiesList(path).get(0).integerValue("key1")).isEqualTo(1);
    assertThat(properties.propertiesList(path).get(1).integerValue("key2")).isEqualTo(2);
    assertThat(properties.propertiesList(path).get(2).integerValue("key3")).isEqualTo(3);

    assertThatThrownBy(() -> properties.integerValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Integer type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.Double type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.lang.String type, but actual is " +
            "java.util.List. Path '" + path + "'");
    assertThatThrownBy(() -> properties.propertiesValue(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property value of java.util.Map type, but actual is " +
            "java.util.List. Path '" + path + "'");

    assertThatThrownBy(() -> properties.integerList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.Integer values, but actual is " +
            "list contained java.util.Map values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.doubleList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.Double values, but actual is " +
            "list contained java.util.Map values. Path '" + path + "'");
    assertThatThrownBy(() -> properties.stringList(path))
        .isExactlyInstanceOf(InvalidPropertyException.class)
        .hasMessage("Expected property list of java.lang.String values, but actual is " +
            "list contained java.util.Map values. Path '" + path + "'");
  }

  @Test
  public void test_whenLongPath_andIntegerValue() {
    // Given
    String key1 = "key1";
    String key2 = "key2";
    String key3 = "key3";
    MapBasedPropertiesHandle properties = new MapBasedPropertiesHandleImpl(Map.of(key1, Map.of(key2, Map.of(key3, 123))));

    // Then
    assertThat(properties.integerValue("key1.key2.key3")).isEqualTo(123);
  }
}
