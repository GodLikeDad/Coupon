package com.dream.dshop.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * t_user_coupon 用户优惠券表
 * </p>
 *
 * @author mf
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_coupon")
public class UserCoupon implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * user_coupon_code 用户优惠券码
     */
    private String userCouponCode;

    /**
     * pic_url 优惠券图
     */
    private String picUrl;

    /**
     * coupon_id t_coupon表的虚拟外键
     */
    private Integer couponId;

    /**
     * user_id 所领取用户id
     */
    private Integer userId;

    /**
     * order_id 对应t_order表外键
     */
    private Integer orderId;

    /**
     * status 状态，为0可用，否则不可用
     */
    private String status;

    /**
     * create_time 日期
     */
    private LocalDateTime createTime;

    /**
     * start_time 生效开始时间
     */
    private LocalDateTime startTime;

    /**
     * end_time 生效结束时间
     */
    private LocalDateTime endTime;


}
