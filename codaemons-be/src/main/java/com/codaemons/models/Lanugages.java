package com.codaemons.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "languages")
@Data
public class Lanugages {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "language_id")
	private int languageID;
	
	@Column(name = "language_name")
	private String languageName;
	
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
}