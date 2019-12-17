/**
 * @program dream
 * @description: 用户返回包装
 * @author: mf
 * @create: 2019/12/16 00:22
 */

package com.dream.coupon.dto;

import com.dream.commons.result.AbstractResponse;
import lombok.Data;

import java.io.Serializable;

@Data
public class CouponResponse extends  AbstractResponse{

    /**
     * 封装可返回用户信息
     */
    private CouponDto couponDto;


}
