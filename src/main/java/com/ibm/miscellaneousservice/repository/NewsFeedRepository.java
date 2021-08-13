package com.ibm.miscellaneousservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.miscellaneousservice.model.NewsFeed;

@Repository
public interface NewsFeedRepository extends CrudRepository<NewsFeed, Long>{
	@Query("SELECT n From NewsFeed n where n.userId=?1")
     Page<NewsFeed> getNewsFeed(Long userID,Pageable pagable);
}
