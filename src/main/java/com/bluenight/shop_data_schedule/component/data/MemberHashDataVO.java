package com.bluenight.shop_data_schedule.component.data;

import lombok.Data;

@Data
public class MemberHashDataVO {
    private Integer mhd_seq;
    private String mhd_email;
    private String mhd_hash;
    private Integer mhd_mi_seq;
}
