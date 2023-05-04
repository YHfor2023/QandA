package com.yhy.huaman.mapper;

import com.yhy.huaman.entity.A_Keywords;

import java.util.List;

public interface A_KeywordsMapper {


    Integer insert(A_Keywords aKeyword);


    List<A_Keywords> findbykechengclass_id(Integer kechengclass_id);


}
