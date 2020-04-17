package com.codaemons.be.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleID;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_active_flag")
	private char roleActiveFlag;
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
}
