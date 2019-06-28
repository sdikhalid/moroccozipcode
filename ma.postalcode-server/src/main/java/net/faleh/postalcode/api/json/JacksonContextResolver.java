package net.faleh.postalcode.api.json;

import static net.faleh.postalcode.api.RestCxfConfiguration.API_MAPPER;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import net.faleh.postalcode.ApplicationProfiles;

@Provider
@Named
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	final private static Logger LOGGER = LoggerFactory.getLogger(JacksonContextResolver.class);

	private final ObjectMapper mapper;

	@Inject
	public JacksonContextResolver(List<Module> modules,
			@Qualifier(API_MAPPER) ObjectMapper apiObjectMapper,
			Environment environment) {
		this.mapper = apiObjectMapper;
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		for (Module module : modules) {
			LOGGER.info("registering module : {}", module);
			mapper.registerModule(module);
		}
		if (environment != null && ApplicationProfiles.isNotProduction(environment)) {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
		}
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}
}
