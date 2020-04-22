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
@Table(name = "roles")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleID;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_active_flag")
	private boolean roleActiveFlag;
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
}
