package com.codaemons.be.models.submission;


import javax.persistence.*;

@Entity
@Table(name="user_contests")
public class UserContest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private int submissionId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "contest_id")
    private int contestId;

    @Column(name = "question_id")
    private int questionId;


    @Column(name = "submission_status")
    private String submissionStatus;

    public UserContest(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSubmissionId() {
        return submissionId;
    }


    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }
}
