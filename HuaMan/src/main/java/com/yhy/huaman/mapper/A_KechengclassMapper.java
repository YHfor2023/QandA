package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Kechengclass;

import java.util.List;

public interface A_KechengclassMapper {

    /**
     * 插入课程班级的数据
     * @param aKechengclass 课程班级数据
     * @return 受影响的行数(增删改都将受影响的行数作为返回值,可以根据返回值来判断是否执行成功)
     */
    Integer insert(A_Kechengclass aKechengclass);


    /**
     * 根据id查询数据
     * @param Kechengclass_id 课程班级id
     * @return 如果找到则返回对象,反之返回null值
     */
    A_Kechengclass find(Integer Kechengclass_id);

    List<A_Kechengclass> findbyteacher_id(Integer teacher_id);

    List<A_Kechengclass> findbykecheng_id(Integer kecheng_id);


}
