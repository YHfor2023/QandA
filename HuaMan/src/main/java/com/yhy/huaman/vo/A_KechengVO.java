package com.yhy.huaman.vo;

import com.yhy.huaman.entity.BaseEntity;

import java.util.List;

public class A_KechengVO extends BaseEntity {
    /**
     * 课程id
     * 课程名称
     * 课程描述
     * 课程类型
     * 课程学分
     * 逻辑删除
     * 日志-创建人
     * 日志-创建时间
     * 日志-最后修改执行人
     * 日志-最后修改时间
     */

    private Integer kecheng_id;
    private String kecheng_name;
    private String kecheng_miaoshu;
    private String kecheng_leixing;
    private String kecheng_xuefen;
    private List<A_KechengclassVO> aKechengclassVOS;

    @Override
    public String toString() {
        return "A_KechengVO{" +
                "kecheng_id=" + kecheng_id +
                ", kecheng_name='" + kecheng_name + '\'' +
                ", kecheng_miaoshu='" + kecheng_miaoshu + '\'' +
                ", kecheng_leixing='" + kecheng_leixing + '\'' +
                ", kecheng_xuefen='" + kecheng_xuefen + '\'' +
                ", aKechengclassVOS=" + aKechengclassVOS +
                '}';
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

    public String getKecheng_miaoshu() {
        return kecheng_miaoshu;
    }

    public void setKecheng_miaoshu(String kecheng_miaoshu) {
        this.kecheng_miaoshu = kecheng_miaoshu;
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

    public List<A_KechengclassVO> getaKechengclassVOS() {
        return aKechengclassVOS;
    }

    public void setaKechengclassVOS(List<A_KechengclassVO> aKechengclassVOS) {
        this.aKechengclassVOS = aKechengclassVOS;
    }
}
