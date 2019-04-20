package com.cexersystem.cexer.cexer.dao;

import com.cexersystem.cexer.cexer.entity.ExerQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ExerQuestionMapper {

    @Select("select * from t_exer_question where f_exer_id = #{f_exer_id}")
    List<ExerQuestion> getQuestionsByExer(String f_exer_id);

    @Update("update t_exer_question set f_answer = #{f_answer} where f_exer_id = #{f_exer_id} and f_question_id = #{f_question_id}")
    void updateOneExerQuestion(ExerQuestion exerQuestion);


    @Insert("insert into t_exer_question (f_exer_id, f_question_id, f_score) values " +
            "(#{f_exer_id}, #{f_question_id}, #{f_score})")
    void insertExerQuestion(ExerQuestion exerQuestion);

    @Update("update t_exer_question set f_istrue = #{f_istrue} where f_exer_id = #{f_exer_id} and f_question_id = #{f_question_id}")
    void updateTrueExerQuestion(ExerQuestion exerQuestion);

}
