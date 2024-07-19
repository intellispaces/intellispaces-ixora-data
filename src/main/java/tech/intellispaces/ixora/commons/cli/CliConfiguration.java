package tech.intellispaces.ixora.commons.cli;

import intellispaces.ixora.cli.MovableConsoleHandle;
import tech.intellispaces.framework.core.annotation.Configuration;
import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.ixora.commons.cli.PrintStreamBasedConsole;

@Configuration
public class CliConfiguration {

  /**
   * Projection to module system console.
   */
  @Projection
  public MovableConsoleHandle console() {
    return new PrintStreamBasedConsole(System.out);
  }
}
