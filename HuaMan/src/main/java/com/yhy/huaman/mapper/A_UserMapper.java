package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface A_UserMapper {

    /**
     * 插入用户的数据
     * @param aUser 用户的数据
     * @return 受影响的行数(增删改都将受影响的行数作为返回值,可以根据返回值来判断是否执行成功)
     */
    Integer insert(A_User aUser);

    /**
     * 根据用户名来查询用户的数据
     * @param user_account 用户名
     * @return 如果找到对应的用户则返回这个用户的数据,如果没有找到则返回null
     */
    A_User findByUser_account(String user_account);

    /**
     * 根据用户的id查询用户的数据
     * @param user_id 用户的id
     * @return 如果找到则返回对象,反之返回null值
     */
    A_User findByUid(Integer user_id);

    /**
     * 根据用户的id查询学生用户的数据
     * @param user_id 用户的id
     * @return 如果找到则返回对象,反之返回null值
     */
    A_Student findStudentByUid(Integer user_id);

    /**
     * 根据用户的id查询老师用户的数据
     * @param user_id 用户的id
     * @return 如果找到则返回对象,反之返回null值
     */
    A_Teacher findTeacherByUid(Integer user_id);

    /**
     * 根据teacher_id查询老师用户的数据
     * @param teacher_id 用户的id
     * @return 如果找到则返回对象,反之返回null值
     */
    A_Teacher findTeacherByTeacher_id(Integer teacher_id);
    A_Student findStudentByStudent_id(Integer student_id);

    /**
     * 批量化 依据班级号寻找学生
     * @param student_banji
     * @return
     */
    List<A_Student> findStudentBystudent_banji(String student_banji);
    List<String> findBanji();

    /**
     * 插入学生的数据
     * @param aStudent 学生的数据
     * @return 受影响的行数(增删改都将受影响的行数作为返回值,可以根据返回值来判断是否执行成功)
     */
    Integer insertStudent(A_Student aStudent);
    /**
     * 更新学生的数据
     * @param aStudent 学生的数据
     * @return 受影响的行数(增删改都将受影响的行数作为返回值,可以根据返回值来判断是否执行成功)
     */
    Integer updateStudent(A_Student aStudent);

    /**
     * 根据user_id删除学生，便于修改信息
     * @param user_id
     * @return
     */
    Integer DelStudent(Integer user_id);

    /**
     * 插入老师的数据
     * @param aTeacher 老师的数据
     * @return 受影响的行数(增删改都将受影响的行数作为返回值,可以根据返回值来判断是否执行成功)
     */
    Integer insertTeacher(A_Teacher aTeacher);

    /**
     * 根据user_id删除老师，便于修改信息
     * @param user_id
     * @return
     */
    Integer DelTeacher(Integer user_id);




}
