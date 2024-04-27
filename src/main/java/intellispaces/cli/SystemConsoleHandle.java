package intellispaces.cli;

import tech.intellispacesframework.core.annotation.Mover;
import tech.intellispacesframework.core.annotation.ObjectHandle;

import java.io.PrintStream;

@ObjectHandle
public abstract class SystemConsoleHandle extends ConsoleHandle {
  private final PrintStream out;

  public SystemConsoleHandle() {
    this.out = System.out;
  }

  @Mover
  @Override
  public ConsoleHandle sameWithLastMessage(String message) {
    out.print(message);
    return this;
  }

  @Mover
  @Override
  public ConsoleHandle sameWithLastMessageAndNewLine(String message) {
    out.println(message);
    return this;
  }
}
