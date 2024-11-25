package tech.intellispaces.ixora.data.association;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.intellispaces.jaquarius.system.Modules;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link JavaMapHandle} class.
 */
public class JavaMapTest {

  @BeforeEach
  public void init() {
    Modules.get().start();
  }

  @AfterEach
  public void deinit() {
    Modules.current().stop();
  }

  @Test
  public void testJavaMapHandle_whenUnmovable() {
    // Given
    Map<String, Integer> javaMap = Map.of("1", 1, "2", 2, "3", 3);
    var handle = new JavaMapHandleImpl<>(javaMap, String.class, Integer.class);

    // Then
    assertThat(handle.nativeMap()).isEqualTo(javaMap);
  }
}
