package com.cexersystem.cexer.cexer.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cexersystem.cexer.cexer.dao.*;
import com.cexersystem.cexer.cexer.entity.*;
import javafx.geometry.Pos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RequestMapping("/exer")
@RestController
public class exerController {


    @Resource
    private ExerciseMapper exerciseMapper;

    @Resource
    private ExerQuestionMapper exerQuestionMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private QuestionKnowledgeMapper questionKnowledgeMapper;

    @Resource
    private QuestionChapterMapper questionChapterMapper;

    @RequestMapping("/index")
    public String index() {

        return "hello world;";
    }

    //d得到一个同学的所有练习
    @RequestMapping("/getExers")
    public ResponseResult getExerOfStudent(PostParam postParam) {

        ResponseResult<Exercise> responseResult = new ResponseResult<>();
        String f_stu_id = postParam.getF_stu_id();
        if (f_stu_id == null) {
            responseResult.setRet("fail");
            responseResult.setMsg("stu id == null ");
            return responseResult;
        }

        List<Exercise> exercises = exerciseMapper.getExerByStudent(f_stu_id,postParam.getStart(), postParam.getLimit());
        int exerNumber = exerciseMapper.getExerNumberByStudent(f_stu_id);
        responseResult.setArrays(exercises);
        responseResult.setTotal(exerNumber);
        return responseResult;

    }

    //生成练习接口  这个接口改天写 涉及到挺多的
    //先把所有选择题 填空题 判断题 编程题都拿出来 然后随机抽取
    @RequestMapping("/generateExer")
    public ResponseResult generateExer(PostParam postParam) {

        ResponseResult<Exercise> responseResult = new ResponseResult<>();
        String f_stu_id = postParam.getF_stu_id();
        if (f_stu_id == null) {
            responseResult.setRet("fail");
            responseResult.setMsg("stu 为 null");
            return responseResult;
        }
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        int f_choices = postParam.getF_choices();
        int f_blanks = postParam.getF_blanks();
        int f_truefalses = postParam.getF_truefalses();
        int f_programs = postParam.getF_programs();
        Exercise exercise = new Exercise();
        exercise.setF_choices(f_choices);
        exercise.setF_blanks(f_blanks);
        exercise.setF_truefalses(f_truefalses);
        exercise.setF_programs(f_programs);
        exercise.setF_stu_id(f_stu_id);
        exercise.setF_chapters(postParam.getF_chapter());
        exercise.setF_knowledge(postParam.getF_knowledge());
        exercise.setF_exer_id(uuid);
        exerciseMapper.insertExer(exercise);
        double score = 100 / (f_choices + f_blanks + f_truefalses + f_programs);//每道题的平均分数
        if ((f_choices + f_blanks + f_truefalses + f_programs) == 0) {
            responseResult.setRet("fail");
            responseResult.setMsg("题目数目为0");
            return responseResult;
        }
        List<Question> questions = new ArrayList<>();
        Random random = new Random();
        if (f_choices != 0) {
            //先去查一共多少数据 然后随机一个数 取连续的k道题目就行了
            int number_choice = questionMapper.getQuestionNumberByType(1);
            if (number_choice < f_choices) {
                responseResult.setRet("fail");
                responseResult.setMsg("题目数量不够,请重试");
                return responseResult;
            }
            int start = random.nextInt(number_choice - f_choices + 1) ;
            List<Question> questionsChoices = questionMapper.getQuestionByType(1, start, f_choices);
            questions.addAll(questionsChoices);
            exercise.setChoice(questionsChoices);
            System.out.println(questionsChoices);
        }

        if (f_blanks != 0) {
            int numberBlank = questionMapper.getQuestionNumberByType(2);
            if (numberBlank < f_blanks) {
                responseResult.setRet("fail");
                responseResult.setMsg("题目数量不够,请重试");
                return responseResult;
            }
            int start = random.nextInt(numberBlank - f_blanks + 1) ;
            List<Question> questionsBlank = questionMapper.getQuestionByType(2, start, f_blanks);
            questions.addAll(questionsBlank);
            exercise.setBlank(questionsBlank);
        }

        if (f_truefalses != 0) {
            int numberTrueFalse = questionMapper.getQuestionNumberByType(3);
            if (numberTrueFalse < f_truefalses) {
                responseResult.setRet("fail");
                responseResult.setMsg("题目数量不够,请重试");
                return responseResult;
            }
            int start = random.nextInt(numberTrueFalse - f_truefalses + 1);
            List<Question> questionsTrueFalse = questionMapper.getQuestionByType(3, start, f_truefalses);
            questions.addAll(questionsTrueFalse);
            exercise.setJudgement(questionsTrueFalse);
        }
        if (f_programs != 0) {
            int numberProgram = questionMapper.getQuestionNumberByType(4);
            if (numberProgram < f_programs) {
                responseResult.setRet("fail");
                responseResult.setMsg("题目数量不够,请重试");
                return responseResult;
            }
            int start = random.nextInt(numberProgram - f_programs + 1);
            List<Question> questionsProgram = questionMapper.getQuestionByType(4, start, f_programs);
            questions.addAll(questionsProgram);
            exercise.setProgram(questionsProgram);
        }

        for (Question each : questions) {
            ExerQuestion exerQuestion = new ExerQuestion();
            exerQuestion.setF_exer_id(uuid);
            exerQuestion.setF_question_id(each.getF_question_id());
            exerQuestion.setF_score(score);
            exerQuestionMapper.insertExerQuestion(exerQuestion);
        }
        exercise.setScorePerQuestion(score);
        responseResult.setObj(exercise);

//        System.out.println(exercise);
        return responseResult;

    }

