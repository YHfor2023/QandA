package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_Collect;
import com.yhy.huaman.entity.A_QA;
import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Student_kechengclass;
import com.yhy.huaman.mapper.*;
import com.yhy.huaman.service.A_QAService;
import com.yhy.huaman.vo.A_QAscoreVO;
import com.yhy.huaman.vo.A_StudentscoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_QAServiceImpl implements A_QAService {
    @Autowired
    A_QAMapper aQaMapper;
    @Autowired
    private A_Student_kechengclassMapper aStudentKechengclassMapper;
    @Autowired
    private A_CollectMapper aCollectMapper;
    @Autowired
    private A_QA_impMapper aQaImpMapper;
    @Autowired
    private A_UserMapper aUserMapper;
    /**
     * 根据QA_id查询QA
     * @param qa_id
     * @return
     */
    @Override
    public List<A_QA> findByQa_id(Integer qa_id){
       return aQaMapper.findByQa_id(qa_id);
    }

//    查看某用户的所有问题

    /**
     * 查看由当前用户发布的所有top问题
     * @param user_id
     * @return
     */
    @Override
    public List<A_QA> findByUser_idForTop(Integer user_id) {
        return aQaMapper.findByUser_idForTop(user_id);

    }

    /**
     * 根据当前问题的QA_id查询它的子问答
     * @param qa_id
     * @return
     */
    @Override
    public List<A_QA> findByQA_idForChild(Integer qa_id) {
        return aQaMapper.findByQA_idForChild(qa_id);
    }

//    /**
//     * 根据当前问题的QA_id查询它的top问答
//     * @param qa_id
//     * @return
//     */
//    List<A_QA> findByQA_idForTop(Integer qa_id);

    /**
     * 根据当前课程班级的kechengclass_id查询它的top问答
     * @param kechengclass_id
     * @return
     */
    @Override
    public List<A_QA> findByKechengclass_idForTop(Integer kechengclass_id) {
        return aQaMapper.findByKechengclass_idForTop(kechengclass_id);
    }

    /**
     * 新增问答
     * @param aQa
     * @return
     */
    @Override
    public Integer setQA(A_QA aQa) {

        //补全数据:is_delete设置为0
        aQa.setIs_delete(0);
        //补全数据：四个日志字段信息
        aQa.setCreated_user(aQa.getUser_name());
        aQa.setModified_user(aQa.getUser_name());
        Date date =new Date();
        aQa.setCreated_time(date);
        aQa.setModified_time(date);
        return aQaMapper.setQA(aQa);
    }

    @Override
    public Integer give5(Integer qa_id) {
        return aQaMapper.givescore(qa_id,5);
    }

    @Override
    public Integer give3(Integer qa_id) {
        return aQaMapper.givescore(qa_id,3);
    }

    @Override
    public Integer give1(Integer qa_id) {
        return aQaMapper.givescore(qa_id,1);
    }
    @Override
    public Integer give0(Integer qa_id) {
        return aQaMapper.givescore(qa_id,0);
    }

    @Override
    public Integer updateIsDeleteTo1(Integer qa_id,Integer user_id) {
        return aQaMapper.updateIsDeleteTo1(qa_id,user_id);
    }

    @Override
    public List<A_StudentscoreVO> kechengClassScore(Integer kechengclass_id) {
        List<A_StudentscoreVO> aStudentscoreVOS =new ArrayList<>();

        List<A_Student_kechengclass> aStudentList = aStudentKechengclassMapper.findbyKechengclass_id(kechengclass_id);
        for (A_Student_kechengclass a : aStudentList){
            A_StudentscoreVO aStudentscoreVO =new A_StudentscoreVO();
            aStudentscoreVO.setStudent_id(a.getStudent_id());
            aStudentscoreVO.setUser_name(aUserMapper.findStudentByStudent_id(a.getStudent_id()).getUser_name());
            aStudentscoreVO.setStudent_banji(aUserMapper.findStudentByStudent_id(a.getStudent_id()).getStudent_banji());
            aStudentscoreVO.setStudent_xuehao(aUserMapper.findStudentByStudent_id(a.getStudent_id()).getStudent_xuehao());
            aStudentscoreVO.setStudent_zhuanye(aUserMapper.findStudentByStudent_id(a.getStudent_id()).getStudent_zhuanye());

            Integer qa_all = 0;
            Integer teacher_score_all = 0;
            Integer answered_score_all = 0;
            Integer collected_score_all = 0;
            Integer imped_score_all = 0;
            List<A_QA> aQas = aQaMapper.findByKechengclass_idAndStudent_id(kechengclass_id,a.getStudent_id());

            List<A_QAscoreVO> aQAscoreVOS =new ArrayList<>();
            for (A_QA aQa : aQas){
                A_QAscoreVO aQAscoreVO =new A_QAscoreVO();
                aQAscoreVO.setQa_id(aQa.getQa_id());
                aQAscoreVO.setQa_content(aQa.getQa_content());
                aQAscoreVO.setUser_name(aQa.getUser_name());
                aQAscoreVO.setKechengclass_name(aQa.getKechengclass_name());

                qa_all = qa_all + 1;

                teacher_score_all = teacher_score_all + aQa.getQa_teacher_score();
                aQAscoreVO.setTeacher_score(aQAscoreVO.getTeacher_score());

                Integer answered_score = 0;
                List<A_QA> aQas_answers = aQaMapper.findByQA_idForChild(aQa.getQa_id());
                for (A_QA aQa1 : aQas_answers){
                    answered_score = answered_score +1;
                }
                answered_score_all =answered_score_all +answered_score;
                aQAscoreVO.setAnswered_score(answered_score);

                Integer collected_score = 0;
                List<A_Collect> aQas_collects = aCollectMapper.findbyQA_id(aQa.getQa_id());
                for (A_Collect aCollect : aQas_collects){
                    collected_score = collected_score +1;
                }
                collected_score_all = collected_score_all + collected_score;
                aQAscoreVO.setCollected_score(collected_score);

                Integer imped_score = 0;
                List<A_QA> aQa_imp = aQaImpMapper.findByQa_id(aQa.getQa_id());
                for (A_QA aQa1 : aQa_imp){
                    imped_score = imped_score +1;
                }
                imped_score_all = imped_score_all + imped_score;
                aQAscoreVO.setImped_score(imped_score);
                aQAscoreVOS.add(aQAscoreVO);
            }
            aStudentscoreVO.setQa_all(qa_all);
            aStudentscoreVO.setTeacher_score_all(teacher_score_all);
            aStudentscoreVO.setAnswered_score_all(answered_score_all);
            aStudentscoreVO.setCollected_score_all(collected_score_all);
            aStudentscoreVO.setImped_score_all(imped_score_all);
            aStudentscoreVO.setaQAscoreVOS(aQAscoreVOS);

            aStudentscoreVOS.add(aStudentscoreVO);
        }
        return  aStudentscoreVOS;
    }

    @Override
    public List<A_StudentscoreVO> studentScore(Integer user_id,Integer kechengclass_id) {
        Integer student_id = aUserMapper.findStudentByUid(user_id).getStudent_id();
        List<A_StudentscoreVO> aStudentscoreVOS =new ArrayList<>();

        List<A_Student_kechengclass>  aStudentKechengclasses = aStudentKechengclassMapper.findbyKechengclass_idandStudent_id(kechengclass_id,student_id);
        for (A_Student_kechengclass a : aStudentKechengclasses){
            A_Student aStudent = aUserMapper.findStudentByStudent_id(student_id);

            A_StudentscoreVO aStudentscoreVO =new A_StudentscoreVO();
            aStudentscoreVO.setStudent_id(aStudent.getStudent_id());
            aStudentscoreVO.setUser_name(aStudent.getUser_name());
            aStudentscoreVO.setStudent_banji(aStudent.getStudent_banji());
            aStudentscoreVO.setStudent_xuehao(aStudent.getStudent_xuehao());
            aStudentscoreVO.setStudent_zhuanye(aStudent.getStudent_zhuanye());

            Integer qa_all = 0;
            Integer teacher_score_all = 0;
            Integer answered_score_all = 0;
            Integer collected_score_all = 0;
            Integer imped_score_all = 0;
//            System.err.print("\nstudentid:"+aStudent.getStudent_id());
            List<A_QA> aQas = aQaMapper.findByKechengclass_idAndStudent_id(kechengclass_id,aStudent.getStudent_id());
//            if(aQas.size()>0){
//                System.err.println(aQas.get(0).getKechengclass_name());
//            }
            List<A_QAscoreVO> aQAscoreVOS =new ArrayList<>();
            for (A_QA aQa : aQas){
                A_QAscoreVO aQAscoreVO =new A_QAscoreVO();
                aQAscoreVO.setQa_id(aQa.getQa_id());
                aQAscoreVO.setQa_content(aQa.getQa_content());
                aQAscoreVO.setUser_name(aQa.getUser_name());
                aQAscoreVO.setKechengclass_name(aQa.getKechengclass_name());

//                System.err.print("  "+aQa.getQa_id());
                qa_all = qa_all + 1;

//                System.err.print("  老师给分:"+aQa.getQa_teacher_score());
                teacher_score_all = teacher_score_all + aQa.getQa_teacher_score();
                aQAscoreVO.setTeacher_score(aQAscoreVO.getTeacher_score());

                Integer answered_score = 0;
                List<A_QA> aQas_answers = aQaMapper.findByQA_idForChild(aQa.getQa_id());
                for (A_QA aQa1 : aQas_answers){
                    answered_score = answered_score +1;
                }
                answered_score_all =answered_score_all +answered_score;
//                System.err.print("  被评论数目:"+answered_score);
                aQAscoreVO.setAnswered_score(answered_score);

                Integer collected_score = 0;
                List<A_Collect> aQas_collects = aCollectMapper.findbyQA_id(aQa.getQa_id());
                for (A_Collect aCollect : aQas_collects){
                    collected_score = collected_score +1;
                }
                collected_score_all = collected_score_all + collected_score;
//                System.err.print("  被收藏数目:"+collected_score);
                aQAscoreVO.setCollected_score(collected_score);

                Integer imped_score = 0;
                List<A_QA> aQa_imp = aQaImpMapper.findByQa_id(aQa.getQa_id());
                for (A_QA aQa1 : aQa_imp){
                    imped_score = imped_score +1;
                }
                imped_score_all = imped_score_all + imped_score;
//                System.err.println("  被精选数目:"+collected_score);
                aQAscoreVO.setImped_score(imped_score);
                aQAscoreVOS.add(aQAscoreVO);
            }
            aStudentscoreVO.setQa_all(qa_all);
            aStudentscoreVO.setTeacher_score_all(teacher_score_all);
            aStudentscoreVO.setAnswered_score_all(answered_score_all);
            aStudentscoreVO.setCollected_score_all(collected_score_all);
            aStudentscoreVO.setImped_score_all(imped_score_all);
            aStudentscoreVO.setaQAscoreVOS(aQAscoreVOS);

            aStudentscoreVOS.add(aStudentscoreVO);
//            System.err.println("总提问数："+qa_all+"  总老师给分："+teacher_score_all+"  总评论数："
//                    +answered_score_all+"  总被收藏数："+collected_score_all+"  总被精选数："+imped_score_all);
        }
//        System.err.println(aStudentscoreVOS);
        return  aStudentscoreVOS;
    }
}
