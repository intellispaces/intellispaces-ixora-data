package tech.intellispaces.ixora.data.test.dictionary;

import org.junit.jupiter.api.Test;
import tech.intellispaces.ixora.data.association.Dictionary;
import tech.intellispaces.ixora.data.association.DictionaryToDataGuide;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for guide {@link DictionaryToDataGuide}.
 */
public abstract class AbstractPropertiesToDataGuideTest {

  public abstract DictionaryToDataGuide getGuide();

  @Test
  public void testPrimitiveData_whenEmptyProperties() {
    // Given
    Dictionary dictionary = mock(Dictionary.class);

    // When
    PrimitiveData data = getGuide().dictionaryToData(dictionary, PrimitiveData.class);

    // Then
    assertThat(data).isNotNull();
    assertThat(data.intValue()).isNull();
    assertThat(data.doubleValue()).isNull();
  }

  @Test
  public void testSimpleData_whenEmptyProperties() {
    // Given
    Dictionary dictionary = mock(Dictionary.class);

    // When
    SimpleData data = getGuide().dictionaryToData(dictionary, SimpleData.class);

    // Then
    assertThat(data).isNotNull();
    assertThat(data.intValue()).isNull();
    assertThat(data.doubleValue()).isNull();
    assertThat(data.stringValue()).isNull();
  }

  @Test
  public void testNestedData_whenEmptyProperties() {
    // Given
    Dictionary dictionary = mock(Dictionary.class);

    // When
    NestedData data = getGuide().dictionaryToData(dictionary, NestedData.class);

    // Then
    assertThat(data).isNotNull();
    assertThat(data.stringValue()).isNull();
    assertThat(data.nestedValue()).isNull();
  }

  @Test
  public void testPrimitiveData_whenNotEmptyProperties() {
    // Given
    Dictionary dictionary = mock(Dictionary.class);
    when(dictionary.value("intValue")).thenReturn(1);
    when(dictionary.value("doubleValue")).thenReturn(2.2);

    // When
    PrimitiveData data = getGuide().dictionaryToData(dictionary, PrimitiveData.class);

    // Then
    assertThat(data).isNotNull();
    assertThat(data.intValue()).isEqualTo(1);
    assertThat(data.doubleValue()).isEqualTo(2.2);
  }

  @Test
  public void testSimpleData_whenNotEmptyProperties() {
    // Given
    Dictionary dictionary = mock(Dictionary.class);
    when(dictionary.value("intValue")).thenReturn(1);
    when(dictionary.value("doubleValue")).thenReturn(2.2);
    when(dictionary.value("stringValue")).thenReturn("abc");

    // When
    SimpleData data = getGuide().dictionaryToData(dictionary, SimpleData.class);

    // Then
    assertThat(data).isNotNull();
    assertThat(data.intValue()).isEqualTo(1);
    assertThat(data.doubleValue()).isEqualTo(2.2);
    assertThat(data.stringValue()).isEqualTo("abc");
  }

  @Test
  public void testNestedData_whenNotEmptyProperties() {
    // Given
    Dictionary dictionary = mock(Dictionary.class);
    Dictionary nestedDictionary = mock(Dictionary.class);
    when(dictionary.value("stringValue")).thenReturn("abc");
    when(dictionary.value("nestedValue")).thenReturn(nestedDictionary);
    when(nestedDictionary.value("stringValue")).thenReturn("def");

    // When
    NestedData data = getGuide().dictionaryToData(dictionary, NestedData.class);

    // Then
    assertThat(data).isNotNull();
    assertThat(data.stringValue()).isEqualTo("abc");
    assertThat(data.nestedValue()).isNotNull();
    assertThat(data.nestedValue().stringValue()).isEqualTo("def");
    assertThat(data.nestedValue().nestedValue()).isNull();
  }
}
