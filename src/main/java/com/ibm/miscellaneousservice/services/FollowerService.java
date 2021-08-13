package com.ibm.miscellaneousservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ibm.miscellaneousservice.model.Follower;

public interface FollowerService {
	public Follower save(Follower follower);
	public Page<Follower> getFollower(Long userId, Pageable pageable,String type);
	public String unFollow(Long followId);
}
