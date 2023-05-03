package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Collect;
import com.yhy.huaman.entity.A_keywords;

import java.util.List;

public interface A_KeywordsMapper {


    Integer insert(A_keywords aKeyword);


    List<A_keywords> findbykechengclass_id(Integer kechengclass_id);


}
