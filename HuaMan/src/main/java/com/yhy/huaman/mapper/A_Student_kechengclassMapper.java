package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Student_kechengclass;

import java.util.List;

public interface A_Student_kechengclassMapper {

    /**
     * 插入 学生加入课程班级数据
     * @param a_student_kechengclass 学生加入课程班级数据
     * @return 受影响的行数(增删改都将受影响的行数作为返回值,可以根据返回值来判断是否执行成功)
     */
    Integer insert(A_Student_kechengclass a_student_kechengclass);


    /**
     * 根据学生加入课程班级的id查询数据
     * @param Student_kechengclass_id 学生加入课程班级的id
     * @return 如果找到则返回对象,反之返回null值
     */
    List<A_Student_kechengclass> find(Integer Student_kechengclass_id);

    /**
     * 根据学生的id查询数据
     * @param Student_id 学生的id
     * @return 如果找到则返回对象,反之返回null值
     */
    List<A_Student_kechengclass> findbyStudent_id(Integer Student_id);

    /**
     * 根据课程班级的id查询数据
     * @param kechengclass_id 课程班级的id
     * @return 如果找到则返回对象,反之返回null值
     */
    List<A_Student_kechengclass> findbyKechengclass_id(Integer kechengclass_id);


}
