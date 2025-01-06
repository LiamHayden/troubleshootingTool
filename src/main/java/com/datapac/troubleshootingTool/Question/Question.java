package com.datapac.troubleshootingTool.Question;

public class Question {

    private Long id;

    private String questionDescription;

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
