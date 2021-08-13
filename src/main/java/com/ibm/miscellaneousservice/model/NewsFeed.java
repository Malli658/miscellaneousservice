package com.ibm.miscellaneousservice.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ibm.miscellaneousservice.dto.Activiti;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class NewsFeed {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String text;
	private Long userId;
	private LocalDateTime postedDateTime;
	private Activiti activity;
	
}
