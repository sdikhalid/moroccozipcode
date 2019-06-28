package net.faleh.postalcode.api.json;

import javax.inject.Inject;
import javax.inject.Named;

import com.fasterxml.jackson.databind.module.SimpleModule;

@Named
public class ApiConvertersModule extends SimpleModule {

	private final ApiStringDeserializer apiStringDeserializer;

	@Inject
	public ApiConvertersModule(ApiStringDeserializer apiStringDeserializer) {
		super(ApiConvertersModule.class.getSimpleName());
		this.apiStringDeserializer = apiStringDeserializer;
		addDeserializer(String.class, this.apiStringDeserializer);
	}
}
