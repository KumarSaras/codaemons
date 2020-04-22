package com.codaemons.be.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "user_first_name")
	private String userFirstName;
	
	@Column(name = "user_last_name")
	private String userLastName;
	
	@Column(name = "username")
	private String username;
	
	@JsonIgnore
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_address_id")
	private int userAddressID;
	
	@Column(name = "user_org_id")
	private int userOrgID;
	
	@Column(name = "user_active_flag")
	private boolean userActiveFlag;
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
}
