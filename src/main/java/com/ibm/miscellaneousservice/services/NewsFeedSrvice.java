package com.ibm.miscellaneousservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ibm.miscellaneousservice.model.NewsFeed;

public interface NewsFeedSrvice {
	public NewsFeed save(NewsFeed newsFeed);
	public Page<NewsFeed> getNewsFeed(Long userID, Pageable pageble);
}
