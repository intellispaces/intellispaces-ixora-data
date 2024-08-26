package intellispaces.ixora.structures.properties;

import intellispaces.ixora.test.structures.properties.PropertiesToDataMapperTest;

/**
 * Tests for {@link PropertiesToDataIxoraMapper} class.
 */
public class PropertiesToDataIxoraMapperTest extends PropertiesToDataMapperTest {

  @Override
  public <D> PropertiesToDataMapper<D> guide(Class<D> dataClass) {
    return new PropertiesToDataIxoraMapper<>();
  }
}
