package com.yhy.huaman.entity;

public class A_Teacher extends BaseEntity{
    /***
     *老师id
     * 用户id
     * 老师工号
     * 老师职称
     */
    private Integer teacher_id;
    private Integer user_id;

    private String user_name;
    private String teacher_gonghao;
    private String teacher_zhicheng;

    @Override
    public String toString() {
        return "A_Teacher{" +
                "teacher_id=" + teacher_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", teacher_gonghao='" + teacher_gonghao + '\'' +
                ", teacher_zhicheng='" + teacher_zhicheng + '\'' +
                '}';
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTeacher_gonghao() {
        return teacher_gonghao;
    }

    public void setTeacher_gonghao(String teacher_gonghao) {
        this.teacher_gonghao = teacher_gonghao;
    }

    public String getTeacher_zhicheng() {
        return teacher_zhicheng;
    }

    public void setTeacher_zhicheng(String teacher_zhicheng) {
        this.teacher_zhicheng = teacher_zhicheng;
    }
}
