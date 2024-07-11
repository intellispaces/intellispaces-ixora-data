package tech.intellispaces.ixora.commons.structures.properties;

import intellispaces.ixora.structures.properties.PropertiesToDataGuide;
import tech.intellispaces.ixora.structures.properties.PropertiesToDataGuideTest;

/**
 * Tests for {@link IxoraPropertiesToDataGuide} class.
 */
public class IxoraPropertiesToDataGuideTest implements PropertiesToDataGuideTest {

  @Override
  public PropertiesToDataGuide guide() {
    return new IxoraPropertiesToDataGuide();
  }
}
