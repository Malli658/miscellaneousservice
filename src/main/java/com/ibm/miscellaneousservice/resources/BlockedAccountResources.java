package com.ibm.miscellaneousservice.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.googlecode.jmapper.JMapper;
import com.ibm.miscellaneousservice.dto.BlockedUserDTO;
import com.ibm.miscellaneousservice.model.BlockedAccount;
import com.ibm.miscellaneousservice.services.BlockedAccountService;

@RestController
@RequestMapping("/block")
public class BlockedAccountResources {
	
	@Autowired
	private BlockedAccountService service;
	
	@PostMapping(value="/save/blocked")
	public ResponseEntity<Object> save(@RequestBody BlockedUserDTO dto){
		JMapper<BlockedAccount, BlockedUserDTO> blockedMapper=new JMapper<>(BlockedAccount.class, BlockedUserDTO.class);
		BlockedAccount blocked=blockedMapper.getDestination(dto);
		blocked=service.save(blocked);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blocked.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<Page<BlockedAccount>>  getBlockedAccounts(@RequestParam Long userId,@RequestParam Pageable pageble){
		Page<BlockedAccount> result=service.getBlockedAccount(userId, pageble);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/unblock")
	public ResponseEntity<String> unblockUser(@RequestParam Long blockAccountId){
		String result=service.unfollow(blockAccountId);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
}
