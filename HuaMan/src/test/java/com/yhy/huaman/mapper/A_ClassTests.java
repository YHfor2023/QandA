package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.*;
import com.yhy.huaman.service.*;
import com.yhy.huaman.util.JsonResult;
import com.yhy.huaman.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.tomcat.util.http.fileupload.IOUtils.copy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class A_ClassTests {
    @Autowired
    private A_QAMapper aQaMapper;
    @Autowired
    private A_CollectService aCollectService;
    @Autowired
    private A_QA_impService aQaImpService;
    @Autowired
    private A_UserService aUserService;
    @Autowired
    private A_KechengService aKechengService;
    @Autowired
    private  A_KechengclassService aKechengclassService;

    @Autowired
    private A_QAService aQaService;
    @Test
    public void insert() {
        A_QA aQa =new A_QA();
        aQa.setQa_content("ceshi");
        aQaMapper.setQA(aQa);
    }

    @Test
    public void findByQa_id() {
        List<A_QA> qas=new ArrayList<>();
        qas=aQaMapper.findByQa_id(1);
        for (A_QA qaitem : qas) {
            System.err.println(qaitem);
        }
    }

    @Test
    public void findByUser_idForTop() {
        List<A_QA> qas=new ArrayList<>();
        qas=aQaMapper.findByUser_idForTop(1);
        for (A_QA qaitem : qas) {
            System.err.println(qaitem);
        }
    }

    @Test
    public void findByQA_idForChild() {
        List<A_QA> qas=new ArrayList<>();
        qas=aQaMapper.findByQA_idForChild(1);
        for (A_QA qaitem : qas) {
            System.err.println(qaitem);
        }
    }

//    @Test
//    public void findByKechengclass_idForTop() {
//        List<A_QA> qas=new ArrayList<>();
//        qas=aQaMapper.findByKechengclass_idForTop(4);
//        for (A_QA qaitem : qas) {
//            System.err.println(qaitem);
//        }
//    }

    @Test
    public void testCollect(){
        A_Collect aCollect =new A_Collect();
        aCollect.setQa_id(1);
        aCollect.setUser_id(1);
        A_Collect aCollect1 = aCollectService.findbyUA_id(aCollect.getUser_id(),aCollect.getQa_id());
        System.err.println(aCollect1);
        if(aCollect1!=null){
            if (aCollect1.getIs_delete()==0){
                aCollectService.updateIsDeleteTo1(aCollect1.getCollect_id());
            }else {
                aCollectService.updateIsDeleteTo0(aCollect1.getCollect_id());
            }
        }else {
            aCollectService.insert(aCollect);
        }
    }

    @Test
    public void testImp(){
        Integer qa_id = 5;
        Integer user_id =4;
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
        List<A_QA> aQaImps =aQaImpService.findByQa_id(qa_id);
        if (aQaImps.size()!=0){
            aQaImp=aQas.get(0);
            if (aQaImp.getIs_delete()==0){
                aQaImpService.updateIsDeleteTo1(qa_id);
            }else {
                aQaImpService.updateIsDeleteTo0(qa_id);
            }
        }else {
            aQaImpService.setQA(aQa);
        }
    }
    @Test
    public void wxkechengAllqa_imp(){
        List<A_KechengVO> aKechengVOS=kechengAllqa_imp();
        System.err.println(aKechengVOS);
    }
    @Test
    public void wxkechengqa_impbyid(){
            Integer kecheng_id=1;
            List<A_Kechengclass> aKechengclasses =aKechengclassService.findbykecheng_id(kecheng_id);
            List<A_KechengclassVO> aKechengclassVOS =new ArrayList<>();
            for (A_Kechengclass aKechengclass:aKechengclasses){
                aKechengclassVOS.add(toA_KechengclassVO(aKechengclass));
            }
            for(A_KechengclassVO aKechengclassVO:aKechengclassVOS){
                aKechengclassVO.setaQAvos(findImpQAsVOByKehenglass_id(aKechengclassVO.getKechengclass_id()));
            }
        System.err.println(aKechengclassVOS);

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
    private List<A_QAvo> findImpQAsVOByKehenglass_id(Integer kechengclass_id){
        List<A_QAvo> aQAvos =new ArrayList<>();
        List<A_QA> aQas = aQaImpService.findByKechengclass_idForTop(kechengclass_id);
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

    /**
     *      private Integer kecheng_id;
     *     private String kecheng_name;
     *     private String kecheng_miaoshu;
     *     private String kecheng_leixing;
     *     private String kecheng_xuefen;
     *     private List<A_KechengVO> aKechengVOS;
     * @param aKecheng
     * @return
     */
    private A_KechengVO toA_kechengVO(A_Kecheng aKecheng){
        A_KechengVO aKechengVO =new A_KechengVO();
        aKechengVO.setKecheng_id(aKecheng.getKecheng_id());
        aKechengVO.setKecheng_name(aKecheng.getKecheng_name());
        aKechengVO.setKecheng_miaoshu(aKecheng.getKecheng_miaoshu());
        aKechengVO.setKecheng_leixing(aKecheng.getKecheng_leixing());
        aKechengVO.setKecheng_xuefen(aKecheng.getKecheng_xuefen());
        return aKechengVO;
    }

    /**
     * private Integer kechengclass_id;
     *     private Integer kecheng_id;
     *     private String kecheng_name;
     *     private Integer teacher_id;
     *     private String teacher_name;
     *     private String kechengclass_name;
     *     private String kechengclass_miaoshu;
     *     private String kechengclass_kaishishijian;
     *     private String kechengclass_jieshushijian;
     *     private String kechengclass_image;
     *     private List<A_QAvo> aQAvos;
     */
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
