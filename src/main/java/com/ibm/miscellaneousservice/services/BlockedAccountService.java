package com.ibm.miscellaneousservice.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ibm.miscellaneousservice.model.BlockedAccount;

public interface BlockedAccountService {
	public BlockedAccount save(BlockedAccount blocked);
	public Page<BlockedAccount> getBlockedAccount(Long userID,Pageable pagable);
	public String unfollow(Long blockedAccountId);
}
