package com.codaemons.be.models.submission;

public class UserSubmissionRequest {
    private String userId;
    private String contestId;
    private String questionId;
    private String sourceCode;
    private int languageId;

    public UserSubmissionRequest(String userId, String contestId, String questionId, String sourceCode, int languageId) {
        this.userId = userId;
        this.contestId = contestId;
        this.questionId = questionId;
        this.sourceCode = sourceCode;
        this.languageId = languageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
