package com.mm.admin.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mm.admin.model.v1.Role;
import com.mm.admin.model.v1.UserDetails;

import lombok.Data;

@Data
@JsonInclude(Include. NON_NULL)
public class UserProfileDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private boolean whatsappNumber;
	private String mobile;
	// private UserPreference userPreference;
	private UserDetails details;
	private Set<Role> roles;
}
