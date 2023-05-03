package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;
import com.yhy.huaman.mapper.A_KechengMapper;
import com.yhy.huaman.mapper.A_UserMapper;
import com.yhy.huaman.service.A_KechengService;
import com.yhy.huaman.service.A_UserService;
import com.yhy.huaman.service.ex.InsertException;
import com.yhy.huaman.service.ex.PasswordNotMatchException;
import com.yhy.huaman.service.ex.UsernameDuplicatedException;
import com.yhy.huaman.service.ex.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_KechengServiceImpl implements A_KechengService {
    @Autowired
    private A_KechengMapper aKechengMapper;

    @Override
    public void setKechengInfo(A_Kecheng aKecheng){

        //补全数据:is_delete设置为0
        aKecheng.setIs_delete(0);
        //补全数据：四个日志字段信息
        aKecheng.setCreated_user("教务处");
        aKecheng.setModified_user("教务处");
        Date date =new Date();
        aKecheng.setCreated_time(date);
        aKecheng.setModified_time(date);
        aKechengMapper.insert(aKecheng);
    }

    @Override
    public List<A_Kecheng> findallkecheng() {
        return aKechengMapper.findallkecheng();
    }

    @Override
    public A_Kecheng find(Integer kecheng_id){
        A_Kecheng result = aKechengMapper.find(kecheng_id);
        return result;
    }
}
