# GeoCoding-RESTAPI - The application is build using SpringBoot, Jersey, gradle. 

For obtaining the latitude and longitude of merchant shop Google GeoCoding APIs are invoked internally and stored in-Memory ArrayList. 
You need to add the shops before invoking nearByShop request. 

1. To add the MerchantShop: 

  Use below URL in PostMan APP 
  
  Method : POST
  
  URL : http://localhost:8080/rest/addShop 
  
  Auth : Basic Auth
  
  Credentials : demo/123
  
  Body : 
  {
	"shopName" : "Amphitheatre Parkway",
	"shopAddressNumber" : "1600",
	"shopPostCode" : "94043"
  }
  
  jSON{application/json}


2. To get nearest the shop: Use below URL in PostMan APP 

  Method : POST
  
  URL : http://localhost:8080/rest/getNearestShop 
  
  Auth : Basic Auth
  
  Credentials : demo/123
  
  Body : 
  {
	  "firstName" : "testCust",
	  "customerLongitude" : "44.366633",
	  "customerLatitude" : "78.640832"
  }
  
  jSON{application/json}
  
