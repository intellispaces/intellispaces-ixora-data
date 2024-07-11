package tech.intellispaces.ixora.commons.cli;

import intellispaces.ixora.cli.MovableConsoleHandle;
import tech.intellispaces.framework.core.annotation.Mover;
import tech.intellispaces.framework.core.annotation.ObjectHandle;

import java.io.PrintStream;

@ObjectHandle("PrintStreamBasedConsole")
public abstract class AbstractPrintStreamBasedConsole implements MovableConsoleHandle {
  private final PrintStream ps;

  public AbstractPrintStreamBasedConsole(PrintStream ps) {
    this.ps = ps;
  }

  @Mover
  @Override
  public Void print(String message) {
    ps.print(message);
    return null;
  }

  @Mover
  @Override
  public Void println(String message) {
    ps.println(message);
    return null;
  }
}
