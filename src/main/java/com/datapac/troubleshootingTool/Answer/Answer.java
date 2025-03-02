package com.datapac.troubleshootingTool.Answer;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.datapac.troubleshootingTool.Question.Question;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String answerDescription;

    private String answerImg;

    // ONE-TO-ONE RELATIONSHIP TO QUESTION TO GO HERE
    @OneToOne
    @JoinColumn(name = "question_id")
    @JsonManagedReference
    private Question question;

    public Answer() {
    }

    public Answer(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public String getAnswerImg() {
        return answerImg;
    }

    public void setAnswerImg(String answerImg) {
        this.answerImg = answerImg;
    }
    
}
