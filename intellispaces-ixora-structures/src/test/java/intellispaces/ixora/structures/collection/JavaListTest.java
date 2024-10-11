package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Types;
import intellispaces.framework.core.IntellispacesFramework;
import intellispaces.framework.core.system.Modules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ListHandle} class.
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
    java.util.List<String> javaList = java.util.List.of("a", "b", "c");
    List<String> handle = new ListHandleImpl<>(javaList, String.class);

    // Then
    assertThat(handle.size()).isEqualTo(3);
    assertThat(handle.sizePrimitive()).isEqualTo(3);
    assertThat(handle.get(0)).isEqualTo("a");
    assertThat(handle.get(1)).isEqualTo("b");
    assertThat(handle.get(2)).isEqualTo("c");
    assertThat(handle.nativeList()).isEqualTo(javaList);
  }

  @Test
  public void testListAliasCast() {
    // Given
    IntegerList integerListAlias = Lists.ofIntegers(1, 2, 3);
    NumberList<Integer> numberListAlias = Lists.ofIntegers(1, 2, 3);
    List<Integer> primaryList = Lists.ofIntegers(1, 2, 3);

    // Then
    assertThat(integerListAlias.get(0)).isEqualTo(1);
    assertThat(numberListAlias.get(1)).isEqualTo(2);
    assertThat(primaryList.get(2)).isEqualTo(3);

    assertThat(integerListAlias.domainClass()).isEqualTo(ListDomain.class);
    assertThat(numberListAlias.domainClass()).isEqualTo(ListDomain.class);
    assertThat(primaryList.domainClass()).isEqualTo(ListDomain.class);

    assertThat(integerListAlias.domain()).isEqualTo(Types.of(ListDomain.class, Integer.class));
    assertThat(numberListAlias.domain()).isEqualTo(Types.of(ListDomain.class, Integer.class));
    assertThat(primaryList.domain()).isEqualTo(Types.of(ListDomain.class, Integer.class));
  }

}
