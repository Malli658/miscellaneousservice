package com.ibm.miscellaneousservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.miscellaneousservice.model.Follower;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Long>{
	

}
