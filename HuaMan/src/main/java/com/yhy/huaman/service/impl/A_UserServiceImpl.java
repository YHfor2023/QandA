package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;
import com.yhy.huaman.mapper.A_UserMapper;
import com.yhy.huaman.service.A_UserService;
import com.yhy.huaman.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_UserServiceImpl implements A_UserService {
    @Autowired
    private A_UserMapper aUserMapper;
    @Override
    public void reg(A_User aUser) {
        //通过aUser参数来获取传递过来的user_account
        String user_account = aUser.getUser_account();
        //调用mapper的findByUsername(username)判断用户是否被注册过了
        A_User result = aUserMapper.findByUser_account(user_account);
//        判断结果集是否为null,不为null的话则需抛出用户名被占用的异常
        if (result!=null){
            throw new UsernameDuplicatedException("账号被占用");
        }
        /**
         * 密码加密处理作用:
         * 1.后端不再能直接看到用户的密码2.忽略了密码原来的强度,提升了数据安全性
         * 密码加密处理的实现:
         * 串+password+串->交给md5算法连续加密三次
         * 串就是数据库字段中的盐值,是一个随机字符串
         */
        String oldpassword = aUser.getUser_password();
        //1.随机生成一个盐值(大写的随机字符串)
        String salt = UUID.randomUUID().toString().toUpperCase();
        //2.将密码和盐值作为一个整体进行加密处理
        String md5Password = getMD5Password(oldpassword, salt);
        //3.将盐值保存到数据库
        aUser.setUser_salt(salt);
        //4.将加密之后的密码重新补全设置到user对象当中
        aUser.setUser_password(md5Password);

        //补全数据:is_delete设置为0
        aUser.setIs_delete(0);
        //补全数据：四个日志字段信息
        aUser.setCreated_user(aUser.getUser_name());
        aUser.setModified_user(aUser.getUser_name());
        Date date =new Date();
        aUser.setCreated_time(date);
        aUser.setModified_time(date);

        //执行注册业务功能的实现
        Integer rows = aUserMapper.insert(aUser);
        if(rows!=1){
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public A_User login(String user_account,String user_password) {
        //根据用户名称来查询用户的数据是否存在,不存在则抛出异常
        A_User result = aUserMapper.findByUser_account(user_account);
        if (result == null) {
            throw new UsernameNotFoundException("用户数据不存在");
        }

        /**
         * 检测用户的密码是否匹配:
         * 1.先获取数据库中加密之后的密码
         * 2.和用户传递过来的密码进行比较
         *  2.1先获取盐值
         *  2.2将获取的用户密码按照相同的md5算法加密
         */
        String oldPassword = result.getUser_password();
        String salt = result.getUser_salt();
        String newMd5Password = getMD5Password(user_password, salt);
        if (!newMd5Password.equals(oldPassword)) {
            throw new PasswordNotMatchException("用户密码错误");
        }

        //判断is_delete字段的值是否为1,为1表示被标记为删除
        if (result.getIs_delete() == 1) {
            throw new UsernameNotFoundException("用户数据不存在");
        }

        //方法login返回的用户数据是为了辅助其他页面做数据展示使用(只会用到uid,username,avatar)
        //所以可以new一个新的user只赋这三个变量的值,这样使层与层之间传输时数据体量变小,后台层与
        // 层之间传输时数据量越小性能越高,前端也是的,数据量小了前端响应速度就变快了

        return result;
    }
    @Override
    public void setStudentInfo(A_Student aStudent,Integer user_id){
        A_User aUser =aUserMapper.findByUid(user_id);
        A_Student aStudent1=aUserMapper.findStudentByUid(user_id);
        if(aStudent1!=null){
            aUserMapper.DelStudent(user_id);
            aStudent.setUser_name(aUser.getUser_name());
            aStudent.setStudent_id(aStudent1.getStudent_id());
            //补全数据:is_delete设置为0
            aStudent.setIs_delete(0);
            //补全数据：四个日志字段信息
            aStudent.setCreated_user(aUser.getUser_name());
            aStudent.setModified_user(aUser.getUser_name());
            Date date =new Date();
            aStudent.setCreated_time(date);
            aStudent.setModified_time(date);
            aUserMapper.updateStudent(aStudent);
        }else {
            aStudent.setUser_name(aUser.getUser_name());
            //补全数据:is_delete设置为0
            aStudent.setIs_delete(0);
            //补全数据：四个日志字段信息
            aStudent.setCreated_user(aUser.getUser_name());
            aStudent.setModified_user(aUser.getUser_name());
            Date date =new Date();
            aStudent.setCreated_time(date);
            aStudent.setModified_time(date);
            aUserMapper.insertStudent(aStudent);
        }
    }

    @Override
    public A_Student findStudentByUid(Integer user_id){
        A_Student result = aUserMapper.findStudentByUid(user_id);
        if (result == null) {
            throw new UsernameNotFoundException("用户数据不存在");
        }
        return result;
    }
    @Override
    public A_Teacher findTeacherByTeacher_id(Integer teacher_id){
        A_Teacher result = aUserMapper.findTeacherByTeacher_id(teacher_id);
        if (result == null) {
            throw new UsernameNotFoundException("用户数据不存在");
        }
        return result;
    }

    @Override
    public void setTeacherInfo(A_Teacher aTeacher, Integer user_id){
        A_User aUser =aUserMapper.findByUid(user_id);
        if(aUserMapper.findTeacherByUid(user_id)!=null){
            aUserMapper.DelTeacher(user_id);
        }
        aTeacher.setUser_name(aUser.getUser_name());
        //补全数据:is_delete设置为0
        aTeacher.setIs_delete(0);
        //补全数据：四个日志字段信息
        aTeacher.setCreated_user(aUser.getUser_name());
        aTeacher.setModified_user(aUser.getUser_name());
        Date date =new Date();
        aTeacher.setCreated_time(date);
        aTeacher.setModified_time(date);
        aUserMapper.insertTeacher(aTeacher);
    }

    @Override
    public A_Teacher findTeacherByUid(Integer user_id){
        A_Teacher result = aUserMapper.findTeacherByUid(user_id);
        if (result == null) {
            throw new UsernameNotFoundException("用户数据不存在");
        }
        return result;
    }

    @Override
    public A_User find(Integer user_id){
        A_User result = aUserMapper.findByUid(user_id);
        return result;
    }




    private String getMD5Password(String password,String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

}
