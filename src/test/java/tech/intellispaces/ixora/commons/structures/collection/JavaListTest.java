package tech.intellispaces.ixora.commons.structures.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.intellispaces.framework.core.IntellispacesFramework;
import tech.intellispaces.framework.core.system.Modules;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link AbstractJavaList} class.
 */
public class JavaListTest {

  @BeforeEach
  public void init() {
    IntellispacesFramework.loadModule().start();
  }

  @AfterEach
  public void deinit() {
    Modules.activeModule().stop();
  }

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
