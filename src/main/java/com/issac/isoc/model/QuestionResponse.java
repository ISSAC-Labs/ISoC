package com.issac.isoc.model;

import javax.persistence.*;

/**
 * Created by OPSKMC on 5/4/15.
 */
@Entity
@Table(name = "question_response")
public class QuestionResponse {
    @Id
    @GeneratedValue
    private int id;
    private String question;
    private String response;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
