package com.yhy.huaman.service;

import com.yhy.huaman.entity.*;
import com.yhy.huaman.util.JsonResult;
import com.yhy.huaman.vo.A_MyteachclassVO;
import com.yhy.huaman.vo.A_MyteachclassVO;
import com.yhy.huaman.vo.A_QAvo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class A_ClassServiceTests {
    @Autowired
    private A_KechengService aKechengService;
    @Autowired
    private A_KechengclassService aKechengclassService;
    @Autowired
    private A_Student_kechengclassService aStudentKechengclassService;
    @Autowired
    private A_UserService aUserService;
    @Autowired
    private A_QAService aQaService;
    @Autowired
    private A_CollectService aCollectService;

    Integer user_id=1;
    List<A_MyteachclassVO> teachclasses=new ArrayList<>();







    @Test
    public void setQA(){
        A_QA aQa =new A_QA();
        aQa.setUser_id(1);
        aQa.setQa_content("222");
        aQa.setKechengclass_id(5);
        aQa.setQa_images("url");


        A_User aUser=aUserService.find( aQa.getUser_id());
        if(aUser.getUser_type()==2){
            A_Student aStudent = aUserService.findStudentByUid( aQa.getUser_id());
            aQa.setStudent_id(aStudent.getStudent_id());
            aQa.setUser_class(aStudent.getStudent_banji());
            aQa.setTeacher_id(0);
        }else {
            A_Teacher aTeacher = aUserService.findTeacherByUid(aQa.getUser_id());
            aQa.setTeacher_id(aTeacher.getTeacher_id());
            aQa.setUser_class(null);
            aQa.setStudent_id(0);
        }
        A_Kechengclass aKechengclass =aKechengclassService.find(aQa.getKechengclass_id());
        aQa.setKechengclass_name(aKechengclass.getKechengclass_name());
        aQa.setUser_name(aUser.getUser_name());
        aQa.setUser_avartar(aUser.getUser_avartar());

        aQa.setQa_is_top(1);
        aQa.setQa_upper_id(0);
        aQa.setQa_zan(0);
        aQa.setQa_teacher_score(0);
        aQa.setQa_other_score(0);

        System.err.println(aQa);
//        aQaService.setQA(aQa);


    }


    @Test
    public void findmyteachclass(){
        Integer user_id =3;

        List<A_MyteachclassVO> aMyteachclassVOS =new ArrayList<>();
        A_Teacher aTeacher = aUserService.findTeacherByUid(user_id);
        List<A_Kechengclass> aKechengclasses =aKechengclassService.findbyteacher_id(aTeacher.getTeacher_id());
        for (A_Kechengclass aKechengclass : aKechengclasses){
            A_MyteachclassVO aMyteachclassVO = new A_MyteachclassVO();
            aMyteachclassVO.setKechengclass_id(aKechengclass.getKechengclass_id());
            aMyteachclassVO.setKechengclass_name(aKechengclass.getKechengclass_name());
            aMyteachclassVO.setKechengclass_miaoshu(aKechengclass.getKechengclass_miaoshu());
            aMyteachclassVO.setKechengclass_kaishishijian(aKechengclass.getKechengclass_kaishishijian());
            aMyteachclassVO.setKechengclass_jieshushijian(aKechengclass.getKechengclass_jieshushijian());
            aMyteachclassVO.setKechengclass_image(aKechengclass.getKechengclass_image());

            aMyteachclassVO.setTeacher_name(aTeacher.getUser_name());
            aMyteachclassVO.setTeacher_id(aTeacher.getTeacher_id());

            aMyteachclassVO.setUser_id(user_id);

            A_Kecheng aKecheng =aKechengService.find(aKechengclass.getKecheng_id());
            aMyteachclassVO.setKecheng_id(aKecheng.getKecheng_id());
            aMyteachclassVO.setKecheng_name(aKecheng.getKecheng_name());
            aMyteachclassVO.setKecheng_leixing(aKecheng.getKecheng_leixing());
            aMyteachclassVO.setKecheng_xuefen(aKecheng.getKecheng_xuefen());
            aMyteachclassVOS.add(aMyteachclassVO);

            List<A_Student_kechengclass> aStudentKechengclasses=aStudentKechengclassService.findbyKechengclass_id(aKechengclass.getKechengclass_id());
            Integer num = aStudentKechengclasses.size();
            aMyteachclassVO.setStudentnum(num.toString());
        }
        System.err.println(aMyteachclassVOS);



    }

    @Test
    public  void  wx_collect_qa(){
        Integer user_id=1;
        Integer kechengclass_id;

        List<A_QAvo> aQAvos =new ArrayList<>();
        List<A_Collect> aCollects = aCollectService.find(user_id);
        for (A_Collect aCollect :aCollects) {
            List<A_QA> aQas =aQaService.findByQa_id( aCollect.getQa_id());
            for (A_QA aQa : aQas) {
                A_QAvo aQAvo =new A_QAvo();
                aQAvo.setQa_id(aQa.getQa_id());
                aQAvo.setUser_id(aQa.getUser_id());
                aQAvo.setStudent_id(aQa.getStudent_id());
                aQAvo.setTeacher_id(aQa.getTeacher_id());
                aQAvo.setKechengclass_id(aQa.getKechengclass_id());
                aQAvo.setKechengclass_name(aQa.getKechengclass_name());
                aQAvo.setUser_name(aQa.getUser_name());
                aQAvo.setUser_avartar(aQa.getUser_avartar());
                aQAvo.setUser_class(aQa.getUser_class());
                aQAvo.setQa_content(aQa.getQa_content());
                aQAvo.setQa_images(aQa.getQa_images());
                aQAvo.setQa_is_top(aQa.getQa_is_top());
                aQAvo.setQa_upper_id(aQa.getQa_upper_id());
                aQAvo.setQa_zan(aQa.getQa_zan());
                aQAvo.setQa_teacher_score(aQa.getQa_teacher_score());
                aQAvo.setQa_other_score(aQa.getQa_other_score());
                aQAvo.setIs_delete(aQa.getIs_delete());
                aQAvo.setCreated_user(aQa.getCreated_user());
                aQAvo.setCreated_time(aQa.getCreated_time());
                aQAvo.setModified_user(aQa.getModified_user());
                aQAvo.setModified_time(aQa.getModified_time());
                aQAvos.add(aQAvo);
            }
            for (A_QAvo aQAvo : aQAvos){
                List<A_QA> aQas2 = aQaService.findByQA_idForChild(aQAvo.getQa_id());
                aQAvo.setComment(aQas2);
            }
        }
        System.err.println(aQAvos);
    }
}
