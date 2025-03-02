package com.datapac.troubleshootingTool.Question;

import com.datapac.troubleshootingTool.Answer.Answer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionDescription;
    
//    private Long manualId;
    
    // ONE-TO-ONE ANSWER
    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonBackReference
    private Answer answer;

    // CPA_QUESTION RELATIOSHIP TO GO HERE

    public Question() {
    }

    public Question(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }
    
}
