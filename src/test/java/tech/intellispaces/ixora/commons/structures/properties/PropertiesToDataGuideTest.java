package tech.intellispaces.ixora.commons.structures.properties;

import org.junit.jupiter.api.Test;
import tech.intellispaces.ixora.structures.properties.PropertiesToDataTransitionTest;

/**
 * Tests for {@link PropertiesToDataGuide} class.
 */
public class PropertiesToDataGuideTest {

  @Test
  public void testPropertiesToDataGuide() {
    PropertiesToDataGuide guide = new PropertiesToDataGuide();
    PropertiesToDataTransitionTest.allTests(guide);
  }
}