    @RequestMapping("/getExerQuestions")
    public ResponseResult getExerQuestion(PostParam postParam) {

        ResponseResult<Exercise> responseResult = new ResponseResult<>();
        String f_exer_id = postParam.getF_exer_id();
        if (f_exer_id == null) {
            responseResult.setRet("fail");
            responseResult.setMsg("exer id == null");
        }
        List<ExerQuestion> exerQuestions = exerQuestionMapper.getQuestionsByExer(f_exer_id);

        Exercise exercise = new Exercise();
        exercise.setF_exer_id(f_exer_id);
        List<Question> choice = new ArrayList<>();
        List<Question> blank = new ArrayList<>();
        List<Question> judgement = new ArrayList<>();
        List<Question> program = new ArrayList<>();

        for (ExerQuestion each : exerQuestions) {
            String eachQuestionId = each.getF_question_id();
            Question question = questionMapper.getQuestionById(eachQuestionId);

            if (question == null) {
                continue;
            }
            if (question.getF_type() == 1) {
                //选择题
                choice.add(question);
            } else if (question.getF_type() == 2) {
                //填空题
                blank.add(question);
            } else if (question.getF_type() == 3) {
                //判断题
                judgement.add(question);
            } else {
                program.add(question);
            }

        }

        exercise.setChoice(choice);
        exercise.setBlank(blank);
        exercise.setJudgement(judgement);
        exercise.setProgram(program);

        responseResult.setObj(exercise);

        return responseResult;
    }

