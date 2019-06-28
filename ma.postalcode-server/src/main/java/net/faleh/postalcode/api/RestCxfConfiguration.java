package net.faleh.postalcode.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import io.swagger.annotations.Api;
import io.swagger.jaxrs.listing.ApiListingResource;
import net.faleh.postalcode.ApplicationProfiles;
import net.faleh.postalcode.api.json.JacksonContextResolver;

@Configuration
public class RestCxfConfiguration extends AbstractCxfConfiguration {

	final private static Logger LOGGER = LoggerFactory.getLogger(RestCxfConfiguration.class);

	public static final String API_MAPPER = "apiMapper";

	private final Bus bus;

	private final ApplicationContext context;

	private final Environment environment;

	@Value("${framework.api.base.path}")
	private String frameworkApiBasePath;

	@Value("${framework.api.cxf.base.path}")
	private String frameworkApiCxfBasePath;

	@Inject
	public RestCxfConfiguration(Bus bus, ApplicationContext applicationContext, Environment environment) {
		this.bus = bus;
		this.context = applicationContext;
		this.environment = environment;
	}

	@Bean
	public Server jaxRsWebServer(JacksonContextResolver jacksonContextResolver,
								 @Qualifier("apiJsonProvider") JacksonJaxbJsonProvider frontJsonProvider,
								 List<ExceptionMapper> exceptionMapper,
								 ApiListingResource apiListingResource) {
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setBus(bus);
		factory.setAddress("/" + frameworkApiBasePath);
		registerResources(factory, apiListingResource);
		List<Object> providers = new ArrayList<>(exceptionMapper);
		providers.add(Arrays.asList(jacksonContextResolver, frontJsonProvider));
		registerProviders(factory, providers);
		configureInterceptors(factory, apiLoggingInInterceptor(), apiLoggingOutInterceptor(),
				apiMdcCleanUpInterceptor());
		return factory.create();
	}

	private void configureInterceptors(JAXRSServerFactoryBean factory,
									   LoggingInInterceptor loggingInInterceptor,
									   LoggingOutInterceptor loggingOutInterceptor,
			MdcCleanUpInterceptor MdcCleanUpInterceptor) {
		List<Interceptor<? extends Message>> outInterceptors = new ArrayList<>();
		outInterceptors.add(loggingOutInterceptor);
		outInterceptors.add(new GZIPOutInterceptor(512));
		outInterceptors.add(MdcCleanUpInterceptor);
		factory.setOutInterceptors(outInterceptors);

		List<Interceptor<? extends Message>> inInterceptors = new ArrayList<>();
		inInterceptors.add(new GZIPInInterceptor());
		inInterceptors.add(loggingInInterceptor);
		factory.setInInterceptors(inInterceptors);
	}

	private void registerProviders(JAXRSServerFactoryBean factory, List<Object> providers) {
		LOGGER.info(String.format("found providers: %s", providers));
		factory.setProviders(providers);
	}

	private void registerResources(JAXRSServerFactoryBean factory, ApiListingResource apiListingResource) {
		// we only published documented rest service
		Collection<Object> beanWithProviderAnnotation = context.getBeansWithAnnotation(Api.class).values();

		LOGGER.debug(String.format("found service beans: %s", beanWithProviderAnnotation));

		List<Object> beanToRegister = new ArrayList<>();
		for (Object controller : beanWithProviderAnnotation) {
			assertBeanImplementsInterfaceEndingWithController(controller);
			beanToRegister.add(controller);
		}

		if (ApplicationProfiles.isNotProduction(environment)) {
			// adding the swagger resource that provides swagger.json
			beanToRegister.add(apiListingResource);
		}

		factory.setServiceBeans(beanToRegister);
	}

}
