package com.yhy.huaman.service;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Student_kechengclass;

import java.util.List;

/**业务层接口*/
public interface A_Student_kechengclassService {

    void setA_Student_kechengclassInfo(Integer user_id,Integer kechengclass_id);

    /**
     * 根据学生的id查询 学生加入课程班级 的信息，主要用于查询学生加入了什么课程班级
     * @param Student_id 学生的id
     * @return 学生加入课程班级 的信息
     */
    List<A_Student_kechengclass> findbyStudent_id(Integer Student_id);

    /**
     * 根据课程班级id查询 学生加入课程班级的信息，主要用于查询一个课程班级内有哪些学生
     * @param kechengclass_id 课程班级id
     * @return 学生加入课程班级 的信息
     */
    List<A_Student_kechengclass> findbyKechengclass_id(Integer kechengclass_id);

    /**
     * 清除学生入班信息
     * @return
     */
    Integer updateIsDeleteTo1(Integer student_kechengclass_id);


}
