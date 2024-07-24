package tech.mindstructs.structures.properties;

import intellispaces.ixora.mindstructs.structures.properties.PropertiesToDataMapper;
import tech.mindstructs.test.structures.properties.PropertiesToDataGuideTest;

/**
 * Tests for {@link IxoraPropertiesToDataMapper} class.
 */
public class IxoraPropertiesToDataMapperTest extends PropertiesToDataGuideTest {

  @Override
  public PropertiesToDataMapper guide() {
    return new IxoraPropertiesToDataMapper();
  }
}
