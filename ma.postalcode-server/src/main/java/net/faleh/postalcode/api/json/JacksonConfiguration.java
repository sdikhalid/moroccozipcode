package net.faleh.postalcode.api.json;

import static net.faleh.postalcode.api.RestCxfConfiguration.API_MAPPER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Configuration
@ComponentScan
public class JacksonConfiguration {

	@Bean
	public JacksonJaxbJsonProvider apiJsonProvider() {
		return new JacksonJaxbJsonProvider();
	}

	@Bean
	/**
	 * @see {@link JavaTimeModule}
	 */
	public Module dateModuleConverters() {
		/**
		 * Register JodaModule to handle Joda DateTime Objects. https://github.com/FasterXML/jackson-datatype-jsr310
		 */
		return new JavaTimeModule();
	}

	@Bean
	/*
	 * @see {@link Jdk8Module}
	 */
	public Module optionalModuleConverters() {
		/*
		 * Register Jdk8Module to handle optionals
		 */
		return new Jdk8Module();
	}

	@Bean(name = API_MAPPER)
	public ObjectMapper apiObjectMapper() {
		return new ObjectMapper();
	}
}
