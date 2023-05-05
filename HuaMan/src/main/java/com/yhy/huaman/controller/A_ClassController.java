package com.yhy.huaman.controller;

import com.yhy.huaman.entity.*;
import com.yhy.huaman.service.*;
import com.yhy.huaman.util.JsonResult;
import com.yhy.huaman.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController //其作用等同于@Controller+@ResponseBody
//@Controller
@RequestMapping("qa")
public class A_ClassController extends BaseController{

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
    private A_QA_impService aQa_impService;
    @Autowired
    private A_CollectService aCollectService;
    @Autowired
    private A_KeywordsService aKeywordsService;

    /**
     * 查询课程信息
     * @param kecheng_id 课程id
     * @return 课程信息
     */
    @RequestMapping("findKechengInfo")
    public JsonResult<A_Kecheng> findKechengInfo(Integer kecheng_id){
        A_Kecheng aKecheng = aKechengService.find(kecheng_id);
        return new JsonResult<A_Kecheng>(OK,aKecheng);
    }

    /**
     * 录入课程信息
     * @param aKecheng 课程对象
     * @return
     */
    @RequestMapping("setKechengInfo")
    public JsonResult<Void> setKechengInfo(A_Kecheng aKecheng){
        aKechengService.setKechengInfo(aKecheng);
        return new JsonResult(OK,"信息录入成功");
    }

    /**
     * 查询课程班级信息
     * @param kechengclass_id
     * @return 课程班级对象
     */
    @RequestMapping("findKechengclassInfo")
    public JsonResult<A_Kechengclass> findKechengclassInfo(Integer kechengclass_id){
        A_Kechengclass aKechengclass = aKechengclassService.find(kechengclass_id);
        return new JsonResult<A_Kechengclass>(OK,aKechengclass);
    }

    /**
     * 录入课程班级信息
     * @param aKechengclass 课程班级对象
     * @param teacher_id 老师id
     * @param kecheng_id 课程id
     * @return
     */
    @RequestMapping("setKechengclassInfo")
    public JsonResult<Void> setKechengclassInfo(A_Kechengclass aKechengclass, Integer teacher_id, Integer kecheng_id){
        aKechengclassService.setKechengclassInfo(aKechengclass,teacher_id,kecheng_id);
        return new JsonResult(OK,"信息录入成功");
    }

    /**
     * 搜索当前课程班级的关键词
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("findkeywords")
    public JsonResult<List<A_Keywords>> findkeywords(Integer kechengclass_id){
        List<A_Keywords> keywordsList = aKeywordsService.findbykechengclass_id(kechengclass_id);
        return new JsonResult<List<A_Keywords>>(OK,keywordsList);
    }

    /**
     * 录入关键词
     * @param aKeyword
     * @param user_id
     * @return
     */
    @RequestMapping("setkeyword")
    public JsonResult<Void> setkeyword(A_Keywords aKeyword, Integer user_id){
        aKeywordsService.insert(aKeyword,user_id);
        return new JsonResult(OK,"信息录入成功");
    }

    /**
     * 根据课程班级id寻找加入的学生vo信息
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("findstudents")
    public JsonResult<List<A_StudentVO>> findstudents(Integer kechengclass_id){
        List<A_Student_kechengclass> aStudentKechengclasses = aStudentKechengclassService.findbyKechengclass_id(kechengclass_id);
        List<A_StudentVO> aStudentVOList =new ArrayList<>();
        for (A_Student_kechengclass a :aStudentKechengclasses){
            A_StudentVO aStudentVO =new A_StudentVO();
            aStudentVO.setStudent_kechengclass_id(a.getStudent_kechengclass_id());
            aStudentVO.setStudent_kechengclass_fenshu(a.getStudent_kechengclass_fenshu());
            A_Student aStudent = aUserService.findStudentByStudent_id(a.getStudent_id());
            aStudentVO.setStudent_id(aStudent.getStudent_id());
            aStudentVO.setUser_id(aStudent.getUser_id());
            aStudentVO.setUser_name(aStudent.getUser_name());
            aStudentVO.setStudent_xuehao(aStudent.getStudent_xuehao());
            aStudentVO.setStudent_banji(aStudent.getStudent_banji());
            aStudentVO.setStudent_xi(aStudent.getStudent_xi());
            aStudentVO.setStudent_yuan(aStudent.getStudent_yuan());
            aStudentVO.setStudent_zhuanye(aStudent.getStudent_zhuanye());

            aStudentVOList.add(aStudentVO);
        }
        return new JsonResult<List<A_StudentVO>>(OK,aStudentVOList);
    }

    /**
     * 删除学生入班信息
     * @param student_kechengclass_id
     * @return
     */
    @RequestMapping("deleteStudent")
    public JsonResult<Void> deleteStudent(Integer student_kechengclass_id){
        aStudentKechengclassService.updateIsDeleteTo1(student_kechengclass_id);
        return new JsonResult(OK,"删除成功");
    }

