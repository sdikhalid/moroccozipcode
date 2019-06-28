package net.faleh.postalcode.api.swagger;

import io.swagger.annotations.SwaggerDefinition;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.ReaderListener;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.AbstractSerializableParameter;
import io.swagger.models.parameters.Parameter;

@SwaggerDefinition
public class SwaggerReaderListenerImpl implements ReaderListener {

	@Override
	public void beforeScan(Reader reader, Swagger swagger) {
	}


	private void addDefault(Parameter parameter) {
		if (parameter instanceof AbstractSerializableParameter) {
			AbstractSerializableParameter abstractSerializableParameter = (AbstractSerializableParameter) parameter;
			if (abstractSerializableParameter.getDefaultValue() == null && abstractSerializableParameter.getExample() != null) {
				abstractSerializableParameter.setDefaultValue(abstractSerializableParameter.getExample().toString());
			}
		}
	}

	@Override
	public void afterScan(Reader reader, Swagger swagger) {
		addDefaultValueToParameters(swagger);
	}

	/**
	 * With the new swagger 3 x-example are not supported, see OSLO-20314 & https://github.com/swagger-api/swagger-ui/issues/3233.
	 * This method add x-example content in default value field in the swagger.json, those are supported by the new swagger-ui.
	 *
	 * @param swagger swagger definiton after scan
	 */
	private void addDefaultValueToParameters(Swagger swagger) {
		swagger.getPaths().forEach((s, path) -> path.getOperations().forEach(operation -> operation.getParameters().forEach(this::addDefault)));
	}
}