    //提交练习题目答案
    //参数 1 所有题目+ 答案  参数2 练习id exerid
    @RequestMapping(value = "submitExerAnswer", method = RequestMethod.POST)
    public ResponseResult submitExerAnswer(PostParam postParam) {

        ResponseResult<String> responseResult = new ResponseResult<>();
        String exerResult = postParam.getExerResult();//d得到练习结果 其实是个array 传过来 现在要先弄成字符串接收 再去转换
        String f_exer_id = postParam.getF_exer_id();

        Timestamp f_start_time = postParam.getF_start_time();
        Timestamp f_end_time = postParam.getF_finish_time();

        if (f_start_time == null || f_end_time == null) {
            responseResult.setRet("fail");
            responseResult.setMsg("开始时间或者结束时间提交错误，请重新提交");
            return responseResult;
        }

        Exercise exercise = exerciseMapper.getOneExerById(f_exer_id);

        //更新练习的开始跟结束时间！
        exercise.setF_start_time(f_start_time);
        exercise.setF_finish_time(f_end_time);
        try {
            exerciseMapper.updateExerTime(exercise);
        } catch ( Exception e) {
            responseResult.setRet("fail");
            responseResult.setMsg("时间信息错误，存入数据库失败");
        }


        if (f_exer_id == null || exerResult == null) {
            responseResult.setRet("fail");
            responseResult.setMsg("参数出现null值");
            return responseResult;
        }
//        System.out.println(exerResult);
        //解析传过来的string 解析成为arrayList
        try {
            JSONArray exerResultArray = JSONArray.parseArray(exerResult);
//        System.out.println(exerResultArray);
            for (Object eachResult : exerResultArray) {
                //object转 string 然后再转成jsonObject 一个object 就是一道题目 里面有id 学生答案 最后要加上exerid
                JSONObject tarResult = JSONObject.parseObject(eachResult.toString());

                ExerQuestion exerQuestion = new ExerQuestion();
                exerQuestion.setF_exer_id(f_exer_id);
                String f_answer = tarResult.getString("f_answer");
                if (f_answer == null ) {
                    f_answer = " ";
                }
                exerQuestion.setF_question_id(tarResult.getString("f_question_id"));
                exerQuestion.setF_answer(tarResult.getString("f_answer"));

                exerQuestionMapper.updateOneExerQuestion(exerQuestion);

            }
        } catch (Exception e) {
            responseResult.setRet("fail");
            responseResult.setMsg("json解析错误！请重试");
        }

        return responseResult;
    }


    //编程题提交！！


    //练习列表，每个练习后面有一个按钮 查看练习结果
    @RequestMapping("/getResult")
    public ResponseResult getResult(PostParam postParam) {

        ResponseResult<ExerQuestion> responseResult = new ResponseResult<>();
        //得到练习id 然后查出来所有问题，然后跟正确答案进行比较 赋值
        String f_exer_id = postParam.getF_exer_id();

        if (f_exer_id == null) {
            responseResult.setRet("fail");
            responseResult.setMsg("exer id 为 空");
            return responseResult;
        }

        List<ExerQuestion> exerQuestions = exerQuestionMapper.getQuestionsByExer(f_exer_id);
        if (exerQuestions == null) {
            responseResult.setRet("fail");
            responseResult.setMsg("练习中无任何问题！");
            return responseResult;
        }
        int problemNumber = exerQuestions.size();//题目数量，用来计算正确率
        int trueNumber = 0;
        double f_score = 0;
        for (ExerQuestion each : exerQuestions) {
            String f_question_id = each.getF_question_id();
            Question question = questionMapper.getQuestionById(f_question_id);
            if (question == null) {
                continue;
            }

            each.setQuestion(question);
            String trueAnswer = question.getF_answer1();
            //查找此题所对应的知识点
            List<QuestionKnowledge> questionKnowledges = questionKnowledgeMapper.getKnowledgeByQuestionId(f_question_id);
            StringBuilder knowledges = new StringBuilder();
            for (QuestionKnowledge eachKnowledge : questionKnowledges) {
                knowledges.append(eachKnowledge.getF_name());
                knowledges.append(",");
            }
            each.setF_knowledge_name(knowledges);

            //查找此题对应的章节!
            List<QuestionChapters> questionChapters = questionChapterMapper.getChaptersByQuestionId(f_question_id);
            StringBuilder chapters = new StringBuilder();
            for (QuestionChapters eachChapter : questionChapters) {
                chapters.append(eachChapter.getF_chapter_name());
                chapters.append(",");
            }
            each.setF_chapter(chapters);
            String f_answer = each.getF_answer();
            if (f_answer == null) {
                each.setF_istrue("0");
            } else if (each.getF_answer().equals(trueAnswer)) {
                //证明答案对了
                each.setF_istrue("1");
                trueNumber += 1;
                f_score += each.getF_score();

            } else {
                each.setF_istrue("0");
            }

            exerQuestionMapper.updateTrueExerQuestion(each);
        }

        double trueRatio = trueNumber / problemNumber;//计算正确率

        Exercise exercise = exerciseMapper.getOneExerById(f_exer_id);

        exercise.setTrueRatio(trueRatio);

        exercise.setF_score(f_score);

        exerciseMapper.updateExerTrueRatioAndScore(exercise);

        responseResult.setArrays(exerQuestions);
        return responseResult;

    }


}
