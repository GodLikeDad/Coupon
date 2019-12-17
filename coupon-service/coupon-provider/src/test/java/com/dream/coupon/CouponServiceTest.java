/**
 * @program dream
 * @description: 用户服务测试
 * @author: mf
 * @create: 2019/12/14 01:26
 */

package com.dream.coupon;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.coupon.dto.CouponListResponse;
import com.dream.coupon.dto.CouponRequest;
import com.dream.coupon.dto.CouponResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponServiceTest {

    @Reference
    private ICouponService couponService;


    @Test
    public void testCouponById() {
        CouponRequest request = new CouponRequest();
        request.setId(1);
        CouponResponse couponResponse = couponService.couponById(request);
        System.out.println(couponResponse);
    }

    @Test
    public void testGetCoupons() {
        CouponListResponse couponListResponse = couponService.coupons();
        System.out.println(couponListResponse);
    }
}
