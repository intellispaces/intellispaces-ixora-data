package tech.intellispaces.ixora.commons.cli;

import tech.intellispaces.ixora.cli.ConsoleHandle;
import tech.intellispaces.framework.core.annotation.Mover;
import tech.intellispaces.framework.core.annotation.ObjectHandle;

import java.io.PrintStream;

@ObjectHandle
public abstract class PrintStreamBasedConsoleHandle extends ConsoleHandle {
  private final PrintStream ps;

  public PrintStreamBasedConsoleHandle(PrintStream ps) {
    this.ps = ps;
  }

  @Mover
  @Override
  public ConsoleHandle sameConsoleWithLastMessage(String message) {
    ps.print(message);
    return this;
  }

  @Mover
  @Override
  public ConsoleHandle sameConsoleWithLastMessageAndNewLine(String message) {
    ps.println(message);
    return this;
  }
}
