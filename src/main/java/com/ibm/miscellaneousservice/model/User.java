package com.ibm.miscellaneousservice.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private String firstName;
	private String lastName;
	private String userName;
	private Date birthDate;
	private String gender;
	private Date createdDate;
	private String email;
	private String userProfilePicLink;
}
