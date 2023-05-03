package com.yhy.huaman.entity;

public class A_Student_kechengclass extends BaseEntity{
    /**
     * 学生—课程班级关系id
     * 学生id
     * 课程班级id
     * 学生在课程班级中的总分
     * 逻辑删除
     * 日志-创建人
     * 日志-创建时间
     * 日志-最后修改执行人
     * 日志-最后修改时间
     */

    private Integer student_kechengclass_id;
    private Integer student_id;
    private Integer kechengclass_id;
    private String student_kechengclass_fenshu;

    @Override
    public String toString() {
        return "A_Student_kechengclass{" +
                "student_kechengclass_id=" + student_kechengclass_id +
                ", student_id=" + student_id +
                ", kechengclass_id=" + kechengclass_id +
                ", student_kechengclass_fenshu='" + student_kechengclass_fenshu + '\'' +
                '}';
    }

    public Integer getStudent_kechengclass_id() {
        return student_kechengclass_id;
    }

    public void setStudent_kechengclass_id(Integer student_kechengclass_id) {
        this.student_kechengclass_id = student_kechengclass_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getKechengclass_id() {
        return kechengclass_id;
    }

    public void setKechengclass_id(Integer kechengclass_id) {
        this.kechengclass_id = kechengclass_id;
    }

    public String getStudent_kechengclass_fenshu() {
        return student_kechengclass_fenshu;
    }

    public void setStudent_kechengclass_fenshu(String student_kechengclass_fenshu) {
        this.student_kechengclass_fenshu = student_kechengclass_fenshu;
    }
}
