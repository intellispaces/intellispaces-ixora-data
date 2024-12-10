package tech.intellispaces.ixora.data.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.intellispaces.general.type.Types;
import tech.intellispaces.jaquarius.system.Modules;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ListHandle} class.
 */
public class JavaListTest {

  @BeforeEach
  public void init() {
    Modules.load().start();
  }

  @AfterEach
  public void deinit() {
    Modules.unload();
  }

  @Test
  public void testJavaListHandle_whenUnmovable() {
    // Given
    java.util.List<String> javaList = java.util.List.of("a", "b", "c");
    List<String> listHandle = Lists.of(javaList, String.class);

    // Then
    assertThat(listHandle.size()).isEqualTo(3);
    assertThat(listHandle.sizePrimitive()).isEqualTo(3);
    assertThat(listHandle.get(0)).isEqualTo("a");
    assertThat(listHandle.get(1)).isEqualTo("b");
    assertThat(listHandle.get(2)).isEqualTo("c");
    assertThat(listHandle.nativeList()).isEqualTo(javaList);
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

    assertThat(integerListAlias.domain()).isEqualTo(Types.get(ListDomain.class, Integer.class));
    assertThat(numberListAlias.domain()).isEqualTo(Types.get(ListDomain.class, Integer.class));
    assertThat(primaryList.domain()).isEqualTo(Types.get(ListDomain.class, Integer.class));
  }

}
