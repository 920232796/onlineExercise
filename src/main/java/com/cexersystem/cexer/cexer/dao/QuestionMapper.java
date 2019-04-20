package com.cexersystem.cexer.cexer.dao;

import com.cexersystem.cexer.cexer.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("select * from t_question where f_question_id = #{f_question_id}")
    Question getQuestionById(String f_question_id);

    @Select("select count(*) from t_question where f_type = #{f_type}")
    int getQuestionNumberByType(int f_type);

    @Select("select * from t_question where f_type = #{f_type} limit #{start}, #{limit} ")
    List<Question> getQuestionByType(@Param("f_type") int f_type, @Param("start") int start, @Param("limit") int limit);
}
