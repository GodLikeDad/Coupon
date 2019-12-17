/**
 * @program dream
 * @description: CouponMapper测试
 * @author: mf
 * @create: 2019/12/14 01:02
 */

package com.dream.coupon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.coupon.dal.bean.Coupon;
import com.dream.coupon.dal.mapper.CouponMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponMapperTest {

    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void testAllCoupons() {
        List<Coupon> coupons = couponMapper.selectList(new QueryWrapper<Coupon>());
        for (Coupon coupon : coupons) {
            System.out.println(coupon);
        }
    }
}
