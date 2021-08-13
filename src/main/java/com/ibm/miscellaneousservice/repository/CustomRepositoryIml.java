package com.ibm.miscellaneousservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.miscellaneousservice.model.Follower;

@Repository
@Transactional
public class CustomRepositoryIml implements CustomRepository{
	
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	public Page<Follower> getFollower(Long userID,Pageable pagable,String type){
		Predicate predicate=null;
		CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery=builder.createQuery(Long.class);
		CriteriaQuery<Follower> criteriaQuery = builder.createQuery(Follower.class);
		Root<Follower> sm = criteriaQuery.from(Follower.class);
		countQuery.select(builder.count(countQuery.from(Follower.class)));
		if(type.equalsIgnoreCase("ALL"))
			predicate=builder.or(builder.equal(sm.get("userId"), userID),builder.equal(sm.get("followsUserId"), userID));
		else if(type.equalsIgnoreCase("Following"))
			predicate=builder.equal(sm.get("userId"), userID);
		else if(type.equalsIgnoreCase("Followers"))
			predicate=builder.equal(sm.get("followsUserId"), userID);
		System.out.println(predicate);
		criteriaQuery.where(predicate);
		countQuery.where(predicate);
		TypedQuery<Follower> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(new Long(pagable.getOffset()).intValue());
		typedQuery.setMaxResults(pagable.getPageSize());
		List<Follower> list = typedQuery.getResultList();
		Long total=entityManager.createQuery(countQuery).getSingleResult();
		return new PageImpl<>(list, pagable, 100);
		
	}
}
