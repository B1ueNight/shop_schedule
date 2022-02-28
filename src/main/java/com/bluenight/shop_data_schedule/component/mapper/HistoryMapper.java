package com.bluenight.shop_data_schedule.component.mapper;

import java.util.Date;
import java.util.List;

import com.bluenight.shop_data_schedule.component.data.PageConnVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {
    List<PageConnVO> selectPageConnHistory(Date start_dt, Date end_dt);
}
