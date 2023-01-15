package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import business.OrdersBusinessInterface;
import business.OrdersBusinessService;
import business.SecurityBusinessService;

@Configuration
public class SpringConfig {

	@Bean(name = "ordersBusinessService")
	public OrdersBusinessInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
	@Bean
	  public SecurityBusinessService securityBusinessService() {
	    return new SecurityBusinessService();
	  }
}
