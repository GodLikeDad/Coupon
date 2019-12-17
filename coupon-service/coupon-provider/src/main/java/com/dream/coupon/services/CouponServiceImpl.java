/**
 * @program dream
 * @description: 用户服务
 * @author: mf
 * @create: 2019/12/14 01:22
 */

package com.dream.coupon.services;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.coupon.ICouponService;
import com.dream.coupon.constatns.CouponRetCodeConstants;
import com.dream.coupon.converter.CouponConverter;
import com.dream.coupon.dal.bean.Coupon;
import com.dream.coupon.dal.mapper.CouponMapper;
import com.dream.coupon.dto.CouponListResponse;
import com.dream.coupon.dto.CouponRequest;
import com.dream.coupon.dto.CouponResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
            couponResponse.setCouponDto(couponConverter.coupon2Res(coupon));
            couponResponse.setCode(CouponRetCodeConstants.SUCCESS.getCode());
            couponResponse.setMsg(CouponRetCodeConstants.SUCCESS.getMessage());

        } catch (Exception e) {
            System.out.println("错误日志...暂时还没写" + e);
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
            System.out.println("错误日志...暂时还没写" + e);
        }
        return couponListResponse;
    }
}
