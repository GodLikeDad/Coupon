package com.dream.coupon;


import com.dream.coupon.dto.*;

public interface ICouponService {

    /**
     * 通过id获取优惠券
     * @param request
     * @return
     */
    CouponResponse couponById(CouponRequest request);

    /**
     * 返回全部优惠券
     * @return
     */
    CouponListResponse coupons();

    /**
     * 添加优惠券
     * @param request
     * @return
     */
    AddCouponResponse addCoupon(AddCouponRequest request);
}
