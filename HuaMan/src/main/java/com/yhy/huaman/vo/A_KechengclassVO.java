package com.yhy.huaman.vo;

import com.yhy.huaman.entity.BaseEntity;

import java.util.List;

public class A_KechengclassVO extends BaseEntity {
    /**
     * 课程班级id
     * 课程id
     * 老师id
     * 课程班级名称
     * 课程班级描述
     * 课程班级开班时间
     * 课程班级毕班时间
     * 课程班级图片
     * 逻辑删除
     * 日志-创建人
     * 日志-创建时间
     * 日志-最后修改执行人
     * 日志-最后修改时间
     */

    private Integer kechengclass_id;
    private Integer kecheng_id;
    private String kecheng_name;
    private Integer teacher_id;
    private String teacher_name;
    private String kechengclass_name;
    private String kechengclass_miaoshu;
    private String kechengclass_kaishishijian;
    private String kechengclass_jieshushijian;
    private String kechengclass_image;
    private List<A_QAvo> aQAvos;

    @Override
    public String toString() {
        return "A_KechengclassVO{" +
                "kechengclass_id=" + kechengclass_id +
                ", kecheng_id=" + kecheng_id +
                ", kecheng_name='" + kecheng_name + '\'' +
                ", teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", kechengclass_name='" + kechengclass_name + '\'' +
                ", kechengclass_miaoshu='" + kechengclass_miaoshu + '\'' +
                ", kechengclass_kaishishijian='" + kechengclass_kaishishijian + '\'' +
                ", kechengclass_jieshushijian='" + kechengclass_jieshushijian + '\'' +
                ", kechengclass_image='" + kechengclass_image + '\'' +
                ", aQAvos=" + aQAvos +
                '}';
    }

    public Integer getKechengclass_id() {
        return kechengclass_id;
    }

    public void setKechengclass_id(Integer kechengclass_id) {
        this.kechengclass_id = kechengclass_id;
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

    public List<A_QAvo> getaQAvos() {
        return aQAvos;
    }

    public void setaQAvos(List<A_QAvo> aQAvos) {
        this.aQAvos = aQAvos;
    }
}
