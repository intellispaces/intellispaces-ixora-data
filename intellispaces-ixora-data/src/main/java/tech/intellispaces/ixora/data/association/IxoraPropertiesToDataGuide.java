package tech.intellispaces.ixora.data.association;

import tech.intellispaces.entity.exception.UnexpectedExceptions;
import tech.intellispaces.entity.function.FunctionFunctions;
import tech.intellispaces.entity.type.ClassFunctions;
import tech.intellispaces.jaquarius.annotation.Guide;
import tech.intellispaces.jaquarius.annotation.Mapper;
import tech.intellispaces.jaquarius.common.NameConventionFunctions;
import tech.intellispaces.jaquarius.object.DataFunctions;
import tech.intellispaces.jaquarius.object.ObjectFunctions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

@Guide
public class IxoraPropertiesToDataGuide implements PropertiesToDataGuide {

  @Mapper
  @Override
  public <D> D propertiesToData(Properties properties, Class<? extends D> dataClass) {
    if (DataFunctions.isDataObjectHandle(dataClass)) {
      return process(properties, dataClass);
    }
    throw new UnsupportedOperationException("Not implemented");
  }

  @SuppressWarnings("unchecked")
  private <D> D process(Properties properties, Class<D> dataClass) {
    Class<?> domainClass = ObjectFunctions.getDomainClassOfObjectHandle(dataClass);
    String dataHandleObjectCanonicalName = NameConventionFunctions.getDataClassName(domainClass.getName());
    Class<?> dataHandleObjectClass = ClassFunctions.getClassOrElseThrow(dataHandleObjectCanonicalName, () ->
        UnexpectedExceptions.withMessage("Can't find data handle class. Domain class {0}, " +
                "expected data handle class {1}", domainClass.getCanonicalName(), dataHandleObjectCanonicalName));
    Constructor<?>[] constructors = dataHandleObjectClass.getDeclaredConstructors();
    if (constructors.length != 1) {
      throw UnexpectedExceptions.withMessage("Data class {0} must contain one constructor",
          dataHandleObjectCanonicalName);
    }
    Constructor<?> constructor = constructors[0];
    if (constructor.getParameterCount() != domainClass.getMethods().length) {
      throw UnexpectedExceptions.withMessage("Data class {0} must contain constructor with {1} parameters",
          dataHandleObjectCanonicalName, dataClass.getMethods().length);
    }

    Object[] arguments = new Object[constructor.getParameterCount()];
    int index = 0;
    for (Parameter param : constructor.getParameters()) {
      Object value = properties.value(param.getName());
      if (value == null && param.getType().isPrimitive()) {
        value = ClassFunctions.getDefaultValueOf(param.getType());
      }
      if (value instanceof Properties && ObjectFunctions.isObjectHandleClass(param.getType())) {
        value = process((Properties) value, param.getType());
      }
      arguments[index++] = value;
    }
    return (D) FunctionFunctions.applyAndWrap(arguments, constructor::newInstance);
  }
}
