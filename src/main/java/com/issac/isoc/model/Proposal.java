package com.issac.isoc.model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by OPSKMC on 5/4/15.
 */
@Entity
@Table(name = "proposal")
public class Proposal {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private User mentor;
    @ManyToOne
    private Student student;
    private String title;
    private String description;
    private ArrayList<QuestionResponse> questionResponses;

    public User getMentor() {
        return mentor;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<QuestionResponse> getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(ArrayList<QuestionResponse> questionResponses) {
        this.questionResponses = questionResponses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
