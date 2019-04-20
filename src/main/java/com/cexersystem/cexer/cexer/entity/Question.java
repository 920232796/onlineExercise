package com.cexersystem.cexer.cexer.entity;


import lombok.Data;

import java.sql.Date;


@Data
public class Question {


    private String f_question_id;


    private int f_type;


    private String f_brief;

    private String f_description;


    private int  f_difficulty_level;


    private String f_answer1;


    private String f_answer2;


    private String f_answer3;


    private String f_answer4;


    private String f_language;


    private String f_course_id;


    private Date f_entry_time;


    private String f_entry_person;


    private Date f_modify_time;


    private String f_modify_person;


    private String f_orign;

    private String f_memo;

    public StringBuilder f_chapter_name;


    private StringBuilder f_knowledege;


    private Integer f_question_point;//分值
}
