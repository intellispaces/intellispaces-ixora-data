package tech.intellispaces.ixora.commons.cli;

import tech.intellispacesframework.core.annotation.Projection;
import tech.intellispacesframework.core.annotation.Unit;

@Unit
public class CliUnit {

  @Projection
  public SystemConsoleHandle console() {
    return new SystemConsoleHandleImpl();
  }
}
