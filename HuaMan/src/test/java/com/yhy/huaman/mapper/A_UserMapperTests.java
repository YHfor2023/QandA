package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@SpringBootTest表示当前的类是一个测试类,不会随同项目一块打包
@SpringBootTest
/**
 * 1.@RunWith表示启动这个单元测试类,否则这个单元测试类是不能运行的,需要传递
 * 一个参数,该参数必须是SpringRunner.class即SpringRunner的实例类型
 * 2.敲完@RunWith(SpringRunner.class)后鼠标分别放在SpringRunner和@RunWith上按alt+enter分别导入包
 * 3.单元测试类中出现的方法必须是单元测试方法
 * 4.单元测试方法的特点:必须被@Test注解修饰;返回值类型必须是void;方法的参数列表不指定任何类型;方法的访问修饰符必须是public
 */
@RunWith(SpringRunner.class)
public class A_UserMapperTests {
    @Autowired
    private A_UserMapper a_userMapper;
    @Test
    public void insert() {
        A_User aUser = new A_User();
        aUser.setUser_name("刘廷奇");
        aUser.setUser_password("123");
        aUser.setUser_account("19801299132");
        aUser.setCreated_time(new Date());
        aUser.setCreated_user("刘廷奇");
        aUser.setModified_time(new Date());
        aUser.setModified_user("刘廷奇");

        Integer rows = a_userMapper.insert(aUser);
        System.out.println(rows);
    }
    @Test
    public void findByUseraccount(){
        A_User aUser = a_userMapper.findByUser_account("19801299132");
        System.out.println(aUser);
    }

    @Test
    public void findByUid(){
        System.out.println(a_userMapper.findByUid(1));
    }

    @Test
    public void findStudentByUid(){
        System.out.println(a_userMapper.findStudentByUid(1));
    }

    @Test
    public void insertStudent(){
        A_Student aStudent =new A_Student();
        aStudent.setUser_id(1);
        aStudent.setStudent_zhuanye("计算机科学与技术专业");
        a_userMapper.insertStudent(aStudent);
    }

    @Test
    public void insertTeacher(){
        A_Teacher aTeacher =new  A_Teacher();
        aTeacher.setUser_id(1);
        aTeacher.setTeacher_gonghao("1001");
        a_userMapper.insertTeacher(aTeacher);
    }




}
