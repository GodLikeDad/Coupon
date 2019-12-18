/**
 * @program dream
 * @description: 用户服务
 * @author: mf
 * @create: 2019/12/14 01:22
 */

package com.dream.coupon.services;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.commons.tool.util.UtilDate;
import com.dream.coupon.ICouponService;
import com.dream.coupon.constatns.CouponRetCodeConstants;
import com.dream.coupon.converter.CouponConverter;
import com.dream.coupon.dal.bean.Coupon;
import com.dream.coupon.dal.mapper.CouponMapper;
import com.dream.coupon.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@Service
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CouponConverter couponConverter;


    /**
     * 根据用户id返回用户信息
     * @param request
     * @return
     */
    @Override
    public CouponResponse couponById(CouponRequest request) {
        CouponResponse couponResponse = new CouponResponse();
        try {
            Coupon coupon = couponMapper.selectById(request.getId());
            if (coupon == null) {
                couponResponse.setCode(CouponRetCodeConstants.DATA_NOT_EXIST.getCode());
                couponResponse.setMsg(CouponRetCodeConstants.DATA_NOT_EXIST.getMessage());
            }
            log.warn(coupon.toString());
            couponResponse.setCouponDto(couponConverter.coupon2Res(coupon));
            couponResponse.setCode(CouponRetCodeConstants.SUCCESS.getCode());
            couponResponse.setMsg(CouponRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("couponById" + e.toString());
            couponResponse.setCode(CouponRetCodeConstants.SYSTEM_ERROR.getCode());
            couponResponse.setMsg(CouponRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
        return couponResponse;
    }

    @Override
    public CouponListResponse coupons() {
        CouponListResponse couponListResponse = new CouponListResponse();
        try {
            List<Coupon> coupons = couponMapper.selectList(new QueryWrapper<Coupon>());
            if (coupons == null || coupons.size() == 0) {
                couponListResponse.setCode(CouponRetCodeConstants.DATA_NOT_EXIST.getCode());
                couponListResponse.setMsg(CouponRetCodeConstants.DATA_NOT_EXIST.getMessage());
            }
            couponListResponse.setCouponDtos(couponConverter.coupon2List(coupons));
            couponListResponse.setCode(CouponRetCodeConstants.SUCCESS.getCode());
            couponListResponse.setMsg(CouponRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("coupons -> error" + e.toString());
            couponListResponse.setCode(CouponRetCodeConstants.SYSTEM_ERROR.getCode());
            couponListResponse.setMsg(CouponRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
        return couponListResponse;
    }

    /**
     * 添加优惠券
     * @param request
     * @return
     */
    @Override
    public AddCouponResponse addCoupon(AddCouponRequest request) {
        AddCouponResponse addCouponResponse = new AddCouponResponse();
        try {
            // 每个优惠券是唯一的，因为优惠券码是唯一的，暂时使用uuid来生成
            // 所以这边就不进行去库里寻找
            Coupon coupon = couponConverter.Res2Coupon(request);
            System.out.println(coupon.toString());
            // 暂时随机设置UUID吧，之后会用雪花算法
            coupon.setCode(UUID.randomUUID().toString());
            // 创建时间
            coupon.setCreateTime(UtilDate.dateToLocalDateTime(new Date()));
            couponMapper.insert(coupon);
            log.warn(coupon.toString());
            addCouponResponse.setCouponDto(couponConverter.coupon2Res(coupon));
            addCouponResponse.setCode(CouponRetCodeConstants.SUCCESS.getCode());
            addCouponResponse.setMsg(CouponRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("addCoupon -> error" + e);
            addCouponResponse.setCode(CouponRetCodeConstants.SYSTEM_ERROR.getCode());
            addCouponResponse.setMsg(CouponRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
        return addCouponResponse;
    }
}
