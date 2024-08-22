package intellispaces.ixora.structures.properties;

import intellispaces.commons.exception.UnexpectedViolationException;
import intellispaces.commons.function.FunctionFunctions;
import intellispaces.commons.type.TypeFunctions;
import intellispaces.core.annotation.Guide;
import intellispaces.core.annotation.Mapper;
import intellispaces.core.common.NameConventionFunctions;
import intellispaces.core.object.ObjectFunctions;
import intellispaces.ixora.structures.properties.PropertiesHandle;
import intellispaces.ixora.structures.properties.PropertiesToDataMapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

@Guide
public class PropertiesToDataIxoraMapper implements PropertiesToDataMapper {

  @Mapper
  @Override
  public <T> T propertiesToData(PropertiesHandle properties, Class<T> targetClass) {
    if (ObjectFunctions.isDataObjectHandle(targetClass)) {
      return process(properties, targetClass);
    }
    throw new UnsupportedOperationException("Not implemented");
  }

  @SuppressWarnings("unchecked")
  private <T> T process(PropertiesHandle properties, Class<T> targetClass) {
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
      if (value instanceof PropertiesHandle && ObjectFunctions.isObjectHandleClass(param.getType())) {
        value = process((PropertiesHandle) value, param.getType());
      }
      arguments[index++] = value;
    }
    return (T) FunctionFunctions.applyAndCoverIfChecked(constructor::newInstance, arguments);
  }
}
