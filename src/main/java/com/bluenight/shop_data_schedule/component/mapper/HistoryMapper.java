package com.bluenight.shop_data_schedule.component.mapper;

import java.util.Date;
import java.util.List;

import com.bluenight.shop_data_schedule.component.data.MemberInfoVO;
import com.bluenight.shop_data_schedule.component.data.MemberProdVO;
import com.bluenight.shop_data_schedule.component.data.PageConnVO;
import com.bluenight.shop_data_schedule.component.data.ProductInfoVO;
import com.bluenight.shop_data_schedule.component.data.ReviewInfoVO;
import com.bluenight.shop_data_schedule.component.data.ShoppingRecordVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {
    List<PageConnVO> selectPageConnHistory(Date start_dt, Date end_dt);
    List<MemberProdVO> selectMemberProdHistory(Date start_dt, Date end_dt);
    List<ReviewInfoVO> selectReviewInfo(Date start_dt, Date end_dt);
    List<ShoppingRecordVO> selectShoppingRecored(Date start_dt, Date end_dt, Integer status);

    List<MemberInfoVO> selectMemberInfo(Date start_dt, Date end_dt);
    List<ProductInfoVO> selectProductInfo(Date start_dt, Date end_dt);
}
