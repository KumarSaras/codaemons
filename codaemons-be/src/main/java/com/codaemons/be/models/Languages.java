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
@Table(name = "languages")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Languages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int languageID;
	
	@Column(name = "language_name")
	private String languageName;
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
}