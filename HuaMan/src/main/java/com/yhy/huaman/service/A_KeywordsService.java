package com.yhy.huaman.service;

import com.yhy.huaman.entity.A_Keywords;

import java.util.List;

/**业务层接口*/
public interface A_KeywordsService {


    Integer insert(A_Keywords aKeyword, Integer user_id);


    List<A_Keywords> findbykechengclass_id(Integer kechengclass_id);

}