    @RequestMapping("insertStudentBystudent_banji")
    public JsonResult<Void> insertStudentBystudent_banji(String student_banji,Integer kechengclass_id){
        List<A_Student> aStudentList = aUserService.findStudentBystudent_banji(student_banji);
        for (A_Student aStudent :aStudentList){
            aStudentKechengclassService.setA_Student_kechengclassInfo(aStudent.getUser_id(),kechengclass_id);
        }
        return new JsonResult(OK,"成功");
    }
    /**
     * 学生加入课程班级
     * @param user_id 用户id
     * @param kechengclass_id 课程班级id
     * @return
     */
    @RequestMapping("setA_Student_kechengclassInfo")
    public JsonResult<Void> setA_Student_kechengclassInfo(Integer user_id,Integer kechengclass_id){
        aStudentKechengclassService.setA_Student_kechengclassInfo(user_id,kechengclass_id);
        return new JsonResult(OK,"信息录入成功");
    }
    /**
     * 根据当前课程班级的kechengclass_id查询它的top问答
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("findkechengclass")
    public JsonResult<A_Kechengclass> findkechengclass(Integer kechengclass_id){
        A_Kechengclass aKechengclass = aKechengclassService.find(kechengclass_id);
        return new JsonResult<A_Kechengclass>(OK,aKechengclass);
    }
    /**
     * 根据用户id查找所加入的课程班级
     * @param user_id 用户id
     * @return 课程班级视图列表
     */
    @RequestMapping("findmystudyclass")
    public JsonResult<List<A_MystudyclassVO>> findmystudyclass(Integer user_id){

        List<A_MystudyclassVO> studyclasses=new ArrayList<>();
        /**
         * 用user_id查询学生表中的student_id，student_banji
         */
        A_Student aStudent = aUserService.findStudentByUid(user_id);
//        System.err.println(aMystudyclassVO);
        /**
         * 用student_id来查询学生加入课程班级信息表中的内容列表
         */
        List<A_Student_kechengclass> rows= aStudentKechengclassService.findbyStudent_id(aStudent.getStudent_id());
//        System.err.println(rows);
        /**
         * 用每一个记录中的课程班级id查询课程班级信息
         */
        for (A_Student_kechengclass askc : rows) {
            A_MystudyclassVO aMystudyclassVO =new A_MystudyclassVO();
            aMystudyclassVO.setUser_id(aStudent.getUser_id());
            aMystudyclassVO.setStudent_id(aStudent.getStudent_id());
            aMystudyclassVO.setStudent_banji(aStudent.getStudent_banji());

            A_Kechengclass aKechengclass =aKechengclassService.find(askc.getKechengclass_id());
            aMystudyclassVO.setKechengclass_id(aKechengclass.getKechengclass_id());
            aMystudyclassVO.setKechengclass_name(aKechengclass.getKechengclass_name());
            aMystudyclassVO.setKechengclass_miaoshu(aKechengclass.getKechengclass_miaoshu());
            aMystudyclassVO.setKechengclass_kaishishijian(aKechengclass.getKechengclass_kaishishijian());
            aMystudyclassVO.setKechengclass_jieshushijian(aKechengclass.getKechengclass_jieshushijian());
            aMystudyclassVO.setKechengclass_image(aKechengclass.getKechengclass_image());
            aMystudyclassVO.setTeacher_id(aKechengclass.getTeacher_id());
            aMystudyclassVO.setTeacher_name(aKechengclass.getTechear_name());

            A_Kecheng aKecheng = aKechengService.find(aKechengclass.getKecheng_id());
            aMystudyclassVO.setKecheng_id(aKecheng.getKecheng_id());
            aMystudyclassVO.setKecheng_name(aKecheng.getKecheng_name());
            aMystudyclassVO.setKecheng_leixing(aKecheng.getKecheng_leixing());
            aMystudyclassVO.setKecheng_xuefen(aKecheng.getKecheng_xuefen());
//            System.err.println(aMystudyclassVO);
            studyclasses.add(aMystudyclassVO);
        }
//        for(A_MystudyclassVO amcv :studyclasses){
//            System.err.println(amcv);
//            System.out.println("========");
//        }

        return new JsonResult<List<A_MystudyclassVO>>(OK,studyclasses);
    }

