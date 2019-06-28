package net.faleh.postalcode.api.swagger;


import static net.faleh.postalcode.api.swagger.SwaggerUIFilter.SWAGGER_UI;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@WebFilter(value = "/" + SWAGGER_UI + "/*")
@Slf4j
public class SwaggerUIFilter implements Filter {

	static final String SWAGGER_UI = "swagger-ui";

	private String swaggerVersion;

	@Override
	public void init(FilterConfig config) {
		swaggerVersion = determineSwaggerVersion().orElse(null);
	}

	Optional<String> determineSwaggerVersion() {
		URL location = this.getClass().getClassLoader().getResource("META-INF/resources/webjars/swagger-ui");
		if (location != null) {
			Matcher m = Pattern.compile("swagger-ui-(.*?).jar").matcher(location.getFile());
			if (m.find()) {
				return Optional.ofNullable(m.group(1));
			}
		}
		log.warn("could not find swagger-ui version, swagger-ui will not be accessible");
		return Optional.empty();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException,
			IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		String requestURI = request.getRequestURI();
		if (requestURI.contains(SWAGGER_UI) && swaggerVersion != null) {
			String newURI = requestURI.replaceFirst(SWAGGER_UI, "webjars/swagger-ui/" + swaggerVersion).replaceFirst(
					request.getContextPath(), "");
			req.getRequestDispatcher(newURI).forward(req, res);
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
	}
}