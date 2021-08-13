package com.ibm.miscellaneousservice.dto;

import lombok.Getter;
import lombok.Setter;

import com.googlecode.jmapper.annotations.JGlobalMap;

@Setter
@Getter
@JGlobalMap
public class BlockedUserDTO {
	private Long userId;
	private Long blockedUserId;
}
