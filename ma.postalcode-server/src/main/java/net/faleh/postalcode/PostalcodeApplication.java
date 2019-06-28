package net.faleh.postalcode;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.RequestContextListener;

import net.faleh.postalcode.database.LiquibaseConfiguration;

@SpringBootApplication
@Import(LiquibaseConfiguration.class)
public class PostalcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostalcodeApplication.class, args);
    }

    @ConditionalOnClass({CXFServlet.class, TomcatServletWebServerFactory.class})
    public static class CxfBootConfiguration {

        @Value("${framework.api.cxf.base.path}")
        private String frameworkApiCxfBasePath;

        @Bean
        public ServletRegistrationBean cxfServletRegistrationBean() {
            return new ServletRegistrationBean(new CXFServlet(), "/" + frameworkApiCxfBasePath + "/*");
        }

    }

}
