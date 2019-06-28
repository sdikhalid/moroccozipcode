package net.faleh.postalcode.api;

public class WebServiceConfigurationException extends RuntimeException {

	public WebServiceConfigurationException(Class<?> beanClass) {
		super(String.format("%s class is a webservice but does not implement an interface ending with Controller.",
				beanClass));
	}
}
