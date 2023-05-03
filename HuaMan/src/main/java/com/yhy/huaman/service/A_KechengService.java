package com.yhy.huaman.service;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Student;
import com.yhy.huaman.entity.A_Teacher;
import com.yhy.huaman.entity.A_User;

import java.util.List;

/**业务层接口*/
public interface A_KechengService {

    void setKechengInfo(A_Kecheng aKecheng);
    A_Kecheng find(Integer kecheng_id);
    /**
     * 查找所有的课程
     * @return
     */
    List<A_Kecheng> findallkecheng();



}
