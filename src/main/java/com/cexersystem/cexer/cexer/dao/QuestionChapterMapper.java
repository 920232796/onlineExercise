package com.cexersystem.cexer.cexer.dao;


import com.cexersystem.cexer.cexer.entity.QuestionChapters;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionChapterMapper {

    @Select("select * from t_ques_chapter where f_question_id = #{f_question_id}")
    public List<QuestionChapters> getChaptersByQuestionId(String f_question);
}
