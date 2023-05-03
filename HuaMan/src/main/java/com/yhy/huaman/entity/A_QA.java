package com.yhy.huaman.entity;

//
public class A_QA extends BaseEntity {

    private Integer qa_id;    //问答id
    private Integer user_id;    //发表用户id
    private Integer student_id;    //学生id
    private Integer teacher_id;    //老师id
    private Integer kechengclass_id;    //课程班级id
    private String kechengclass_name;    //课程班级名称
    private String user_name;    //用户姓名
    private String user_avartar;    //用户头像
    private String user_class;    //用户班级
    private String qa_content;    //问答内容
    private String qa_images;    //问答图片
    private Integer qa_is_top;    //是否为最初问答
    private Integer qa_upper_id;    //上一级问答id
    private Integer qa_zan;    //赞数量
    private Integer qa_teacher_score;    //老师打分
    private Integer qa_other_score;    //其他分数

    public Integer getQa_id() {
        return qa_id;
    }

    public void setQa_id(Integer qa_id) {
        this.qa_id = qa_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getKechengclass_id() {
        return kechengclass_id;
    }

    public void setKechengclass_id(Integer kechengclass_id) {
        this.kechengclass_id = kechengclass_id;
    }

    public String getKechengclass_name() {
        return kechengclass_name;
    }

    public void setKechengclass_name(String kechengclass_name) {
        this.kechengclass_name = kechengclass_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avartar() {
        return user_avartar;
    }

    public void setUser_avartar(String user_avartar) {
        this.user_avartar = user_avartar;
    }

    public String getUser_class() {
        return user_class;
    }

    public void setUser_class(String user_class) {
        this.user_class = user_class;
    }

    public String getQa_content() {
        return qa_content;
    }

    public void setQa_content(String qa_content) {
        this.qa_content = qa_content;
    }

    public String getQa_images() {
        return qa_images;
    }

    public void setQa_images(String qa_images) {
        this.qa_images = qa_images;
    }

    public Integer getQa_is_top() {
        return qa_is_top;
    }

    public void setQa_is_top(Integer qa_is_top) {
        this.qa_is_top = qa_is_top;
    }

    public Integer getQa_upper_id() {
        return qa_upper_id;
    }

    public void setQa_upper_id(Integer qa_upper_id) {
        this.qa_upper_id = qa_upper_id;
    }

    public Integer getQa_zan() {
        return qa_zan;
    }

    public void setQa_zan(Integer qa_zan) {
        this.qa_zan = qa_zan;
    }

    public Integer getQa_teacher_score() {
        return qa_teacher_score;
    }

    public void setQa_teacher_score(Integer qa_teacher_score) {
        this.qa_teacher_score = qa_teacher_score;
    }

    public Integer getQa_other_score() {
        return qa_other_score;
    }

    public void setQa_other_score(Integer qa_other_score) {
        this.qa_other_score = qa_other_score;
    }

    @Override
    public String toString() {
        return "A_Qa{" +
                "qa_id=" + qa_id +
                ", user_id=" + user_id +
                ", student_id=" + student_id +
                ", teacher_id=" + teacher_id +
                ", kechengclass_id=" + kechengclass_id +
                ", kechengclass_name='" + kechengclass_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_avartar='" + user_avartar + '\'' +
                ", user_class='" + user_class + '\'' +
                ", qa_content='" + qa_content + '\'' +
                ", qa_images='" + qa_images + '\'' +
                ", qa_is_top=" + qa_is_top +
                ", qa_upper_id=" + qa_upper_id +
                ", qa_zan=" + qa_zan +
                ", qa_teacher_score=" + qa_teacher_score +
                ", qa_other_score=" + qa_other_score +
                '}';
    }
}
