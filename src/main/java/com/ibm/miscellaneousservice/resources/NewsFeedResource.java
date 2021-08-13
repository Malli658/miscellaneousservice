package com.ibm.miscellaneousservice.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.googlecode.jmapper.JMapper;
import com.ibm.miscellaneousservice.dto.NewsFeedDTO;
import com.ibm.miscellaneousservice.model.NewsFeed;
import com.ibm.miscellaneousservice.services.NewsFeedSrvice;

@RestController
@RequestMapping("/news")
public class NewsFeedResource {
	
	@Autowired
	private NewsFeedSrvice service;
	
	@PostMapping(value="/save/newsfeed")
	public ResponseEntity<Object> save(@RequestBody NewsFeedDTO dto){
		JMapper<NewsFeed, NewsFeedDTO> newsfeedMapper=new JMapper<>(NewsFeed.class, NewsFeedDTO.class);
		NewsFeed newsFeed=newsfeedMapper.getDestination(dto);
		newsFeed=service.save(newsFeed);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newsFeed.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<Page<NewsFeed>> getNewsFeeds(@RequestParam Long userId, Pageable pageable){
		Page<NewsFeed>  result=service.getNewsFeed(userId, pageable);
		return new ResponseEntity<Page<NewsFeed>>(result, HttpStatus.OK);
	}
}
