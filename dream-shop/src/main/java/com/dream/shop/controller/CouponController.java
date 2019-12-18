/**
 * @program dream
 * @description: 优惠券控制器
 * @author: mf
 * @create: 2019/12/18 19:28
 */

package com.dream.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.commons.result.ResponseData;
import com.dream.commons.result.ResponseUtil;
import com.dream.commons.tool.util.UtilDate;
import com.dream.coupon.ICouponService;
import com.dream.coupon.constatns.CouponRetCodeConstants;
import com.dream.coupon.dto.*;
import com.dream.shop.form.CouponForm;
import com.dream.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @ApiOperation("添加优惠券")
    @PostMapping("/coupon")
    @ApiImplicitParam(name = "form", value = "优惠券信息", dataType = "CouponForm", required = true)
    public ResponseData addCoupon(@RequestBody CouponForm form) {
        log.warn(form.toString());
        AddCouponRequest request = new AddCouponRequest();
        request.setPicUrl(form.getPicUrl());
        request.setAchieveAmount(form.getAchieveAmount());
        request.setReduceAmount(form.getReduceAmount());
        request.setStock(form.getStock());
        request.setTitle(form.getTitle());
        request.setStatus(form.getStatus());
        request.setStartTime(UtilDate.localDateTimeParse(form.getStartTime(), UtilDate.FORMAT_PATTERN1));
        request.setEndTime(UtilDate.localDateTimeParse(form.getEndTime(), UtilDate.FORMAT_PATTERN1));

        log.warn(request.toString());
        AddCouponResponse addCouponResponse = couponService.addCoupon(request);
        if (addCouponResponse.getCode().equals(CouponRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil<Object>().setData(addCouponResponse.getMsg());
        }
        return new ResponseUtil<Object>().setErrorMsg(addCouponResponse.getMsg());
    }
}
