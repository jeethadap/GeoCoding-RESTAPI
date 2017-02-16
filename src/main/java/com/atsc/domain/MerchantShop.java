package com.atsc.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jitendra
 *
 */
@XmlRootElement
public class MerchantShop {

	
	private String shopName;
	private String shopAddressNumber;
	private String shopPostCode;
	private String shopLongitude;
	private String shopLatitude;
	
	public MerchantShop() {
		// TODO Auto-generated constructor stub
	}

	public MerchantShop(String shopName, String shopAddressNumber, String shopPostCode) {
		super();
		this.shopName = shopName;
		this.shopAddressNumber = shopAddressNumber;
		this.shopPostCode = shopPostCode;
	}


	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddressNumber() {
		return shopAddressNumber;
	}

	public void setShopAddressNumber(String shopAddressNumber) {
		this.shopAddressNumber = shopAddressNumber;
	}

	public String getShopPostCode() {
		return shopPostCode;
	}

	public void setShopPostCode(String shopPostCode) {
		this.shopPostCode = shopPostCode;
	}

	public String getShopLongitude() {
		return shopLongitude;
	}

	public void setShopLongitude(String shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	public String getShopLatitude() {
		return shopLatitude;
	}

	public void setShopLatitude(String shopLatitude) {
		this.shopLatitude = shopLatitude;
	}
	

	public String getShopAddress() {
		return shopAddressNumber +", "+ shopName + "," + shopPostCode;
	}
	
}
