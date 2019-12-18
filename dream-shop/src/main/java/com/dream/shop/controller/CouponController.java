/**
 * @program dream
 * @description: 优惠券控制器
 * @author: mf
 * @create: 2019/12/18 19:28
 */

package com.dream.shop.controller;

import com.dream.commons.result.ResponseData;
import com.dream.commons.result.ResponseUtil;
import com.dream.coupon.ICouponService;
import com.dream.coupon.constatns.CouponRetCodeConstants;
import com.dream.coupon.dto.CouponListResponse;
import com.dream.coupon.dto.CouponRequest;
import com.dream.coupon.dto.CouponResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "CouponController", description = "优惠券控制器")
public class CouponController {

    @Reference
    private ICouponService couponService;

    /**
     * 根据id查询优惠券信息
     * @param id
     * @return
     */
    @ApiOperation("根据id获取优惠券")
    @GetMapping("/coupon/{id}")
    @ApiImplicitParam(name = "id", value = "优惠券id", paramType = "path", required = true)
    public ResponseData searchCouponByd(@PathVariable(name = "id")Integer id) {
        CouponRequest req = new CouponRequest();
        req.setId(id);
        CouponResponse res = couponService.couponById(req);
        if (!res.getCode().equals(CouponRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil<Object>().setErrorMsg(res.getMsg());
        }
        return new ResponseUtil<Object>().setData(res);
    }

    @ApiOperation("获取全部优惠券")
    @GetMapping("/coupons")
    public ResponseData getCoupons() {
        CouponListResponse res = couponService.coupons();
        if (!res.getCode().equals(CouponRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil<Object>().setErrorMsg(res.getMsg());
        }
        return new ResponseUtil<Object>().setData(res);
    }
}
