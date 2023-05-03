package com.yhy.huaman.mapper;


import com.yhy.huaman.entity.A_QA;

import java.util.List;

public interface A_QA_impMapper {
    /**
     * 根据QA_id查询QA
     * @param qa_id
     * @return
     */
    List<A_QA> findByQa_id(Integer qa_id);

//    查看某用户的所有问题

    /**
     * 查看由当前用户发布的所有top问题
     * @param user_id
     * @return
     */
    List<A_QA> findByUser_idForTop(Integer user_id);

    /**
     * 根据当前问题的QA_id查询它的子问答
     * @param qa_id
     * @return
     */
    List<A_QA> findByQA_idForChild(Integer qa_id);

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
    List<A_QA> findByKechengclass_idForTop(Integer kechengclass_id);

    /**
     * 新增问答
     * @param aQa
     * @return
     */
    Integer setQA(A_QA aQa);

    /**
     * 修改为正在精选0
     * @param qa_id
     * @return
     */
    Integer updateIsDeleteTo0(Integer qa_id);

    /**
     * 修改为取消精选1
     * @param qa_id
     * @return
     */
    Integer updateIsDeleteTo1(Integer qa_id);

}
