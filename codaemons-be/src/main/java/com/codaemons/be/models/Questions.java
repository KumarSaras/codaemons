package com.codaemons.be.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for {@link Questions} entity.
 * 
 * @author Pratik Gawali
 *
 */
@Entity
@Table(name = "questions")
public class Questions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "question_id")
	private int questionID; // TODO: should be UUID or int?
	
	@Column(name = "supported_language_id")
	private int supportedLanguageID; // TODO: should be int or comma separated lang code?
	
	@Column(name = "question_type")
	private String questionType; // TODO: what exactly does this field do?
	
	@Column(name = "question_category")
	private String questionCategory; // TODO: what exactly does this field do?
	
	@Column(name = "difficulty_level")
	private String difficultyLevel;
	
	@Column(name = "question_description")
	private String questionDescription; // TODO: type should be string or binary?
	
	@Column(name = "question_active_flag")
	private boolean questionActiveFlag; // TODO: how will this flag be used?
	
	@Column(name = "updated_date")
	private Date updatedDate; // TODO: what about lastModifiedAt field name?

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getSupportedLanguageID() {
		return supportedLanguageID;
	}

	public void setSupportedLanguageID(int supportedLanguageID) {
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

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
