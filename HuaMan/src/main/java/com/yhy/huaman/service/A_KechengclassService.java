package com.yhy.huaman.service;

import com.yhy.huaman.entity.A_Kecheng;
import com.yhy.huaman.entity.A_Kechengclass;

import java.util.List;

/**业务层接口*/
public interface A_KechengclassService {

    void setKechengclassInfo(A_Kechengclass aKechengclass, Integer teacher_id, Integer kecheng_id);

    A_Kechengclass find(Integer Kechengclass_id);

    List<A_Kechengclass> findbyteacher_id(Integer teacher_id);

    List<A_Kechengclass> findbykecheng_id(Integer kecheng_id);


}
