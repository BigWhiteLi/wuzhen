package com.example.demo929.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class EconomyAgricultureInfo {
    @ApiModelProperty("农业数据类型")
    private String typeInfo;
    @ApiModelProperty("数据值")
    private double  value;
    @ApiModelProperty("单位")
    private String unit;
}
