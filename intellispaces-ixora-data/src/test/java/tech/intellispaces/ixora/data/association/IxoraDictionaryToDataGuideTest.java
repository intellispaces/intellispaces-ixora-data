package tech.intellispaces.ixora.data.association;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tech.intellispaces.ixora.data.test.dictionary.AbstractPropertiesToDataGuideTest;
import tech.intellispaces.jaquarius.system.Modules;

/**
 * Tests for {@link IxoraDictionaryToDataGuide} class.
 */
public class IxoraDictionaryToDataGuideTest extends AbstractPropertiesToDataGuideTest {

  @BeforeEach
  public void init() {
    Modules.load().start();
  }

  @AfterEach
  public void deinit() {
    Modules.unload();
  }

  @Override
  public DictionaryToDataGuide getGuide() {
    return new IxoraDictionaryToDataGuide();
  }
}
