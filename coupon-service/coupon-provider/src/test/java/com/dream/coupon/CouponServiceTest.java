/**
 * @program dream
 * @description: 用户服务测试
 * @author: mf
 * @create: 2019/12/14 01:26
 */

package com.dream.coupon;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.commons.tool.util.UtilDate;
import com.dream.coupon.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.rmi.CORBA.Util;
import java.util.Date;

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

    @Test
    public void addCoupon() {
        AddCouponRequest req = new AddCouponRequest();
        req.setAchieveAmount(400);
        req.setReduceAmount(100);
        req.setStock(2000);
        req.setTitle("满400减100");
        req.setStartTime(UtilDate.dateToLocalDateTime(new Date()));
        req.setEndTime(UtilDate.localDateTimeParse("2020-12-12 00:00:00", UtilDate.FORMAT_PATTERN1));
        AddCouponResponse addCouponResponse = couponService.addCoupon(req);
        System.out.println(addCouponResponse);
    }
}
