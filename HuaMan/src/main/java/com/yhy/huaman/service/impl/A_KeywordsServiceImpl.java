package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_Keywords;
import com.yhy.huaman.mapper.A_KeywordsMapper;
import com.yhy.huaman.mapper.A_UserMapper;
import com.yhy.huaman.service.A_KeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_KeywordsServiceImpl implements A_KeywordsService {
    @Autowired
    private A_KeywordsMapper akeywordsMapper;
    @Autowired
    private A_UserMapper aUserMapper;


//    A_Keywords find(Integer user_id);
    @Override
    public Integer insert(A_Keywords akeywords, Integer user_id){
        //补全数据:is_delete设置为0
        akeywords.setIs_delete(0);
        //补全数据：四个日志字段信息
        akeywords.setCreated_user(aUserMapper.findByUid(user_id).getUser_name());
        akeywords.setModified_user(aUserMapper.findByUid(user_id).getUser_name());
        Date date =new Date();
        akeywords.setCreated_time(date);
        akeywords.setModified_time(date);

        Integer row= akeywordsMapper.insert(akeywords);
        return row;
    }

    @Override
    public List<A_Keywords> findbykechengclass_id(Integer kechengclass_id) {
        return akeywordsMapper.findbykechengclass_id(kechengclass_id);
    }

}
