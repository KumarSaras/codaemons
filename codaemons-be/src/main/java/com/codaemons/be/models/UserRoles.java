package com.codaemons.be.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_roles")
@Data
public class UserRoles {

	@Id
	@Column(name = "user_role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleID;
	
	@Column(name = "role_id")
	private int roleID;
	
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "updated_date")
	private Timestamp updatedDate;

}
