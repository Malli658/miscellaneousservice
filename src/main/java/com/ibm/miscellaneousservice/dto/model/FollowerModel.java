package com.ibm.miscellaneousservice.dto.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
//@Relation(collectionRelation = "media", itemRelation = "media")
@JsonInclude(Include.NON_NULL)
public class FollowerModel extends RepresentationModel<FollowerModel>{
	@JMap
	private Long id;
	@JMap
	private Long userId;
	@JMap
	private Long followsUserId;
	@JMap
	private LocalDateTime followeddDate;
}
