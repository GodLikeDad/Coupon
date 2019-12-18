/**
 * @program dream
 * @description: 添加优惠券请求封装
 * @author: mf
 * @create: 2019/12/18 19:52
 */

package com.dream.coupon.dto;

import com.dream.commons.result.AbstractRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddCouponRequest extends AbstractRequest {

    private String picUrl;

    private Integer achieveAmount;

    private Integer reduceAmount;

    private Integer stock;

    private String title;

    private String status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Override
    public void requestCheck() {

    }
}
