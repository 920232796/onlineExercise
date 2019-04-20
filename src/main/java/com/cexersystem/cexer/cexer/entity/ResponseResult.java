package com.cexersystem.cexer.cexer.entity;

import lombok.Data;

import java.util.List;


@Data
public class ResponseResult<T> {
    String ret = "success";
    String msg = "";
    String content_type = "";//no permission, rank info,activity info
    T obj;
    List<T> arrays;
    float maxScore;//最高分
    float minScore;//最低分
    float averageScore;//平均分

    int total;//返回的题目数目
}
