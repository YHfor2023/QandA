package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;

import java.util.List;

public interface A_KechengMapper {

    /**
     * 插入课程的数据
     * @param aKecheng 课程数据
     * @return 受影响的行数(增删改都将受影响的行数作为返回值,可以根据返回值来判断是否执行成功)
     */
    Integer insert(A_Kecheng aKecheng);


    /**
     * 根据id查询数据
     * @param kecheng_id 课程id
     * @return 如果找到则返回对象,反之返回null值
     */
    A_Kecheng find(Integer kecheng_id);

    /**
     * 查找所有的课程
     * @return
     */
    List<A_Kecheng> findallkecheng();


}
