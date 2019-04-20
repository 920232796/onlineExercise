package com.cexersystem.cexer.cexer.entity;


public class ExerQuestion {

    private Integer f_id;

    private String f_exer_id;

    private String f_question_id;

    private String f_answer;

    private double f_score;

    private String f_memo;

    private String f_istrue;

    private StringBuilder  f_knowledge_name;

    private StringBuilder f_chapter;

    Question question;

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getF_exer_id() {
        return f_exer_id;
    }

    public void setF_exer_id(String f_exer_id) {
        this.f_exer_id = f_exer_id;
    }

    public String getF_question_id() {
        return f_question_id;
    }

    public void setF_question_id(String f_question_id) {
        this.f_question_id = f_question_id;
    }

    public String getF_answer() {
        return f_answer;
    }

    public void setF_answer(String f_answer) {
        this.f_answer = f_answer;
    }

    public double getF_score() {
        return f_score;
    }

    public void setF_score(double f_score) {
        this.f_score = f_score;
    }

    public String getF_memo() {
        return f_memo;
    }

    public void setF_memo(String f_memo) {
        this.f_memo = f_memo;
    }

    public String getF_istrue() {
        return f_istrue;
    }

    public void setF_istrue(String f_istrue) {
        this.f_istrue = f_istrue;
    }

    public StringBuilder getF_knowledge_name() {
        return f_knowledge_name;
    }

    public void setF_knowledge_name(StringBuilder f_knowledge_name) {
        this.f_knowledge_name = f_knowledge_name;
    }

    public StringBuilder getF_chapter() {
        return f_chapter;
    }

    public void setF_chapter(StringBuilder f_chapter) {
        this.f_chapter = f_chapter;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
