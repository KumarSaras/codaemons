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

import lombok.Data;

@Entity
@Table(name = "user_roles")
@EntityListeners(AuditingEntityListener.class)
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
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

}