    /**
     * 根据用户id查找所开设的课程班级
     * @param user_id 用户id
     * @return 课程班级视图列表
     */
    @RequestMapping("findmyteachclass")
    public JsonResult<List<A_MyteachclassVO>> findmyteachclass(Integer user_id){
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

        return new JsonResult<List<A_MyteachclassVO>>(OK,aMyteachclassVOS);
    }

    /**
     * 根据QA_id查询QA
     * @param qa_id
     * @return
     */
    @RequestMapping("findByQa_id")
    public JsonResult<List<A_QA>> findByQa_id(Integer qa_id) {
        List<A_QA> aQas = aQaService.findByQa_id(qa_id);
        return new JsonResult<List<A_QA>>(OK,aQas);
    }

//    查看某用户的所有问题

    /**
     * 查看由当前用户发布的所有top问题
     * @param user_id
     * @return
     */
    @RequestMapping("findByUser_idForTop")
    public JsonResult<List<A_QAvo>> findByUser_idForTop(Integer user_id) {
        List<A_QAvo> aQAvos =new ArrayList<>();
        List<A_QA> aQas = aQaService.findByUser_idForTop(user_id);
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
        return new JsonResult<List<A_QAvo>>(OK,aQAvos);
    }

    /**
     * 根据当前问题的QA_id查询它的子问答
     * @param qa_id
     * @return
     */
    @RequestMapping("findByQA_idForChild")
    public JsonResult<List<A_QA>> findByQA_idForChild(Integer qa_id){
        List<A_QA> aQas = aQaService.findByQA_idForChild(qa_id);
        return new JsonResult<List<A_QA>>(OK,aQas);
    }

//    /**
//     * 根据当前问题的QA_id查询它的top问答
//     * @param qa_id
//     * @return
//     */
//    JsonResult<List<A_QA>> findByQA_idForTop(Integer qa_id);

    /**
     * 小程序功能，根据课程班级ID 查询这个课程班级下有多少top问答信息
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("wxkechengclassqa")
    public JsonResult<List<A_QAvo>> wxkechengclassqa(Integer kechengclass_id){
        List<A_QAvo> aQAvos =new ArrayList<>();
        List<A_QA> aQas = aQaService.findByKechengclass_idForTop(kechengclass_id);
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
        return new JsonResult<List<A_QAvo>>(OK,aQAvos);
    }

    /**
     * 依据课程查询问答精选信息
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("wxkechengclassqa_imp")
    public JsonResult<List<A_QAvo>> wxkechengclassqa_imp(Integer kechengclass_id){
        List<A_QAvo> aQAvos = findImpQAsVOByKehenglass_id(kechengclass_id);
        return new JsonResult<List<A_QAvo>>(OK,aQAvos);
    }

    /**
     * 查询所有课程的问答精选信息
     * @return
     */
    @RequestMapping("wxkechengAllqa_imp")
    public JsonResult<List<A_KechengVO>> wxkechengAllqa_imp(){
        List<A_KechengVO> aKechengVOS=kechengAllqa_imp();
        return new JsonResult<List<A_KechengVO>>(OK,aKechengVOS);
    }
    /**
     * 查询某id课程的问答精选信息
     * @return
     */
    @RequestMapping("wxkechengqa_impbyid_imp")
    public JsonResult<List<A_KechengclassVO>> wxkechengqa_impbyid_imp(Integer kecheng_id){
        List<A_Kechengclass> aKechengclasses =aKechengclassService.findbykecheng_id(kecheng_id);
        List<A_KechengclassVO> aKechengclassVOS =new ArrayList<>();
        for (A_Kechengclass aKechengclass:aKechengclasses){
            aKechengclassVOS.add(toA_KechengclassVO(aKechengclass));
        }
        for(A_KechengclassVO aKechengclassVO:aKechengclassVOS){
            aKechengclassVO.setaQAvos(findImpQAsVOByKehenglass_id(aKechengclassVO.getKechengclass_id()));
        }
        return new JsonResult<List<A_KechengclassVO>>(OK,aKechengclassVOS);
    }

