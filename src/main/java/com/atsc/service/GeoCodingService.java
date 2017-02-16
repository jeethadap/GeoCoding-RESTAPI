package com.atsc.service;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;


/**
 * @author Jitendra
 *
 */
@Singleton
@Service
public class GeoCodingService {
	LatLng latlng;
	
	public LatLng getGeoCordinates(String address) {
		
		try {
			GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyC-NfP7g5ce9CkYn7qXnGbJjyJFPIVy9eg");
			GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
			
			latlng = new LatLng(results[0].geometry.location.lat, results[0].geometry.location.lng);
			
		} catch (Exception e) {
			  
			e.printStackTrace();
		}
		
		return latlng;
	}
}
