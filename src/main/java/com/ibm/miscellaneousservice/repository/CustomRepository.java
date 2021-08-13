package com.ibm.miscellaneousservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ibm.miscellaneousservice.model.Follower;


public interface CustomRepository {
	public Page<Follower> getFollower(Long userID,Pageable pagable,String type);
}
