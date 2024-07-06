package tech.intellispaces.ixora.commons.cli;

import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.framework.core.annotation.Unit;
import tech.intellispaces.ixora.cli.ConsoleMovableHandle;

@Unit
public class CliUnit {

  /**
   * Projection to module CLI console.
   */
  @Projection
  public ConsoleMovableHandle console() {
    return new PrintStreamBasedConsole(System.out);
  }
}
