package com.yhy.huaman.entity;

public class A_Collect extends BaseEntity{
    /**
     * collect_id	int	收藏id
     * user_id	int	用户id
     * qa_id	int	问答id
     */

    private Integer collect_id;
    private Integer user_id;

    private Integer qa_id;

    public Integer getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(Integer collect_id) {
        this.collect_id = collect_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getQa_id() {
        return qa_id;
    }

    public void setQa_id(Integer qa_id) {
        this.qa_id = qa_id;
    }

    @Override
    public String toString() {
        return "A_Collect{" +
                "collect_id=" + collect_id +
                ", user_id=" + user_id +
                ", qa_id='" + qa_id + '\'' +
                '}';
    }
}
