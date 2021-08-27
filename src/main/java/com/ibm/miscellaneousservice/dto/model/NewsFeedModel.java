package com.ibm.miscellaneousservice.dto.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;
import com.ibm.miscellaneousservice.dto.Activiti;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "media", itemRelation = "media")
@JsonInclude(Include.NON_NULL)
public class NewsFeedModel extends RepresentationModel<NewsFeedModel>{
	@JMap
	private Long id;
	@JMap
	private String text;
	@JMap
	private Long userId;
	@JMap
	private LocalDateTime postedDateTime;
	@JMap
	private Activiti activity;
}
