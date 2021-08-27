package com.ibm.miscellaneousservice.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.miscellaneousservice.model.User;


@FeignClient("user-service")
public interface UserClient {
	
	@GetMapping(value="/user/get/{userId}")
	User getUser(@PathVariable("userId") Long userId);

}
