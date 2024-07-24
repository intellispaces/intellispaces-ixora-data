package tech.mindstructs.structures.properties;

import intellispaces.ixora.mindstructs.structures.properties.PropertiesToDataMapper;
import tech.mindstructs.test.structures.properties.PropertiesToDataMapperTest;

/**
 * Tests for {@link IxoraPropertiesToDataMapper} class.
 */
public class IxoraPropertiesToDataMapperTest extends PropertiesToDataMapperTest {

  @Override
  public PropertiesToDataMapper guide() {
    return new IxoraPropertiesToDataMapper();
  }
}
