package com.ibm.miscellaneousservice.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import com.googlecode.jmapper.annotations.JGlobalMap;

@Setter
@Getter
@JGlobalMap
public class NewsFeedDTO {
	private String text;
	private Long userId;
	private Activiti activity;
	
}
