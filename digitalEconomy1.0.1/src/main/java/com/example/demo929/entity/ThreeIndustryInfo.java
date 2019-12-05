package com.example.demo929.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class ThreeIndustryInfo {
    @ApiModelProperty("产业类型")
    private String typeInfo;
    @ApiModelProperty("产业占比")
    private double value;
}
