package com.yhy.huaman.entity;

public class A_Student extends BaseEntity{
    /**
     * 学生id
     * 用户id
     * 学生学号
     * 学生班级
     * 学生系
     * 学生院
     * 学生专业
     * 逻辑删除
     * 日志-创建人
     * 日志-创建时间
     * 日志-最后修改执行人
     * 日志-最后修改时间
     */

    private Integer student_id;
    private Integer user_id;

    private String user_name;
    private String student_xuehao;
    private String student_banji;
    private String student_xi;
    private String student_yuan;
    private String student_zhuanye;

    @Override
    public String toString() {
        return "A_Student{" +
                "student_id=" + student_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", student_xuehao='" + student_xuehao + '\'' +
                ", student_banji='" + student_banji + '\'' +
                ", student_xi='" + student_xi + '\'' +
                ", student_yuan='" + student_yuan + '\'' +
                ", student_zhuanye='" + student_zhuanye + '\'' +
                '}';
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
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

    public String getStudent_xuehao() {
        return student_xuehao;
    }

    public void setStudent_xuehao(String student_xuehao) {
        this.student_xuehao = student_xuehao;
    }

    public String getStudent_banji() {
        return student_banji;
    }

    public void setStudent_banji(String student_banji) {
        this.student_banji = student_banji;
    }

    public String getStudent_xi() {
        return student_xi;
    }

    public void setStudent_xi(String student_xi) {
        this.student_xi = student_xi;
    }

    public String getStudent_yuan() {
        return student_yuan;
    }

    public void setStudent_yuan(String student_yuan) {
        this.student_yuan = student_yuan;
    }

    public String getStudent_zhuanye() {
        return student_zhuanye;
    }

    public void setStudent_zhuanye(String student_zhuanye) {
        this.student_zhuanye = student_zhuanye;
    }
}
