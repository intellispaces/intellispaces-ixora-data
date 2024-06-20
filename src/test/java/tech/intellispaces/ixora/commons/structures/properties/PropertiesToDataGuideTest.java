package tech.intellispaces.ixora.commons.structures.properties;

import tech.intellispaces.ixora.structures.properties.PropertiesToDataTransition;
import tech.intellispaces.ixora.structures.properties.PropertiesToDataTransitionTest;

/**
 * Tests for {@link PropertiesToDataGuide} class.
 */
public class PropertiesToDataGuideTest implements PropertiesToDataTransitionTest {

  @Override
  public PropertiesToDataTransition guide() {
    return new PropertiesToDataGuide();
  }
}
