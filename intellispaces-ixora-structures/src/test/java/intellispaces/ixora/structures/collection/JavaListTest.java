package intellispaces.ixora.structures.collection;

import intellispaces.framework.core.IntellispacesFramework;
import intellispaces.framework.core.system.Modules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link JavaListHandle} class.
 */
public class JavaListTest {

  @BeforeEach
  public void init() {
    IntellispacesFramework.loadModule();
  }

  @AfterEach
  public void deinit() {
    Modules.current().stop();
  }

  @Test
  public void testJavaListHandle_whenUnmovable() {
    // Given
    List<String> javaList = List.of("a", "b", "c");
    var handle = new JavaListHandleImpl<>(javaList, String.class);

    // Then
    assertThat(handle.size()).isEqualTo(3);
    assertThat(handle.element(0)).isEqualTo("a");
    assertThat(handle.element(1)).isEqualTo("b");
    assertThat(handle.element(2)).isEqualTo("c");
    assertThat(handle.nativeList()).isEqualTo(javaList);
  }
}
