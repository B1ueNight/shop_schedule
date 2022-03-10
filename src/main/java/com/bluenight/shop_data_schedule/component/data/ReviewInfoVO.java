package com.bluenight.shop_data_schedule.component.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class ReviewInfoVO {
    private Integer ri_mi_seq;
    private Integer ri_pi_seq;
    private Integer ri_score;
    private Integer ri_oi_seq;
    private Date ri_mod_dt;
    private Integer ri_status;
    private Integer ri_report_cnt;

    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return ri_mi_seq+","+ri_pi_seq+","+ri_score+","+ri_status+","+ri_report_cnt+","+formatter.format(ri_mod_dt);
    } 
}
