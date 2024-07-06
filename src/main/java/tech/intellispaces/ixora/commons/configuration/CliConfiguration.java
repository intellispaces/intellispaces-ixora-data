package tech.intellispaces.ixora.commons.configuration;

import tech.intellispaces.framework.core.annotation.Configuration;
import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.ixora.cli.ConsoleMovableHandle;
import tech.intellispaces.ixora.commons.cli.PrintStreamBasedConsole;

@Configuration
public class CliConfiguration {

  /**
   * Projection to module CLI console.
   */
  @Projection
  public ConsoleMovableHandle console() {
    return new PrintStreamBasedConsole(System.out);
  }
}
