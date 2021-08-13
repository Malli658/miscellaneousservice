package com.ibm.miscellaneousservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.miscellaneousservice.model.BlockedAccount;

@Repository
public interface BlockedAccountRepository extends CrudRepository<BlockedAccount, Long>{
	@Query("SELECT b From BlockedAccount b where b.userId=?1")
	Page<BlockedAccount> getBlockedAccount(Long userID,Pageable pagable);
}
