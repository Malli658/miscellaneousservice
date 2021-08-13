package com.ibm.miscellaneousservice.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ibm.miscellaneousservice.model.BlockedAccount;
import com.ibm.miscellaneousservice.repository.BlockedAccountRepository;

@Service
public class BlockedAccountServiceImpl implements BlockedAccountService{
	
	@Autowired
	private BlockedAccountRepository blockedAccountRepository;
	
	@Override
	public BlockedAccount save(BlockedAccount blocked){
		blocked.setBlockedDate(LocalDateTime.now());
		blocked= blockedAccountRepository.save(blocked);
		return blocked;
	}
	
	@Override
	public Page<BlockedAccount> getBlockedAccount(Long userID,Pageable pagable){
		return blockedAccountRepository.getBlockedAccount(userID, pagable);
	}
	
	@Override
	public String unfollow(Long blockedAccountId){
		blockedAccountRepository.deleteById(blockedAccountId);
		return "success";
	}
}
