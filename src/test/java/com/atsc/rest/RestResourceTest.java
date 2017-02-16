package com.atsc.rest;

import com.astc.config.TestConfig;
import com.atsc.config.JerseyConfig;
import com.atsc.domain.Customer;
import com.atsc.domain.MerchantShop;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

import org.glassfish.jersey.server.spring.SpringComponentProvider;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * @author Jitendra
 *
 */
public class RestResourceTest extends JerseyTest {

	  private static final double EPSILON = 0.005;

	  
	@Override
	protected Application configure() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
		return new JerseyConfig().property("contextConfig", context);
	}

	@Test
	public void testPostByManager() {
		MerchantShop merShop = new MerchantShop("Amphitheatre Parkway","1600","94043");
		final String result = target("rest/addShop").request().post(Entity.json(merShop),String.class);
		assertThat(result).isEqualTo("Shop added Successfully");
	}

	@Test
	public void testGeoCodeingAPI() throws Exception {
		
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyC-NfP7g5ce9CkYn7qXnGbJjyJFPIVy9eg");
		GeocodingResult[] results = GeocodingApi.newRequest(context).address("Thalner").await();
		
		assertEquals(21.259152, results[0].geometry.location.lat, EPSILON);
	    assertEquals(74.953263, results[0].geometry.location.lng, EPSILON);

		
	}
	
	@Test
	public void testNearestShop() throws Exception {
		
		Customer cust = new Customer("testCust","44.366633","78.640832");
		 MerchantShop nerestShop = target("rest/getNearestShop").request().post(Entity.json(cust),MerchantShop.class);
		
	    assertEquals("40.366633", nerestShop.getShopLatitude(), EPSILON);
	    assertEquals("74.640832", nerestShop.getShopLongitude(), EPSILON);

	}
}
