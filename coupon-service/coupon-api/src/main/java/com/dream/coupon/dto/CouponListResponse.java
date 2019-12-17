/**
 * @program dream
 * @description: 用户列表包装返回
 * @author: mf
 * @create: 2019/12/16 22:45
 */

package com.dream.coupon.dto;

import com.dream.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class CouponListResponse extends AbstractResponse {

    private List<CouponDto> CouponDtos;
}
