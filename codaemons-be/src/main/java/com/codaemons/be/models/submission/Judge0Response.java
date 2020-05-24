package com.codaemons.be.models.submission;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Judge0Response {
    private String stdout;
    private double time;
    private double memory;
    private String stderr;
    private String token;
    private String compile_output;
    private String message;
    private Status status;

    public String getStdout() {
        return stdout;
    }

    public void setStdout(String stdout) {
        this.stdout = stdout;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public String getStderr() {
        return stderr;
    }

    public void setStderr(String stderr) {
        this.stderr = stderr;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCompile_output() {
        return compile_output;
    }

    public void setCompile_output(String compile_output) {
        this.compile_output = compile_output;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusDescription(){
        return status.getDescription();
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Status{
    private int id;
    private String description;

//    public Status(int id, String description) {
//        this.id = id;
//        this.description = description;
//    }
    public Status(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
};

