package com.cexersystem.cexer.cexer.entity;


import lombok.Data;

@Data
public class KnowledgePoint {

    private String f_knowledge_id;

    private String f_name;

    private String f_course_id;

    private String f_require_level;

    private Integer f_importance;

    private String f_memo;
}
