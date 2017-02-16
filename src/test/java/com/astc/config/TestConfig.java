package com.astc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.atsc.rest.RestResource;
import com.atsc.service.GeoCodingService;
import com.atsc.service.Location;
import com.atsc.service.MerchantShopService;


/**
 * @author Jitendra
 *
 */
@Configuration
@ComponentScan(basePackageClasses = { RestResource.class, GeoCodingService.class, MerchantShopService.class, Location.class })
public class TestConfig {
}
