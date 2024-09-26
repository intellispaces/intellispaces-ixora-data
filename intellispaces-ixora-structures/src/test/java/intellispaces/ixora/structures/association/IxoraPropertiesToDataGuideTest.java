package intellispaces.ixora.structures.association;

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
