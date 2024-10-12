package intellispaces.ixora.data.association;

import intellispaces.ixora.data.test.properties.PropertiesToDataGuideTest;

/**
 * Tests for {@link IxoraPropertiesToDataGuide} class.
 */
public class IxoraPropertiesToDataGuideTest extends PropertiesToDataGuideTest {

  @Override
  public PropertiesToDataGuide<Object> guide() {
    return new IxoraPropertiesToDataGuide<>();
  }
}
