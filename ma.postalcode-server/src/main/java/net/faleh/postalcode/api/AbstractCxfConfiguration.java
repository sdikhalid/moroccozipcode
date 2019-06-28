package net.faleh.postalcode.api;

import java.util.Arrays;
import java.util.Set;

import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@ComponentScan
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class AbstractCxfConfiguration {

    private static final String CONTROLLER_CLASS_SUFFIX = "Controller";

    private static final String CONTROLLER_WITHOUT_TRANSACTION_CLASS_SUFFIX = "ControllerWithoutTransaction";


    /**
     * Check that the spring bean implements an interface ending with Controller, which is necessary to have a
     * transaction.
     *
     * @param springBean the spring bean to check
     */
    public void assertBeanImplementsInterfaceEndingWithController(Object springBean) {
        Class<?> beanClass = AopProxyUtils.ultimateTargetClass(springBean);
        boolean hasInterfaceEndingWithController = Arrays.stream(beanClass.getInterfaces()).anyMatch(
                interfaceClass -> interfaceClass.getCanonicalName().endsWith(CONTROLLER_CLASS_SUFFIX) || interfaceClass
                        .getCanonicalName()
                        .endsWith(CONTROLLER_WITHOUT_TRANSACTION_CLASS_SUFFIX));

        if (!hasInterfaceEndingWithController) {
            throw new WebServiceConfigurationException(beanClass);
        }
    }

    @Bean
    public LoggingInInterceptor apiLoggingInInterceptor() {
        return new LoggingInInterceptor();
    }

    @Bean
    public LoggingOutInterceptor apiLoggingOutInterceptor() {
        return new LoggingOutInterceptor();
    }

    @Bean
    public MdcCleanUpInterceptor apiMdcCleanUpInterceptor() {
        return new MdcCleanUpInterceptor();
    }
}
