package tech.intellispaces.ixora.data.association;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tech.intellispaces.ixora.data.test.properties.AbstractPropertiesToDataGuideTest;
import tech.intellispaces.jaquarius.system.Modules;

/**
 * Tests for {@link IxoraPropertiesToDataGuide} class.
 */
public class IxoraPropertiesToDataGuideTest extends AbstractPropertiesToDataGuideTest {

  @BeforeEach
  public void init() {
    Modules.get().start();
  }

  @AfterEach
  public void deinit() {
    Modules.current().stop();
  }

  @Override
  public PropertiesToDataGuide getGuide() {
    return new IxoraPropertiesToDataGuide();
  }
}
