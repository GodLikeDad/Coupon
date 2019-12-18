package com.dream.coupon.converter;

import com.dream.coupon.dal.bean.Coupon;
import com.dream.coupon.dto.AddCouponRequest;
import com.dream.coupon.dto.CouponDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CouponConverter {

    @Mappings({})
    CouponDto coupon2Res(Coupon coupon);

    @Mappings({
            @Mapping(source = "picUrl", target = "picUrl")
    })
    Coupon Res2Coupon(AddCouponRequest request);

    @Mappings({})
    List<CouponDto> coupon2List(List<Coupon> coupons);
}
