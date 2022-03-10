package com.bluenight.shop_data_schedule.component.mapper;

import java.util.List;

import com.bluenight.shop_data_schedule.component.data.MemberHashDataVO;
import com.bluenight.shop_data_schedule.component.data.ProductHashDataVO;
import com.bluenight.shop_data_schedule.component.data.RecommandProdToMemberVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommendMapper {
    public void insertMemberHashData(List<MemberHashDataVO> list);
    public void insertProductHashData(List<ProductHashDataVO> list);
    public void insetRecommandHashData(List<RecommandProdToMemberVO> list);
}
