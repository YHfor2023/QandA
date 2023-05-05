package com.yhy.huaman.vo;

import com.yhy.huaman.entity.BaseEntity;

import java.util.List;

public class A_QAscoreVO extends BaseEntity {
    /**
     * 问题id
     * 用户名称
     * 课程班级名称
     * 问题内容
     * 老师给分
     * 被评论
     * 被收藏
     * 被精选
     */

    private Integer qa_id;
    private String user_name;
    private String kechengclass_name;
    private String qa_content;
    private Integer teacher_score;
    private Integer answered_score;
    private Integer collected_score;
    private Integer imped_score;

    @Override
    public String toString() {
        return "A_QAscoreVO{" +
                "qa_id=" + qa_id +
                ", user_name='" + user_name + '\'' +
                ", kechengclass_name='" + kechengclass_name + '\'' +
                ", qa_content='" + qa_content + '\'' +
                ", teacher_score=" + teacher_score +
                ", answered_score=" + answered_score +
                ", collected_score=" + collected_score +
                ", imped_score=" + imped_score +
                '}';
    }

    public Integer getQa_id() {
        return qa_id;
    }

    public void setQa_id(Integer qa_id) {
        this.qa_id = qa_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getKechengclass_name() {
        return kechengclass_name;
    }

    public void setKechengclass_name(String kechengclass_name) {
        this.kechengclass_name = kechengclass_name;
    }

    public String getQa_content() {
        return qa_content;
    }

    public void setQa_content(String qa_content) {
        this.qa_content = qa_content;
    }

    public Integer getTeacher_score() {
        return teacher_score;
    }

    public void setTeacher_score(Integer teacher_score) {
        this.teacher_score = teacher_score;
    }

    public Integer getAnswered_score() {
        return answered_score;
    }

    public void setAnswered_score(Integer answered_score) {
        this.answered_score = answered_score;
    }

    public Integer getCollected_score() {
        return collected_score;
    }

    public void setCollected_score(Integer collected_score) {
        this.collected_score = collected_score;
    }

    public Integer getImped_score() {
        return imped_score;
    }

    public void setImped_score(Integer imped_score) {
        this.imped_score = imped_score;
    }
}
