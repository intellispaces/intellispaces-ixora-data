package intellispaces.ixora.data.test.properties;

import intellispaces.framework.core.IntellispacesFramework;
import intellispaces.framework.core.system.Modules;
import intellispaces.ixora.data.association.Properties;
import intellispaces.ixora.data.association.YamlStringToPropertiesGuide;
import intellispaces.ixora.data.collection.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for guide {@link YamlStringToPropertiesGuide}.
 */
public abstract class YamlStringToPropertiesGuideTest {

  @BeforeEach
  public void init() {
    IntellispacesFramework.loadModule();
  }

  @AfterEach
  public void destroy() {
    Modules.current().stop();
  }

  public abstract YamlStringToPropertiesGuide guide();

  @Test
  public void testEmptyYaml() {
    // Given
    String yaml = "";

    // When
    Properties properties = guide().yamlStringToProperties(yaml);

    // Then
    assertThat(properties).isNotNull();
    assertThat(properties.size()).isEqualTo(0);
  }

  @Test
  public void testSimpleData() {
    // Given
    String yaml = """
        intValue: 1
        doubleValue: 2.2
        stringValue: abc
        """;

    // When
    Properties properties = guide().yamlStringToProperties(yaml);

    // Then
    assertThat(properties).isNotNull();
    assertThat(properties.size()).isEqualTo(3);

    assertThat(properties.integerValue("intValue")).isEqualTo(1);
    assertThat(properties.value("intValue")).isEqualTo(1);

    assertThat(properties.doubleValue("doubleValue")).isEqualTo(2.2);
    assertThat(properties.value("doubleValue")).isEqualTo(2.2);

    assertThat(properties.stringValue("stringValue")).isEqualTo("abc");
    assertThat(properties.value("stringValue")).isEqualTo("abc");
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testIntegerList() {
    // Given
    String yaml = """
        values:
          - 1
          - 2
          - 3
        """;

    // When
    Properties properties = guide().yamlStringToProperties(yaml);

    // Then
    assertThat(properties).isNotNull();
    assertThat(properties.size()).isEqualTo(1);

    assertThat(properties.integerList("values").size()).isEqualTo(3);
    assertThat(properties.integerList("values").get(0)).isEqualTo(1);
    assertThat(properties.integerList("values").get(1)).isEqualTo(2);
    assertThat(properties.integerList("values").get(2)).isEqualTo(3);

    assertThat(((List<Integer>) properties.value("values")).size()).isEqualTo(3);
    assertThat(((List<Integer>) properties.value("values")).get(0)).isEqualTo(1);
    assertThat(((List<Integer>) properties.value("values")).get(1)).isEqualTo(2);
    assertThat(((List<Integer>) properties.value("values")).get(2)).isEqualTo(3);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testDoubleList() {
    // Given
    String yaml = """
        values:
          - 1.1
          - 2.2
          - 3.3
        """;

    // When
    Properties properties = guide().yamlStringToProperties(yaml);

    // Then
    assertThat(properties).isNotNull();
    assertThat(properties.size()).isEqualTo(1);

    assertThat(properties.doubleList("values").size()).isEqualTo(3);
    assertThat(properties.doubleList("values").get(0)).isEqualTo(1.1);
    assertThat(properties.doubleList("values").get(1)).isEqualTo(2.2);
    assertThat(properties.doubleList("values").get(2)).isEqualTo(3.3);

    assertThat(((List<Double>) properties.value("values")).size()).isEqualTo(3);
    assertThat(((List<Double>) properties.value("values")).get(0)).isEqualTo(1.1);
    assertThat(((List<Double>) properties.value("values")).get(1)).isEqualTo(2.2);
    assertThat(((List<Double>) properties.value("values")).get(2)).isEqualTo(3.3);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testStringList() {
    // Given
    String yaml = """
        values:
          - a
          - "b"
          - c
        """;

    // When
    Properties properties = guide().yamlStringToProperties(yaml);

    // Then
    assertThat(properties).isNotNull();
    assertThat(properties.size()).isEqualTo(1);

    assertThat(properties.stringList("values").size()).isEqualTo(3);
    assertThat(properties.stringList("values").get(0)).isEqualTo("a");
    assertThat(properties.stringList("values").get(1)).isEqualTo("b");
    assertThat(properties.stringList("values").get(2)).isEqualTo("c");

    assertThat(((List<String>) properties.value("values")).size()).isEqualTo(3);
    assertThat(((List<String>) properties.value("values")).get(0)).isEqualTo("a");
    assertThat(((List<String>) properties.value("values")).get(1)).isEqualTo("b");
    assertThat(((List<String>) properties.value("values")).get(2)).isEqualTo("c");
  }

  @Test
  public void testNestedData() {
    // Given
    String yaml = """
        value1: 1
        nestedValue:
          value2: abc
        """;

    // When
    Properties properties = guide().yamlStringToProperties(yaml);

    // Then
    assertThat(properties).isNotNull();
    assertThat(properties.size()).isEqualTo(2);
    assertThat(properties.value("value1")).isEqualTo(1);
    assertThat(properties.value("nestedValue.value2")).isEqualTo("abc");
    assertThat(properties.propertiesValue("nestedValue").size()).isEqualTo(1);
  }
}