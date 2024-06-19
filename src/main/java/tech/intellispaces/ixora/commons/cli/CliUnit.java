package tech.intellispaces.ixora.commons.cli;

import tech.intellispaces.ixora.cli.ConsoleHandle;
import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.framework.core.annotation.Unit;

@Unit
public class CliUnit {

  /**
   * Projection to module CLI console.
   */
  @Projection
  public ConsoleHandle console() {
    return new PrintStreamBasedConsoleHandleImpl(System.out);
  }
}
