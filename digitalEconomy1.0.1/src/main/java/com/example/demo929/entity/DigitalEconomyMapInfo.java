package com.example.demo929.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class DigitalEconomyMapInfo {
    @ApiModelProperty("村庄名称")
    private String ruralName;
    @ApiModelProperty("村庄人均收入")
    private int ruralPerIncome;
   // private int ruralPopulation;//村庄人数
    @ApiModelProperty("村庄企业数量")
    private int enterprises;
    //private double lng;
   // private double lat;//存在精度丢失
    @ApiModelProperty("经度")
    private BigDecimal lng;
    @ApiModelProperty("纬度")
    private BigDecimal lat;

}
