package com.codaemons.be.models.submission;

public class Judge0Request {
    private String source_code;
    private int language_id;
    private String stdin;
    private String expected_output;

    public Judge0Request() {
    }

    public Judge0Request(String source_code, int language_id, String stdin, String expected_output) {
        this.source_code = source_code;
        this.language_id = language_id;
        this.stdin = stdin;
        this.expected_output = expected_output;
    }


    public String getExpected_output() {
        return expected_output;
    }

    public void setExpected_output(String expected_output) {
        this.expected_output = expected_output;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getStdin() {
        return stdin;
    }

    public void setStdin(String stdin) {
        this.stdin = stdin;
    }
}
