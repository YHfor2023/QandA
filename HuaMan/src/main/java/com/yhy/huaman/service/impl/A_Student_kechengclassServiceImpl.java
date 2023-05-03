package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Student_kechengclass;
import com.yhy.huaman.mapper.A_KechengMapper;
import com.yhy.huaman.mapper.A_Student_kechengclassMapper;
import com.yhy.huaman.mapper.A_UserMapper;
import com.yhy.huaman.service.A_KechengService;
import com.yhy.huaman.service.A_Student_kechengclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_Student_kechengclassServiceImpl implements A_Student_kechengclassService {
    @Autowired
    private A_Student_kechengclassMapper aStudentKechengclassMapper;
    @Autowired
    private A_UserMapper aUserMapper;

    @Override
    public void setA_Student_kechengclassInfo(Integer user_id,Integer kechengclass_id){
        A_Student_kechengclass a_student_kechengclass =new A_Student_kechengclass();
        a_student_kechengclass.setKechengclass_id(kechengclass_id);
        a_student_kechengclass.setStudent_id(aUserMapper.findStudentByUid(user_id).getStudent_id());
        a_student_kechengclass.setStudent_kechengclass_fenshu("0");
        //补全数据:is_delete设置为0
        a_student_kechengclass.setIs_delete(0);
        //补全数据：四个日志字段信息
        a_student_kechengclass.setCreated_user(aUserMapper.findStudentByUid(user_id).getUser_name());
        a_student_kechengclass.setModified_user(aUserMapper.findStudentByUid(user_id).getUser_name());
        Date date =new Date();
        a_student_kechengclass.setCreated_time(date);
        a_student_kechengclass.setModified_time(date);
        aStudentKechengclassMapper.insert(a_student_kechengclass);
    }

    /**
     * 根据学生的id查询 学生加入课程班级 的信息，主要用于查询学生加入了什么课程班级
     * @param Student_id 学生的id
     * @return 学生加入课程班级 的信息
     */
    @Override
    public List<A_Student_kechengclass> findbyStudent_id(Integer Student_id){
        List<A_Student_kechengclass> result = aStudentKechengclassMapper.findbyStudent_id(Student_id);
        return result;
    }

    /**
     * 根据课程班级id查询 学生加入课程班级的信息，主要用于查询一个课程班级内有哪些学生
     * @param kechengclass_id 课程班级id
     * @return 学生加入课程班级 的信息
     */
    @Override
    public List<A_Student_kechengclass> findbyKechengclass_id(Integer kechengclass_id){
        List<A_Student_kechengclass> result = aStudentKechengclassMapper.findbyKechengclass_id(kechengclass_id);
        return  result;
    }
}
