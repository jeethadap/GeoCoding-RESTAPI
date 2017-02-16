package com.atsc.service;

import org.springframework.stereotype.Service;

import com.atsc.domain.MerchantShop;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Jitendra
 *
 */
@Singleton
@Service
public class MerchantShopService {

	List<MerchantShop> merchantShoplist = Collections.synchronizedList(new ArrayList<MerchantShop>());


	@PostConstruct
    public void init() {
		//merchantShoplist.add(new MerchantShop("ReadingShop","44-45","RG1 4BQ"));
    }
	
	
	
	public void addMerchantShop(MerchantShop merchantShop) {
		this.merchantShoplist.add(merchantShop);
	}

	
	public List<MerchantShop> getMerchantShopList() {
		return merchantShoplist;
	}
}
