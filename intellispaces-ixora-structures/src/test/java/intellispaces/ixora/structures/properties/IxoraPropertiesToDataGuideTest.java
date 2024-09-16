package intellispaces.ixora.structures.properties;

import intellispaces.ixora.test.structures.properties.PropertiesToDataGuideTest;

/**
 * Tests for {@link IxoraPropertiesToDataGuide} class.
 */
public class IxoraPropertiesToDataGuideTest extends PropertiesToDataGuideTest {

  @Override
  public PropertiesToDataGuide<Object> guide() {
    return new IxoraPropertiesToDataGuide<>();
  }
}
