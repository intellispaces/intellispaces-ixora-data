package tech.mindstructs.structures.properties;

import intellispaces.ixora.mindstructs.structures.properties.PropertiesToDataMapper;
import tech.mindstructs.test.structures.properties.PropertiesToDataMapperTest;

/**
 * Tests for {@link MindstructsPropertiesToDataMapper} class.
 */
public class MindstructsPropertiesToDataMapperTest extends PropertiesToDataMapperTest {

  @Override
  public PropertiesToDataMapper guide() {
    return new MindstructsPropertiesToDataMapper();
  }
}
