package com.example.demo929.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class DigitalEconomyInfo {
    @JsonIgnore
    private long id;
    private int ctime;
    ///private int digitaleconomySum;//数字经济总数
    ///private int digitaleconomyRatio;//数字经济占gdp总数
    private int patentApplication;
    private int patentAuthorization;
    private int broadbandAccess;
    private int baseStation;

}
