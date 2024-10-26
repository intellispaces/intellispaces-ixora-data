package intellispaces.ixora.data.association;

import intellispaces.framework.core.IntellispacesFramework;
import intellispaces.framework.core.system.Modules;
import intellispaces.ixora.data.test.properties.AbstractPropertiesToDataGuideTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests for {@link IxoraPropertiesToDataGuide} class.
 */
public class IxoraPropertiesToDataGuideTest extends AbstractPropertiesToDataGuideTest {

  @BeforeEach
  public void init() {
    IntellispacesFramework.loadModule();
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
