package com.yhy.huaman.service.impl;

import com.yhy.huaman.entity.A_QA;
import com.yhy.huaman.mapper.A_QAMapper;
import com.yhy.huaman.mapper.A_QA_impMapper;
import com.yhy.huaman.service.A_QAService;
import com.yhy.huaman.service.A_QA_impService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//因为要将这个实现类交给spring管理,所以需要在类上加@Service
public class A_QA_impServiceImpl implements A_QA_impService {
    @Autowired
    A_QA_impMapper aQa_impMapper;
    /**
     * 根据QA_id查询QA
     * @param qa_id
     * @return
     */
    @Override
    public List<A_QA> findByQa_id(Integer qa_id){
       return aQa_impMapper.findByQa_id(qa_id);
    }

//    查看某用户的所有问题

    /**
     * 查看由当前用户发布的所有top问题
     * @param user_id
     * @return
     */
    @Override
    public List<A_QA> findByUser_idForTop(Integer user_id) {
        return aQa_impMapper.findByUser_idForTop(user_id);

    }

    /**
     * 根据当前问题的QA_id查询它的子问答
     * @param qa_id
     * @return
     */
    @Override
    public List<A_QA> findByQA_idForChild(Integer qa_id) {
        return aQa_impMapper.findByQA_idForChild(qa_id);
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
        return aQa_impMapper.findByKechengclass_idForTop(kechengclass_id);
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
        return aQa_impMapper.setQA(aQa);
    }

    @Override
    public Integer updateIsDeleteTo0(Integer qa_id) {
        return aQa_impMapper.updateIsDeleteTo0(qa_id);
    }

    @Override
    public Integer updateIsDeleteTo1(Integer qa_id) {
        return aQa_impMapper.updateIsDeleteTo1(qa_id);
    }
}
