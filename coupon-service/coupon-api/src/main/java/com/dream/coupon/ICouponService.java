package com.dream.coupon;


import com.dream.coupon.dto.CouponListResponse;
import com.dream.coupon.dto.CouponRequest;
import com.dream.coupon.dto.CouponResponse;

public interface ICouponService {
    
    CouponResponse couponById(CouponRequest request);

    CouponListResponse coupons();
}
