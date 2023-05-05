package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Collect;

import java.util.List;

public interface A_CollectMapper {

    /**
     * 新增收藏记录
     * @param aCollect
     * @return
     */
    Integer insert(A_Collect aCollect);

    /**
     * 根据user_id查询收藏列表
     * @param user_id
     * @return
     */
    List<A_Collect> find(Integer user_id);

    /**
     * 根据user_id 和qa_id 来查找某条记录
     * @param user_id
     * @param qa_id
     * @return
     */
    A_Collect findbyUA_id(Integer user_id,Integer qa_id);

    /**
     * 修改为正在关注0
     * @param collect_id
     * @return
     */
    Integer updateIsDeleteTo0(Integer collect_id);

    /**
     * 修改为取消关注1
     * @param collect_id
     * @return
     */
    Integer updateIsDeleteTo1(Integer collect_id);

    List<A_Collect> findbyQA_id(Integer qa_id);
}
