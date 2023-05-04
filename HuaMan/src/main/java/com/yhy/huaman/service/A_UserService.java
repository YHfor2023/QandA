package com.yhy.huaman.service;

import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;

import java.util.List;

/**用户模块业务层接口*/
public interface A_UserService {
    /**
     * 用户注册方法
     * @param aUser 用户的数据对象
     */
    void reg(A_User aUser);
    /**
     * 用户登录功能
     * @param user_account 用户名
     * @param user_password 用户密码
     * @return 当前匹配的用户数据,如果没有则返回null
     */
    A_User login(String user_account,String user_password);

    /**
     * 设置学生信息
     * @param aStudent 学生信息
     */
    void setStudentInfo(A_Student aStudent,Integer user_id);

    /**
     * 设置老师信息
     * @param aTeacher 老师信息
     */
    void setTeacherInfo(A_Teacher aTeacher,Integer user_id);

    /**
     * 依据用户id查询学生信息
     * @param user_id 学生的用户id
     * @return 学生信息表
     */
    A_Student findStudentByUid(Integer user_id);

    /**
     * 依据用户id查询老师信息
     * @param user_id 老师的用户id
     * @return 老师信息表
     */
    A_Teacher findTeacherByUid(Integer user_id);
    A_Teacher findTeacherByTeacher_id(Integer teacher_id);
    A_Student findStudentByStudent_id(Integer student_id);
    /**
     * 批量化 依据班级号寻找学生
     * @param student_banji
     * @return
     */
    List<A_Student> findStudentBystudent_banji(String student_banji);
    List<String> findBanji();
    A_User find(Integer user_id);
    /**
     * changePassword方法需要什么参数:
     * 要先看底层持久层需要什么参数:uid,password,modifiedUser,modifiedTime
     * 1.修改人其实就是username,已经保存到session当中,通过控制层传递过来就行了
     * 2.在更新数据之前需要先根据uid查这个数据存不存在,uid也可以通过控制层传递
     * 3.新密码需要有
     * 4.修改时间不需要在参数列表,直接在方法内部new Date()就可以了
     * 5.旧密码
     * */


}
