package com.yhy.huaman.controller;

import com.yhy.huaman.controller.ex.*;
import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;
import com.yhy.huaman.service.A_UserService;
import com.yhy.huaman.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.smartcardio.ATR;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController //其作用等同于@Controller+@ResponseBody
//@Controller
@RequestMapping("qa")
public class A_UserController extends BaseController{

    @Autowired
    private A_UserService aUserService;

    @RequestMapping("login")
    public JsonResult<A_User> login(String user_account, String user_password, HttpSession session) {
        A_User aUser = aUserService.login(user_account,user_password);
        //向session对象中完成数据的绑定(这个session是全局的,项目的任何位置都可以访问)
        session.setAttribute("user_id",aUser.getUser_id());
        session.setAttribute("user_name",aUser.getUser_name());
        return new JsonResult<A_User>(OK,aUser);
    }
    @RequestMapping("reg")
    public JsonResult<Void> reg(A_User aUser) {
        JsonResult<Void> jsonResult =new JsonResult<>();
        aUserService.reg(aUser);
        jsonResult.setMessage("注册成功");
        jsonResult.setState(OK);
        return jsonResult;
    }
    @RequestMapping("findUserbySession")
    public JsonResult<A_User> findUserbySession(HttpSession session) {
        Integer user_id = getUser_idFromSession(session);
        A_User aUser = aUserService.find(user_id);
        return new JsonResult<A_User>(OK,aUser);
    }

    @RequestMapping("findstudent")
    public JsonResult<A_Student> findStudent(Integer user_id){
        A_Student aStudent = aUserService.findStudentByUid(user_id);
        return new JsonResult<A_Student>(OK,aStudent);
    }
    @RequestMapping("setStudentInfo")
    public JsonResult<Void> setStudentInfo(A_Student aStudent,Integer user_id){
        aUserService.setStudentInfo(aStudent,user_id);
        return new JsonResult(OK,"信息录入成功");
    }

    @RequestMapping("findteacher")
    public JsonResult<A_Teacher> findTeacher(Integer user_id){
        A_Teacher aTeacher= aUserService.findTeacherByUid(user_id);
        return new JsonResult<A_Teacher>(OK,aTeacher);
    }
    @RequestMapping("setteacherInfo")
    public JsonResult<Void> setStudentInfo(A_Teacher aTeacher,Integer user_id){
        aUserService.setTeacherInfo(aTeacher,user_id);
        return new JsonResult(OK,"信息录入成功");
    }


//    请求处理方法的参数列表设置为非pojo类型:
//    SpringBoot会直接将请求的参数名和方法的参数名直接进行比较,如果名称相同则自动完成值的依赖注入
//    把首次登录所获取的用户数据转移到session对象:
//    服务器本身自动创建有session对象,已经是一个全局的session对象,所以我们需要想办法获取session对象:如果直接将HttpSession类型的对象作为请求处理方法的参数,这时springboot会自动将全局的session对象注入到请求处理方法的session形参上:





}

