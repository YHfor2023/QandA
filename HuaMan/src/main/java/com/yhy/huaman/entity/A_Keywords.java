package com.yhy.huaman.entity;

public class A_Keywords extends BaseEntity{


    private Integer keywords_id;
    private Integer kechengclass_id;

    private String keywords_name;
    private Integer keywords_parentid;

    @Override
    public String toString() {
        return "A_keywords{" +
                "keywords_id=" + keywords_id +
                ", kechengclass_id=" + kechengclass_id +
                ", keywords_name='" + keywords_name + '\'' +
                ", keywords_parentid=" + keywords_parentid +
                '}';
    }

    public Integer getKeywords_id() {
        return keywords_id;
    }

    public void setKeywords_id(Integer keywords_id) {
        this.keywords_id = keywords_id;
    }

    public Integer getKechengclass_id() {
        return kechengclass_id;
    }

    public void setKechengclass_id(Integer kechengclass_id) {
        this.kechengclass_id = kechengclass_id;
    }

    public String getKeywords_name() {
        return keywords_name;
    }

    public void setKeywords_name(String keywords_name) {
        this.keywords_name = keywords_name;
    }

    public Integer getKeywords_parentid() {
        return keywords_parentid;
    }

    public void setKeywords_parentid(Integer keywords_parentid) {
        this.keywords_parentid = keywords_parentid;
    }
}
