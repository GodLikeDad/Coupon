/**
 * @program dream
 * @description: 包装user
 * @author: mf
 * @create: 2019/12/16 00:12
 */

package com.dream.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CouponDto implements Serializable{

    private Integer id;

    private String code;

    private String picUrl;

    private Integer achieveAmount;

    private Integer reduceAmount;

    private Integer stock;

    private String title;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
