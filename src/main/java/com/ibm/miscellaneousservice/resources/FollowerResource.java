package com.ibm.miscellaneousservice.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
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
import com.ibm.miscellaneousservice.assembler.FollowAssembler;
import com.ibm.miscellaneousservice.dto.FollowerDTO;
import com.ibm.miscellaneousservice.dto.model.BlockedAccountModel;
import com.ibm.miscellaneousservice.dto.model.FollowerModel;
import com.ibm.miscellaneousservice.model.BlockedAccount;
import com.ibm.miscellaneousservice.model.Follower;
import com.ibm.miscellaneousservice.services.FollowerService;

@RestController
@RequestMapping("/follow")
public class FollowerResource {
    
	@Autowired
	private FollowerService service;
	
	@Autowired
    private PagedResourcesAssembler<Follower> pagedResourcesAssembler;
	
	@Autowired
	private FollowAssembler followAssembler;
	
	@PostMapping(value="/save/fllow")
	public ResponseEntity<Object> save(@RequestBody FollowerDTO follower){
		JMapper<Follower, FollowerDTO> followMapper=new JMapper<>(Follower.class, FollowerDTO.class);
		Follower result=followMapper.getDestination(follower);
		Follower res=service.save(result);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(res.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<PagedModel<FollowerModel>> getFollowers(@RequestParam Long userID,@PageableDefault(value = 30)Pageable pageable,@RequestParam String type){
		Page<Follower> followers=service.getFollower(userID, pageable, type);
		PagedModel<FollowerModel> collModel = pagedResourcesAssembler
                .toModel(followers, followAssembler);
		return new ResponseEntity<>(collModel,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/unfollow")
	public ResponseEntity<String> unfollow(@RequestParam Long followID){
		String result=service.unFollow(followID);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

}
