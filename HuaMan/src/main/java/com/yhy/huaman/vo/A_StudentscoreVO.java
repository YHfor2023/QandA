package com.yhy.huaman.vo;

import com.yhy.huaman.entity.BaseEntity;

import java.util.List;

public class A_StudentscoreVO extends BaseEntity {
    /**
     * 学生id
     * 用户名称
     * 学生班级
     * 学生专业
     * 学生学号
     * 总提问数
     * 总老师给分
     * 总评论数
     * 总被收藏数
     * 总被精选数
     */

    private Integer student_id;
    private String user_name;
    private String student_banji;
    private String student_zhuanye;
    private String student_xuehao;
    private Integer qa_all;
    private Integer teacher_score_all;
    private Integer answered_score_all;
    private Integer collected_score_all;
    private Integer imped_score_all;
    private List<A_QAscoreVO> aQAscoreVOS;

    @Override
    public String toString() {
        return "A_StudentscoreVO{" +
                "student_id=" + student_id +
                ", user_name='" + user_name + '\'' +
                ", student_banji='" + student_banji + '\'' +
                ", student_zhuanye='" + student_zhuanye + '\'' +
                ", student_xuehao='" + student_xuehao + '\'' +
                ", qa_all=" + qa_all +
                ", teacher_score_all=" + teacher_score_all +
                ", answered_score_all=" + answered_score_all +
                ", collected_score_all=" + collected_score_all +
                ", imped_score_all=" + imped_score_all +
                ", aQAscoreVOS=" + aQAscoreVOS +
                '}';
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStudent_banji() {
        return student_banji;
    }

    public void setStudent_banji(String student_banji) {
        this.student_banji = student_banji;
    }

    public String getStudent_zhuanye() {
        return student_zhuanye;
    }

    public void setStudent_zhuanye(String student_zhuanye) {
        this.student_zhuanye = student_zhuanye;
    }

    public String getStudent_xuehao() {
        return student_xuehao;
    }

    public void setStudent_xuehao(String student_xuehao) {
        this.student_xuehao = student_xuehao;
    }

    public Integer getQa_all() {
        return qa_all;
    }

    public void setQa_all(Integer qa_all) {
        this.qa_all = qa_all;
    }

    public Integer getTeacher_score_all() {
        return teacher_score_all;
    }

    public void setTeacher_score_all(Integer teacher_score_all) {
        this.teacher_score_all = teacher_score_all;
    }

    public Integer getAnswered_score_all() {
        return answered_score_all;
    }

    public void setAnswered_score_all(Integer answered_score_all) {
        this.answered_score_all = answered_score_all;
    }

    public Integer getCollected_score_all() {
        return collected_score_all;
    }

    public void setCollected_score_all(Integer collected_score_all) {
        this.collected_score_all = collected_score_all;
    }

    public Integer getImped_score_all() {
        return imped_score_all;
    }

    public void setImped_score_all(Integer imped_score_all) {
        this.imped_score_all = imped_score_all;
    }

    public List<A_QAscoreVO> getaQAscoreVOS() {
        return aQAscoreVOS;
    }

    public void setaQAscoreVOS(List<A_QAscoreVO> aQAscoreVOS) {
        this.aQAscoreVOS = aQAscoreVOS;
    }
}
