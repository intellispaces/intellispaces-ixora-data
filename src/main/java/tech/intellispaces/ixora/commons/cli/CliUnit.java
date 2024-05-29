package tech.intellispaces.ixora.commons.cli;

import tech.intellispaces.ixora.cli.ConsoleHandle;
import tech.intellispacesframework.core.annotation.Projection;
import tech.intellispacesframework.core.annotation.Unit;

@Unit
public class CliUnit {

  /**
   * Module CLI console.
   */
  @Projection
  public ConsoleHandle console() {
    return new PrintStreamBasedConsoleHandleImpl(System.out);
  }
}
