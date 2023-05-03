package com.yhy.huaman.vo;

import java.io.Serializable;

/** Value Object类 */
public class A_MyteachclassVO implements Serializable {
    private Integer user_id;
    private Integer kecheng_id;
    private String kecheng_name;
    private String kecheng_leixing;
    private String kecheng_xuefen;
    private Integer kechengclass_id;
    private Integer teacher_id;
    private String teacher_name;
    private String kechengclass_name;
    private String kechengclass_miaoshu;
    private String kechengclass_kaishishijian;
    private String kechengclass_jieshushijian;
    private String kechengclass_image;
    private String studentnum;

    @Override
    public String toString() {
        return "A_MyteachclassVO{" +
                "user_id=" + user_id +
                ", kecheng_id=" + kecheng_id +
                ", kecheng_name='" + kecheng_name + '\'' +
                ", kecheng_leixing='" + kecheng_leixing + '\'' +
                ", kecheng_xuefen='" + kecheng_xuefen + '\'' +
                ", kechengclass_id=" + kechengclass_id +
                ", teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", kechengclass_name='" + kechengclass_name + '\'' +
                ", kechengclass_miaoshu='" + kechengclass_miaoshu + '\'' +
                ", kechengclass_kaishishijian='" + kechengclass_kaishishijian + '\'' +
                ", kechengclass_jieshushijian='" + kechengclass_jieshushijian + '\'' +
                ", kechengclass_image='" + kechengclass_image + '\'' +
                ", studentnum='" + studentnum + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getKecheng_id() {
        return kecheng_id;
    }

    public void setKecheng_id(Integer kecheng_id) {
        this.kecheng_id = kecheng_id;
    }

    public String getKecheng_name() {
        return kecheng_name;
    }

    public void setKecheng_name(String kecheng_name) {
        this.kecheng_name = kecheng_name;
    }

    public String getKecheng_leixing() {
        return kecheng_leixing;
    }

    public void setKecheng_leixing(String kecheng_leixing) {
        this.kecheng_leixing = kecheng_leixing;
    }

    public String getKecheng_xuefen() {
        return kecheng_xuefen;
    }

    public void setKecheng_xuefen(String kecheng_xuefen) {
        this.kecheng_xuefen = kecheng_xuefen;
    }

    public Integer getKechengclass_id() {
        return kechengclass_id;
    }

    public void setKechengclass_id(Integer kechengclass_id) {
        this.kechengclass_id = kechengclass_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getKechengclass_name() {
        return kechengclass_name;
    }

    public void setKechengclass_name(String kechengclass_name) {
        this.kechengclass_name = kechengclass_name;
    }

    public String getKechengclass_miaoshu() {
        return kechengclass_miaoshu;
    }

    public void setKechengclass_miaoshu(String kechengclass_miaoshu) {
        this.kechengclass_miaoshu = kechengclass_miaoshu;
    }

    public String getKechengclass_kaishishijian() {
        return kechengclass_kaishishijian;
    }

    public void setKechengclass_kaishishijian(String kechengclass_kaishishijian) {
        this.kechengclass_kaishishijian = kechengclass_kaishishijian;
    }

    public String getKechengclass_jieshushijian() {
        return kechengclass_jieshushijian;
    }

    public void setKechengclass_jieshushijian(String kechengclass_jieshushijian) {
        this.kechengclass_jieshushijian = kechengclass_jieshushijian;
    }

    public String getKechengclass_image() {
        return kechengclass_image;
    }

    public void setKechengclass_image(String kechengclass_image) {
        this.kechengclass_image = kechengclass_image;
    }

    public String getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(String studentnum) {
        this.studentnum = studentnum;
    }
}
