package intellispaces.ixora.structures.properties;

import intellispaces.commons.exception.UnexpectedViolationException;
import intellispaces.commons.function.FunctionFunctions;
import intellispaces.commons.type.TypeFunctions;
import intellispaces.core.annotation.Guide;
import intellispaces.core.annotation.Mapper;
import intellispaces.core.common.NameConventionFunctions;
import intellispaces.core.object.DataFunctions;
import intellispaces.core.object.ObjectFunctions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

@Guide
public class IxoraPropertiesToDataGuide<D> implements PropertiesToDataGuide<D> {

  @Mapper
  @Override
  public <T extends D> T propertiesToData(Properties properties, Class<? extends T> dataClass) {
    if (DataFunctions.isDataObjectHandle(dataClass)) {
      return process(properties, dataClass);
    }
    throw new UnsupportedOperationException("Not implemented");
  }

  @SuppressWarnings("unchecked")
  private <T> T process(Properties properties, Class<T> targetClass) {
    Class<?> domainClass = ObjectFunctions.getDomainClassOfObjectHandle(targetClass);
    String dataHandleObjectCanonicalName = NameConventionFunctions.getDataClassName(domainClass.getName());
    Class<?> dataHandleObjectClass = TypeFunctions.getClassOrElseThrow(dataHandleObjectCanonicalName, () ->
        UnexpectedViolationException.withMessage("Can't find data handle class. Domain class {}, expected data handle class {}",
            domainClass.getCanonicalName(), dataHandleObjectCanonicalName));
    Constructor<?>[] constructors = dataHandleObjectClass.getDeclaredConstructors();
    if (constructors.length != 1) {
      throw UnexpectedViolationException.withMessage("Data class {} must contain one constructor", dataHandleObjectCanonicalName);
    }
    Constructor<?> constructor = constructors[0];
    if (constructor.getParameterCount() != domainClass.getMethods().length) {
      throw UnexpectedViolationException.withMessage("Data class {} must contain constructor with {} parameters",
          dataHandleObjectCanonicalName, targetClass.getMethods().length);
    }

    Object[] arguments = new Object[constructor.getParameterCount()];
    int index = 0;
    for (Parameter param : constructor.getParameters()) {
      Object value = properties.value(param.getName());
      if (value == null && param.getType().isPrimitive()) {
        value = TypeFunctions.getDefaultValueOf(param.getType());
      }
      if (value instanceof Properties && ObjectFunctions.isObjectHandleClass(param.getType())) {
        value = process((Properties) value, param.getType());
      }
      arguments[index++] = value;
    }
    return (T) FunctionFunctions.applyAndCoverIfChecked(constructor::newInstance, arguments);
  }
}
