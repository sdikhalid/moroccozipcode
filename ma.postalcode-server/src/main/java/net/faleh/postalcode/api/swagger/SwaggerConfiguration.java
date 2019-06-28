package net.faleh.postalcode.api.swagger;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Configuration
public class SwaggerConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfiguration.class);

	@Value("${framework.api.base.path}")
	private String frameworkApiBasePath;

	@Value("${framework.api.cxf.base.path}")
	private String frameworkApiCxfBasePath;

	@Value("${webapp.name:Application}")
	private String applicationName;

	@Bean
	public SwaggerSerializers swaggerWriter() {
		return new SwaggerSerializers();
	}

	@Bean
	public ApiListingResource swaggerResource() {
		return new ApiListingResource();
	}

	@Autowired(required = false)
	private ServletContext servletContext;

	public BeanConfig createSwaggerBeanConfig(String title, String description, String version) {
		String contextPath;
		if (servletContext != null) {
			contextPath = servletContext.getContextPath();
		} else {
			LOGGER.warn("could not determine base path, servletContext failed.");
			contextPath = "";
		}
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setResourcePackage("net.faleh");
		beanConfig.setBasePath(contextPath + "/" + frameworkApiCxfBasePath + "/" + frameworkApiBasePath);
		beanConfig.setTitle(title);
		beanConfig.setDescription(description);
		beanConfig.setVersion(version);
		beanConfig.setScan(true);
		return beanConfig;
	}

	@Bean
	public BeanConfig swaggerConfig() {
		return createSwaggerBeanConfig(applicationName, "Rest API.",
				this.getClass().getPackage().getImplementationVersion());
	}
}