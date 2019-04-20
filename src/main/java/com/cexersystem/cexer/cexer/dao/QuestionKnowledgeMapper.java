package com.cexersystem.cexer.cexer.dao;


import com.cexersystem.cexer.cexer.entity.QuestionKnowledge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionKnowledgeMapper {

    @Select("select * from t_ques_knowledge where f_question_id = #{f_question_id}")
    public List<QuestionKnowledge> getKnowledgeByQuestionId(String f_question);


}
