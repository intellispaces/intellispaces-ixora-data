package tech.intellispaces.ixora.structures.properties;

import intellispaces.ixora.structures.properties.PropertiesToDataMapper;
import tech.intellispaces.ixora.test.structures.properties.PropertiesToDataMapperTest;

/**
 * Tests for {@link IxoraPropertiesToDataMapper} class.
 */
public class IxoraPropertiesToDataMapperTest extends PropertiesToDataMapperTest {

  @Override
  public PropertiesToDataMapper guide() {
    return new IxoraPropertiesToDataMapper();
  }
}
