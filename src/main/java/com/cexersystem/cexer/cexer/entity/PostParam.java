package com.cexersystem.cexer.cexer.entity;

import java.sql.Timestamp;

public class PostParam {

    private int start;
    private int limit = 5;

    private String f_stu_id;

    private String f_exer_id;

    private String exerResult;

    private int f_choices;

    private int f_blanks;

    private int f_truefalses;

    private int f_programs;


    private String f_knowledge;

    private Timestamp f_start_time;

    private Timestamp f_finish_time;

    public Timestamp getF_start_time() {
        return f_start_time;
    }

    public void setF_start_time(Timestamp f_start_time) {
        this.f_start_time = f_start_time;
    }

    public Timestamp getF_finish_time() {
        return f_finish_time;
    }

    public void setF_finish_time(Timestamp f_finish_time) {
        this.f_finish_time = f_finish_time;
    }

    public String getF_knowledge() {
        return f_knowledge;
    }

    public void setF_knowledge(String f_knowledge) {
        this.f_knowledge = f_knowledge;
    }

    public String getF_chapter() {
        return f_chapter;
    }

    public void setF_chapter(String f_chapter) {
        this.f_chapter = f_chapter;
    }

    private String f_chapter;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getF_stu_id() {
        return f_stu_id;
    }

    public void setF_stu_id(String f_stu_id) {
        this.f_stu_id = f_stu_id;
    }

    public String getF_exer_id() {
        return f_exer_id;
    }

    public void setF_exer_id(String f_exer_id) {
        this.f_exer_id = f_exer_id;
    }

    public String getExerResult() {
        return exerResult;
    }

    public void setExerResult(String exerResult) {
        this.exerResult = exerResult;
    }

    public int getF_choices() {
        return f_choices;
    }

    public void setF_choices(int f_choices) {
        this.f_choices = f_choices;
    }

    public int getF_blanks() {
        return f_blanks;
    }

    public void setF_blanks(int f_blanks) {
        this.f_blanks = f_blanks;
    }

    public int getF_truefalses() {
        return f_truefalses;
    }

    public void setF_truefalses(int f_truefalses) {
        this.f_truefalses = f_truefalses;
    }

    public int getF_programs() {
        return f_programs;
    }

    public void setF_programs(int f_programs) {
        this.f_programs = f_programs;
    }
}
