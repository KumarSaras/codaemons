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
@Table(name = "user_address")
@EntityListeners(AuditingEntityListener.class)
@Data
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_address_id")
	private Integer userAddressID;

	@Column(name = "address_line_1")
    private String addressLine1;

	@Column(name = "address_line_2")
    private String addressLine2;

	@Column(name = "city")
    private String city;

	@Column(name = "state")
    private String state;

	@Column(name = "country")
    private String country;

	@Column(name = "zipcode")
    private Integer zipcode;

	@Column(name = "email_id")
    private String emailID;

	@Column(name = "contact_number")
    private Double contactNumber;

	@LastModifiedDate
	@Column(name = "updated_date")
    private LocalDateTime updatedDate;

}