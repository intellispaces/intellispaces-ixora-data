package intellispaces.ixora.structures.properties;

import intellispaces.ixora.test.structures.properties.PropertiesToDataMapperTest;

/**
 * Tests for {@link IxoraPropertiesToDataGuide} class.
 */
public class IxoraPropertiesToDataGuideTest extends PropertiesToDataMapperTest {

  @Override
  public PropertiesToDataMapper<Object> guide() {
    return new IxoraPropertiesToDataGuide<>();
  }
}
