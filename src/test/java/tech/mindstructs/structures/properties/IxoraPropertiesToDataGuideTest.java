package tech.mindstructs.structures.properties;

import intellispaces.ixora.mindstructs.structures.properties.PropertiesToDataGuide;
import tech.mindstructs.test.structures.properties.PropertiesToDataGuideTest;

/**
 * Tests for {@link IxoraPropertiesToDataGuide} class.
 */
public class IxoraPropertiesToDataGuideTest extends PropertiesToDataGuideTest {

  @Override
  public PropertiesToDataGuide guide() {
    return new IxoraPropertiesToDataGuide();
  }
}
