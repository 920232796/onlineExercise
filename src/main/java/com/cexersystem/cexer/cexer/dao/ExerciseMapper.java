package com.cexersystem.cexer.cexer.dao;


import com.cexersystem.cexer.cexer.entity.Exercise;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExerciseMapper {

    @Select("select * from t_exercise where f_stu_id = #{f_stu_id} limit #{start}, #{limit}")
    List<Exercise> getExerByStudent(@Param("f_stu_id") String f_stu_id, @Param("start") int start, @Param("limit") int limit);

    @Select("select count(*) from t_exercise where f_stu_id = #{f_stu_id}")
    int getExerNumberByStudent(String f_stu_id);

    @Insert("insert into t_exercise (f_exer_id, f_choices, f_blanks, f_truefalses, f_programs, f_stu_id) " +
            "values(#{f_exer_id}, #{f_choices}, #{f_blanks}, #{f_truefalses}, #{f_programs}, #{f_stu_id})")
    void insertExer(Exercise exercise);

    @Select("select * from t_exercise where f_exer_id = #{f_exer_id}")
    Exercise getOneExerById(String f_exer_id);

    @Update("update t_exercise set trueRatio = #{trueRatio}, f_score = #{f_score} where f_exer_id = #{f_exer_id}")
    void updateExerTrueRatioAndScore(Exercise exercise);

    @Update("update t_exercise set f_start_time = #{f_start_time}, f_finish_time = #{f_finish_time} where f_exer_id = #{f_exer_id}")
    void updateExerTime(Exercise exercise);
}
