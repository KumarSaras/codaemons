package com.codaemons.be.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Model class for {@link Questions} entity.
 * 
 * @author Pratik Gawali
 *
 */
@Entity
@Table(name = "questions")
@EntityListeners(AuditingEntityListener.class)
public class Questions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "question_id")
	private int questionID;
	
	@Column(name = "supported_language_id")
	private String supportedLanguageID;
	
	@Column(name = "question_type")
	private String questionType;
	
	@Column(name = "question_category")
	private String questionCategory; 
	
	@Column(name = "difficulty_level")
	private String difficultyLevel;
	
	@Column(name = "question_description")
	private String questionDescription;
	
	@Column(name = "question_active_flag")
	private boolean questionActiveFlag;
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private Timestamp lastModifiedDate;

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getSupportedLanguageID() {
		return supportedLanguageID;
	}

	public void setSupportedLanguageID(String supportedLanguageID) {
		this.supportedLanguageID = supportedLanguageID;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public boolean isQuestionActiveFlag() {
		return questionActiveFlag;
	}

	public void setQuestionActiveFlag(boolean questionActiveFlag) {
		this.questionActiveFlag = questionActiveFlag;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	} 
}
