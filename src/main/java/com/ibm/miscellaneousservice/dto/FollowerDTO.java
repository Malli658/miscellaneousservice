package com.ibm.miscellaneousservice.dto;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JGlobalMap
public class FollowerDTO {
	private Long userId;
	private Long followsUserId;
}
