package intellispaces.cli;

import tech.intellispacesframework.core.exception.TraverseException;
import tech.intellispacesframework.core.guide.n1.Mover1;
import tech.intellispacesframework.core.transition.TransitionMethod1;
import tech.intellispacesframework.core.system.Modules;

// todo: Auto-generation
public class SystemConsoleHandleImpl extends SystemConsoleHandle {

  @Override
  public <Q> ConsoleHandle moveThru(String cid, Q qualifier) throws TraverseException {
    Mover1<SystemConsoleHandle, Q> mover = Modules.current().autoMoverThruTransition1(SystemConsoleHandle.class, cid);
    return mover.move(this, qualifier);
  }

  @Override
  public <Q> ConsoleHandle moveThru(TransitionMethod1<? super Console, ? extends Console, Q> transitionMethod, Q qualifier) {

    return null;
  }
}
