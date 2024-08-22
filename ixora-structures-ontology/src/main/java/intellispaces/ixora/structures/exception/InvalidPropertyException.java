package intellispaces.ixora.structures.exception;

import tech.intellispaces.core.exception.TraverseException;

public class InvalidPropertyException extends TraverseException {

  InvalidPropertyException(String messageTemplate, Object... messageParams) {
    super(messageTemplate, messageParams);
  }

  InvalidPropertyException(Throwable cause, String messageTemplate, Object... messageParams) {
    super(cause, messageTemplate, messageParams);
  }

  public static InvalidPropertyException withMessage(String messageTemplate, Object... messageParams) {
    return new InvalidPropertyException((Throwable)null, messageTemplate, messageParams);
  }

  public static InvalidPropertyException withCauseAndMessage(Throwable cause, String messageTemplate, Object... messageParams) {
    return new InvalidPropertyException(cause, messageTemplate, messageParams);
  }
}
