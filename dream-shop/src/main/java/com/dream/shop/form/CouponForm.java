/**
 * @program dream
 * @description: 优惠券form信息
 * @author: mf
 * @create: 2019/12/18 22:01
 */

package com.dream.shop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel
public class CouponForm {

    @ApiModelProperty(name = "picUrl", value = "图片路径", example = "/10.png")
    private String picUrl;

    @ApiModelProperty(name = "achieveAmount", value = "达到满减金额", example = "100")
    private Integer achieveAmount;

    @ApiModelProperty(name = "reduceAmount", value = "满减金额", example = "50")
    private Integer reduceAmount;

    @ApiModelProperty(name = "stock", value = "库存", example = "100")
    private Integer stock;

    @ApiModelProperty(name = "title", value = "标题", example = "满100减50")
    private String title;

    @ApiModelProperty(name = "status", value = "状态", example = "0")
    private String status;

    @ApiModelProperty(name = "startTime", value = "生效时间", example = "2019-12-12 00:00:00")
    private String startTime;

    @ApiModelProperty(name = "endTime", value = "结束时间", example = "2020-12-12 00:00:00")
    private String endTime;
}
