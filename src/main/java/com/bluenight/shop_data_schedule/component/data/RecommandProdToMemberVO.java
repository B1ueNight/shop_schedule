package com.bluenight.shop_data_schedule.component.data;

import java.util.Date;

import lombok.Data;

@Data
public class RecommandProdToMemberVO {
    private Integer rptm_seq;
    private String rptm_product_hash;
    private String rptm_memeber_hash;
    private Date rptm_reg_dt;
    private Double rptm_score;
}
