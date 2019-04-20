package com.cexersystem.cexer.cexer.entity;

import java.sql.Timestamp;
import java.util.List;

public class Exercise {

    private String f_exer_id;

    private String f_knowledge;

    private Integer f_choices;

    private Integer f_blanks;

    private Integer f_truefalses;

    private Integer f_programs;

    private Timestamp f_start_time;

    private String f_stu_id;

    private Timestamp f_finish_time;

    private String memo;


    private List<Question> choice;

    private List<Question> blank;

    private List<Question> judgement;

    private List<Question> program;

    private double trueRatio;

    private double f_score;

    private double scorePerQuestion;

    public double getScorePerQuestion() {
        return scorePerQuestion;
    }

    public void setScorePerQuestion(double scorePerQuestion) {
        this.scorePerQuestion = scorePerQuestion;
    }

    public double getF_score() {
        return f_score;
    }

    public void setF_score(double f_score) {
        this.f_score = f_score;
    }

    public double getTrueRatio() {
        return trueRatio;
    }

    public void setTrueRatio(double trueRatio) {
        this.trueRatio = trueRatio;
    }

    public List<Question> getChoice() {
        return choice;
    }

    public void setChoice(List<Question> choice) {
        this.choice = choice;
    }

    public List<Question> getBlank() {
        return blank;
    }

    public void setBlank(List<Question> blank) {
        this.blank = blank;
    }

    public List<Question> getJudgement() {
        return judgement;
    }

    public void setJudgement(List<Question> judgement) {
        this.judgement = judgement;
    }

    public List<Question> getProgram() {
        return program;
    }

    public void setProgram(List<Question> program) {
        this.program = program;
    }



    public String getF_exer_id() {
        return f_exer_id;
    }

    public void setF_exer_id(String f_exer_id) {
        this.f_exer_id = f_exer_id;
    }

    public String f_course_id;

    public String f_chapters;

    public String getF_course_id() {
        return f_course_id;
    }

    public void setF_course_id(String f_course_id) {
        this.f_course_id = f_course_id;
    }

    public String getF_chapters() {
        return f_chapters;
    }

    public void setF_chapters(String f_chapters) {
        this.f_chapters = f_chapters;
    }

    public String getF_knowledge() {
        return f_knowledge;
    }

    public void setF_knowledge(String f_knowledge) {
        this.f_knowledge = f_knowledge;
    }

    public Integer getF_choices() {
        return f_choices;
    }

    public void setF_choices(Integer f_choices) {
        this.f_choices = f_choices;
    }

    public Integer getF_blanks() {
        return f_blanks;
    }

    public void setF_blanks(Integer f_blanks) {
        this.f_blanks = f_blanks;
    }

    public Integer getF_truefalses() {
        return f_truefalses;
    }

    public void setF_truefalses(Integer f_truefalses) {
        this.f_truefalses = f_truefalses;
    }

    public Integer getF_programs() {
        return f_programs;
    }

    public void setF_programs(Integer f_programs) {
        this.f_programs = f_programs;
    }

    public Timestamp getF_start_time() {
        return f_start_time;
    }

    public void setF_start_time(Timestamp f_start_time) {
        this.f_start_time = f_start_time;
    }

    public String getF_stu_id() {
        return f_stu_id;
    }

    public void setF_stu_id(String f_stu_id) {
        this.f_stu_id = f_stu_id;
    }

    public Timestamp getF_finish_time() {
        return f_finish_time;
    }

    public void setF_finish_time(Timestamp f_finish_time) {
        this.f_finish_time = f_finish_time;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }




}
