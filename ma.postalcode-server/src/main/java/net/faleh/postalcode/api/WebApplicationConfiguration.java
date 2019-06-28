package net.faleh.postalcode.api;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import net.faleh.postalcode.RootConfiguration;


/**
 * Setting up CXF and spring using Servlet 3.0.
 */
public class WebApplicationConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfiguration.class);

        container.addListener(new ContextLoaderListener(rootContext));
        container.addListener(RequestContextListener.class);

        ServletRegistration.Dynamic dispatcher = container.addServlet("CXFServlet", CXFServlet.class);
        dispatcher.addMapping("/api/*");
    }
}
