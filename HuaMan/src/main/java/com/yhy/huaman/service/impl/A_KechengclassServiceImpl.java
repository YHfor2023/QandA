package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Kechengclass;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.mapper.A_KechengMapper;
import com.yhy.huaman.mapper.A_KechengclassMapper;
import com.yhy.huaman.mapper.A_UserMapper;
import com.yhy.huaman.service.A_KechengService;
import com.yhy.huaman.service.A_KechengclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_KechengclassServiceImpl implements A_KechengclassService {
    @Autowired
    private A_KechengclassMapper aKechengclassMapper;
    @Autowired
    private A_UserMapper aUserMapper;
    @Autowired
    private A_KechengMapper aKechengMapper;

    @Override
    public void setKechengclassInfo(A_Kechengclass aKechengclass, Integer teacher_id, Integer kecheng_id){
        A_Teacher aTeacher =aUserMapper.findTeacherByTeacher_id(teacher_id);
        aKechengclass.setTechear_name(aTeacher.getUser_name());
        aKechengclass.setKecheng_name(aKechengMapper.find(kecheng_id).getKecheng_name());
        //补全数据:is_delete设置为0
        aKechengclass.setIs_delete(0);
        //补全数据：四个日志字段信息
        aKechengclass.setCreated_user(aTeacher.getUser_name());
        aKechengclass.setModified_user(aTeacher.getUser_name());
        Date date =new Date();
        aKechengclass.setCreated_time(date);
        aKechengclass.setModified_time(date);
        aKechengclassMapper.insert(aKechengclass);
    }

    @Override
    public A_Kechengclass find(Integer kechengclass_id){
        A_Kechengclass result = aKechengclassMapper.find(kechengclass_id);
        return result;
    }

    @Override
    public List<A_Kechengclass> findbyteacher_id(Integer teacher_id) {
        List<A_Kechengclass> result = aKechengclassMapper.findbyteacher_id(teacher_id);
        return result;
    }

    @Override
    public List<A_Kechengclass> findbykecheng_id(Integer kecheng_id) {
        return aKechengclassMapper.findbykecheng_id(kecheng_id);
    }
}
