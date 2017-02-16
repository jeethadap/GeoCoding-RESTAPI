package com.atsc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsc.domain.Customer;
import com.atsc.domain.MerchantShop;
import com.atsc.service.GeoCodingService;
import com.atsc.service.Location;
import com.atsc.service.MerchantShopService;
import com.google.maps.model.LatLng;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.List;

@Path("/")
@Component
public class RestResource {

	@Autowired
	private GeoCodingService geoCodingService;

	@Autowired
	private MerchantShopService merchantShopService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getNearestShop")
	public MerchantShop getNearestShop(Customer customer) {
		Double custLat = Double.parseDouble(customer.getCustomerLatitude());
		Double custLong = Double.parseDouble(customer.getCustomerLongitude());
		Location custLoc = new Location(custLat, custLong);
		 
		double distance = -1; 
		int index=0;
		int counter=0;
		
		List<MerchantShop> merchantShopList = merchantShopService.getMerchantShopList();
		
		for (MerchantShop merchantShop : merchantShopList) {
			
			
			 Location shoploc = new Location(Double.parseDouble(merchantShop.getShopLatitude()), Double.parseDouble(merchantShop.getShopLongitude()));
			 
			 double nearestDistance = custLoc.distanceTo(shoploc);
			  
			 if (distance == -1 || nearestDistance < distance){
				 index = counter;
				 distance = nearestDistance;
			 }
			 
			counter++; 
		}
		
		return merchantShopList.get(index);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addShop")
	public Response addShop(MerchantShop merchantShop){
		
		String shopAddress = merchantShop.getShopAddress();
		LatLng latlng = geoCodingService.getGeoCordinates(shopAddress);

		merchantShop.setShopLatitude(String.valueOf(latlng.lat));	
		merchantShop.setShopLongitude(String.valueOf(latlng.lng));	

		merchantShopService.addMerchantShop(merchantShop);
		
		String result = "Shop added Successfully";
		return Response.status(201).entity(result).build();
	}
	
	
	
}
