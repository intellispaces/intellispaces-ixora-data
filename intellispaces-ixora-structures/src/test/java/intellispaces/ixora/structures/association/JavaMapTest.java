package intellispaces.ixora.structures.association;

import intellispaces.framework.core.IntellispacesFramework;
import intellispaces.framework.core.system.Modules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link JavaMapHandle} class.
 */
public class JavaMapTest {

  @BeforeEach
  public void init() {
    IntellispacesFramework.loadModule();
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
