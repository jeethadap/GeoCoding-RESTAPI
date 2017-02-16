package com.atsc;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.atsc.config.JerseyConfig;
import com.atsc.rest.RestResource;
import com.atsc.service.GeoCodingService;
import com.atsc.service.Location;
import com.atsc.service.MerchantShopService;



/**
 * @author Jitendra
 *
 */
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { RestResource.class, GeoCodingService.class, MerchantShopService.class, Location.class })
public class Application {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(Application.class).showBanner(false).run(args);
	}

	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
	}
}
