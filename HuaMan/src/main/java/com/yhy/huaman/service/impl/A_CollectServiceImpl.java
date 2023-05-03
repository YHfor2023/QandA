package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_Collect;
import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.mapper.A_CollectMapper;
import com.yhy.huaman.mapper.A_KechengMapper;
import com.yhy.huaman.mapper.A_UserMapper;
import com.yhy.huaman.service.A_CollectService;
import com.yhy.huaman.service.A_KechengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_CollectServiceImpl implements A_CollectService {
    @Autowired
    private A_CollectMapper aCollectMapper;
    @Autowired
    private A_UserMapper aUserMapper;


//    A_Collect find(Integer user_id);
    @Override
    public Integer insert(A_Collect aCollect){

        //补全数据:is_delete设置为0
        aCollect.setIs_delete(0);
        //补全数据：四个日志字段信息
        aCollect.setCreated_user(aUserMapper.findByUid(aCollect.getUser_id()).getUser_name());
        aCollect.setModified_user(aUserMapper.findByUid(aCollect.getUser_id()).getUser_name());
        Date date =new Date();
        aCollect.setCreated_time(date);
        aCollect.setModified_time(date);

        Integer row= aCollectMapper.insert(aCollect);
        return row;
    }

    @Override
    public List<A_Collect> find(Integer user_id){
        return aCollectMapper.find(user_id);
    }

    @Override
    public A_Collect findbyUA_id(Integer user_id, Integer qa_id) {
        return aCollectMapper.findbyUA_id(user_id,qa_id);
    }

    @Override
    public Integer updateIsDeleteTo0(Integer collect_id) {
        return aCollectMapper.updateIsDeleteTo0(collect_id);
    }

    @Override
    public Integer updateIsDeleteTo1(Integer collect_id) {
        return aCollectMapper.updateIsDeleteTo1(collect_id);
    }
}
