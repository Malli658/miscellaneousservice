package com.ibm.miscellaneousservice.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ibm.miscellaneousservice.model.NewsFeed;
import com.ibm.miscellaneousservice.repository.NewsFeedRepository;

@Service
public class NewsFeedSrviceImpl implements NewsFeedSrvice{
	
	@Autowired
	private NewsFeedRepository newsFeedRepository;
	
	@Override
	public NewsFeed save(NewsFeed newsFeed) {
		newsFeed.setPostedDateTime(LocalDateTime.now());
		newsFeed= newsFeedRepository.save(newsFeed);
		return newsFeed;
	}
	
	@Override
	public Page<NewsFeed> getNewsFeed(Long userID, Pageable pageble){
		return newsFeedRepository.getNewsFeed(userID, pageble);
	}
}
