package tech.intellispaces.ixora.commons.structures.collection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link AbstractJavaList} class.
 */
public class JavaListTest {

  @Test
  public void testJavaListHandle_whenUnmovable() {
    // Given
    List<String> javaList = List.of("a", "b", "c");
    var handle = new JavaList(javaList, String.class);

    // Then
    assertThat(handle.size()).isEqualTo(3);
    assertThat(handle.element(0)).isEqualTo("a");
    assertThat(handle.element(1)).isEqualTo("b");
    assertThat(handle.element(2)).isEqualTo("c");
    assertThat(handle.javaList()).isEqualTo(javaList);
  }
}
