package com.dream.user.dal.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * t_coupon 优惠券表
 * </p>
 *
 * @author mf
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_coupon")
public class Coupon implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * code 优惠券码
     */
    private String code;

    /**
     * pic_url 优惠券图
     */
    private String picUrl;

    /**
     * achieve_amount 达到满减资格金额
     */
    private Integer achieveAmount;

    /**
     * reduce_amount 所减金额
     */
    private Integer reduceAmount;

    /**
     * stock 库存，当库存为0不可取
     */
    private Integer stock;

    /**
     * title 优惠券名称
     */
    private String title;

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
