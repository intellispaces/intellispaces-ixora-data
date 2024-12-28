package tech.intellispaces.ixora.data.test.dictionary;

import tech.intellispaces.ixora.data.association.Dictionary;
import tech.intellispaces.ixora.data.association.YamlStringToDictionaryGuide;
import tech.intellispaces.ixora.data.collection.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.intellispaces.jaquarius.system.Modules;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for guide {@link YamlStringToDictionaryGuide}.
 */
public abstract class YamlStringToDictionaryGuideTest {

  @BeforeEach
  public void init() {
    Modules.load().start();
  }

  @AfterEach
  public void destroy() {
    Modules.unload();
  }

  public abstract YamlStringToDictionaryGuide guide();

  @Test
  public void testEmptyYaml() {
    // Given
    String yaml = "";

    // When
    Dictionary dictionary = guide().yamlStringToDictionary(yaml);

    // Then
    assertThat(dictionary).isNotNull();
    assertThat(dictionary.size()).isEqualTo(0);
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
    Dictionary dictionary = guide().yamlStringToDictionary(yaml);

    // Then
    assertThat(dictionary).isNotNull();
    assertThat(dictionary.size()).isEqualTo(3);

    assertThat(dictionary.integerValue("intValue")).isEqualTo(1);
    assertThat(dictionary.value("intValue")).isEqualTo(1);

    assertThat(dictionary.doubleValue("doubleValue")).isEqualTo(2.2);
    assertThat(dictionary.value("doubleValue")).isEqualTo(2.2);

    assertThat(dictionary.stringValue("stringValue")).isEqualTo("abc");
    assertThat(dictionary.value("stringValue")).isEqualTo("abc");
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
    Dictionary dictionary = guide().yamlStringToDictionary(yaml);

    // Then
    assertThat(dictionary).isNotNull();
    assertThat(dictionary.size()).isEqualTo(1);

    assertThat(dictionary.integerList("values").size()).isEqualTo(3);
    assertThat(dictionary.integerList("values").get(0)).isEqualTo(1);
    assertThat(dictionary.integerList("values").get(1)).isEqualTo(2);
    assertThat(dictionary.integerList("values").get(2)).isEqualTo(3);

    assertThat(((List<Integer>) dictionary.value("values")).size()).isEqualTo(3);
    assertThat(((List<Integer>) dictionary.value("values")).get(0)).isEqualTo(1);
    assertThat(((List<Integer>) dictionary.value("values")).get(1)).isEqualTo(2);
    assertThat(((List<Integer>) dictionary.value("values")).get(2)).isEqualTo(3);
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
    Dictionary dictionary = guide().yamlStringToDictionary(yaml);

    // Then
    assertThat(dictionary).isNotNull();
    assertThat(dictionary.size()).isEqualTo(1);

    assertThat(dictionary.doubleList("values").size()).isEqualTo(3);
    assertThat(dictionary.doubleList("values").get(0)).isEqualTo(1.1);
    assertThat(dictionary.doubleList("values").get(1)).isEqualTo(2.2);
    assertThat(dictionary.doubleList("values").get(2)).isEqualTo(3.3);

    assertThat(((List<Double>) dictionary.value("values")).size()).isEqualTo(3);
    assertThat(((List<Double>) dictionary.value("values")).get(0)).isEqualTo(1.1);
    assertThat(((List<Double>) dictionary.value("values")).get(1)).isEqualTo(2.2);
    assertThat(((List<Double>) dictionary.value("values")).get(2)).isEqualTo(3.3);
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
    Dictionary dictionary = guide().yamlStringToDictionary(yaml);

    // Then
    assertThat(dictionary).isNotNull();
    assertThat(dictionary.size()).isEqualTo(1);

    assertThat(dictionary.stringList("values").size()).isEqualTo(3);
    assertThat(dictionary.stringList("values").get(0)).isEqualTo("a");
    assertThat(dictionary.stringList("values").get(1)).isEqualTo("b");
    assertThat(dictionary.stringList("values").get(2)).isEqualTo("c");

    assertThat(((List<String>) dictionary.value("values")).size()).isEqualTo(3);
    assertThat(((List<String>) dictionary.value("values")).get(0)).isEqualTo("a");
    assertThat(((List<String>) dictionary.value("values")).get(1)).isEqualTo("b");
    assertThat(((List<String>) dictionary.value("values")).get(2)).isEqualTo("c");
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
    Dictionary dictionary = guide().yamlStringToDictionary(yaml);

    // Then
    assertThat(dictionary).isNotNull();
    assertThat(dictionary.size()).isEqualTo(2);
    assertThat(dictionary.value("value1")).isEqualTo(1);
    assertThat(dictionary.value("nestedValue.value2")).isEqualTo("abc");
    assertThat(dictionary.dictionaryValue("nestedValue").size()).isEqualTo(1);
  }
}
