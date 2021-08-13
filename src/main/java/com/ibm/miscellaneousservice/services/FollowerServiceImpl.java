package com.ibm.miscellaneousservice.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ibm.miscellaneousservice.model.Follower;
import com.ibm.miscellaneousservice.repository.CustomRepository;
import com.ibm.miscellaneousservice.repository.FollowerRepository;

@Service
public class FollowerServiceImpl implements FollowerService{
	
	@Autowired
	private FollowerRepository followerRepository;
	@Autowired
	private CustomRepository customRepository;
	
	@Override
	public Follower save(Follower follower){
		follower.setFolloweddDate(LocalDateTime.now());
		follower= followerRepository.save(follower);
		return follower;
	}
	
	@Override
	public Page<Follower> getFollower(Long userId, Pageable pageable,String type){
		return customRepository.getFollower(userId, pageable, type);
	}
	
	@Override
	public String unFollow(Long followId){
		followerRepository.deleteById(followId);
		return "success";
	}
}