    /**
     * 依据课程查询问答收藏信息
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("wxkechengclassqa_collect")
    public JsonResult<List<A_QAvo>> wxkechengclassqa_collect(Integer kechengclass_id,Integer user_id){
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
                if (aQa.getKechengclass_id()==kechengclass_id){
                    aQAvos.add(aQAvo);
                }
            }
            for (A_QAvo aQAvo : aQAvos){
                List<A_QA> aQas2 = aQaService.findByQA_idForChild(aQAvo.getQa_id());
                aQAvo.setComment(aQas2);
            }
        }
        return new JsonResult<List<A_QAvo>>(OK,aQAvos);
    }

    /**
     * 根据当前课程班级的kechengclass_id查询它的top问答
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("findByKechengclass_idForTop")
    public JsonResult<List<A_QA>> findByKechengclass_idForTop(Integer kechengclass_id){
        List<A_QA> aQas = aQaService.findByKechengclass_idForTop(kechengclass_id);
        return new JsonResult<List<A_QA>>(OK,aQas);
    }

    /**
     * 新增问答
     * @param aQa
     * @return
     */
    @RequestMapping("setQA")
    public JsonResult<Void> setQA(A_QA aQa) {
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
        aQa.setQa_teacher_score(0);
        aQa.setQa_other_score(0);
        aQaService.setQA(aQa);
        return new JsonResult(OK,"信息录入成功");
    }
    /**
     * 新增精选问答
     * @param
     * @return
     */
    @RequestMapping("setImpQA")
    public JsonResult<Void> setImpQA(Integer qa_id,Integer user_id) {
        A_QA aQa =new A_QA();
        A_QA aQaImp =new A_QA();
        List<A_QA> aQas =aQaService.findByQa_id(qa_id);
        if (aQas.size()!=0){
            aQa=aQas.get(0);
        }
        String username= aUserService.find(user_id).getUser_name();
        Date date =new Date();
        aQa.setModified_user(username);
        aQa.setModified_time(date);
//        System.err.println(aQa);
        List<A_QA> aQaImps =aQa_impService.findByQa_id(qa_id);
        if (aQaImps.size()!=0){
            aQaImp=aQas.get(0);
            if (aQaImp.getIs_delete()==0){
                aQa_impService.updateIsDeleteTo1(qa_id);
            }else {
                aQa_impService.updateIsDeleteTo0(qa_id);
            }
        }else {
            aQa_impService.setQA(aQa);
        }


        return new JsonResult(OK,"信息录入成功");
    }
    @RequestMapping("give5")
    public  JsonResult<Void> give5(Integer qa_id){
        aQaService.give5(qa_id);
        return new JsonResult(OK,"信息录入成功");
    }
    @RequestMapping("give3")
    public  JsonResult<Void> give3(Integer qa_id){
        aQaService.give3(qa_id);
        return new JsonResult(OK,"信息录入成功");
    }
    @RequestMapping("give1")
    public  JsonResult<Void> give1(Integer qa_id){
        aQaService.give1(qa_id);
        return new JsonResult(OK,"信息录入成功");
    }
    @RequestMapping("give0")
    public  JsonResult<Void> give0(Integer qa_id){
        aQaService.give0(qa_id);
        return new JsonResult(OK,"信息录入成功");
    }

    @RequestMapping("answer")
    public JsonResult<Void> answer(A_QA aQa){
//        qa/answer?user_id=1&qa_id=1&qa_content=wwww
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

        aQa.setQa_is_top(0);
        aQa.setQa_upper_id(aQa.getQa_id());
        aQa.setQa_zan(0);
        aQa.setQa_teacher_score(0);
        aQa.setQa_other_score(0);
        aQaService.setQA(aQa);
        return new JsonResult(OK,"信息录入成功");

    }

    @RequestMapping("collect")
    public JsonResult<Void> collect(A_Collect aCollect){
//qa/collect?user_id=1&qa_id=1
//获取传输的user_id
//        查询收藏表中user的收藏列表，查找是否有当前qa_Id user_id的记录
//        若存在，改变is_delete
//        若不存在，增加收藏记录
        A_Collect aCollect1 = aCollectService.findbyUA_id(aCollect.getUser_id(),aCollect.getQa_id());
        if(aCollect1!=null){
            if (aCollect1.getIs_delete()==0){
                aCollectService.updateIsDeleteTo1(aCollect1.getCollect_id());
            }else {
                aCollectService.updateIsDeleteTo0(aCollect1.getCollect_id());
            }
        }else {
            aCollectService.insert(aCollect);
        }

        return new JsonResult(OK,"信息录入成功");

    }
    @RequestMapping("delete")
    public JsonResult<Void> delete(Integer qa_id,Integer user_id){
        Integer row = aQaService.updateIsDeleteTo1(qa_id,user_id);

        return new JsonResult(OK,"删除成功");

    }
    @RequestMapping("addkechengclass")
    public JsonResult<Void> addkechengclass(A_Kechengclass aKechengclass,Integer user_id){
        A_Teacher aTeacher= aUserService.findTeacherByUid(user_id);
        aKechengclass.setTeacher_id(aTeacher.getTeacher_id());
        aKechengclassService.setKechengclassInfo(aKechengclass,aTeacher.getTeacher_id(),aKechengclass.getKecheng_id());

        return new JsonResult(OK,"成功");

    }

    @RequestMapping("findallkecheng")
    public JsonResult<List<A_Kecheng>> findallkecheng(){
        List<A_Kecheng> aKechengs = aKechengService.findallkecheng();
        return new JsonResult(OK,aKechengs);
    }

    /**
     * 评分系统-依据课程班级id 查看所有学生的分数情况
     * @param kechengclass_id
     * @return
     */
    @RequestMapping("kechengClassScore")
    public JsonResult<List<A_StudentscoreVO>> kechengClassScore(Integer kechengclass_id){
        List<A_StudentscoreVO> aStudentscoreVOList = aQaService.kechengClassScore(kechengclass_id);
        return new JsonResult<List<A_StudentscoreVO>>(OK,aStudentscoreVOList);
    }
    /**
     * 评分系统-依据用户id 查看学生的所有课程分数情况
     * @param user_id
     * @return
     */
    @RequestMapping("studentScore")
    public JsonResult<List<A_StudentscoreVO>> studentScore(Integer user_id,Integer kechengclass_id){
        List<A_StudentscoreVO> aStudentscoreVOList = aQaService.studentScore(user_id,kechengclass_id);
        return new JsonResult<List<A_StudentscoreVO>>(OK,aStudentscoreVOList);
    }

    private List<A_QAvo> findImpQAsVOByKehenglass_id(Integer kechengclass_id){
        List<A_QAvo> aQAvos =new ArrayList<>();
        List<A_QA> aQas = aQa_impService.findByKechengclass_idForTop(kechengclass_id);
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
        return aQAvos;
    }

    private  List<A_KechengVO> kechengAllqa_imp(){
        List<A_Kecheng> aKechengs =aKechengService.findallkecheng();
        List<A_KechengVO> aKechengVOS = new ArrayList<>();
        for (A_Kecheng aKecheng:aKechengs){
            aKechengVOS.add(toA_kechengVO(aKecheng));
        }
        for (A_KechengVO aKechengVO:aKechengVOS){
            List<A_Kechengclass> aKechengclasses =aKechengclassService.findbykecheng_id(aKechengVO.getKecheng_id());
            List<A_KechengclassVO> aKechengclassVOS =new ArrayList<>();
            for (A_Kechengclass aKechengclass:aKechengclasses){
                aKechengclassVOS.add(toA_KechengclassVO(aKechengclass));
            }
            for(A_KechengclassVO aKechengclassVO:aKechengclassVOS){
                aKechengclassVO.setaQAvos(findImpQAsVOByKehenglass_id(aKechengclassVO.getKechengclass_id()));
            }
            aKechengVO.setaKechengclassVOS(aKechengclassVOS);
        }
        return aKechengVOS;
    }


    private A_KechengVO toA_kechengVO(A_Kecheng aKecheng){
        A_KechengVO aKechengVO =new A_KechengVO();
        aKechengVO.setKecheng_id(aKecheng.getKecheng_id());
        aKechengVO.setKecheng_name(aKecheng.getKecheng_name());
        aKechengVO.setKecheng_miaoshu(aKecheng.getKecheng_miaoshu());
        aKechengVO.setKecheng_leixing(aKecheng.getKecheng_leixing());
        aKechengVO.setKecheng_xuefen(aKecheng.getKecheng_xuefen());
        return aKechengVO;
    }


    private A_KechengclassVO toA_KechengclassVO(A_Kechengclass aKechengclass){
        A_KechengclassVO aKechengclassVO =new A_KechengclassVO();
        aKechengclassVO.setKechengclass_id(aKechengclass.getKechengclass_id());
        aKechengclassVO.setKecheng_id(aKechengclass.getKecheng_id());
        aKechengclassVO.setKecheng_name(aKechengclass.getKecheng_name());
        aKechengclassVO.setTeacher_id(aKechengclass.getTeacher_id());
        aKechengclassVO.setTeacher_name(aKechengclass.getTechear_name());
        aKechengclassVO.setKechengclass_name(aKechengclass.getKechengclass_name());
        aKechengclassVO.setKechengclass_miaoshu(aKechengclass.getKechengclass_miaoshu());
        aKechengclassVO.setKechengclass_kaishishijian(aKechengclass.getKechengclass_kaishishijian());
        aKechengclassVO.setKechengclass_jieshushijian(aKechengclass.getKechengclass_jieshushijian());
        aKechengclassVO.setKechengclass_image(aKechengclass.getKechengclass_image());
        return aKechengclassVO;
    }

}

