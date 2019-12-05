package com.example.demo929.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class DigitalEconomyIndustryInfo {
    private int ctime;//年份

    private int industryOne;//第一产业投资
    private int industryTwo;//第二产业投资
    private int industryThree;//第三产业投资

    private int textile;//纺织加工
    private int clothManufacture;//服装制造
    private int agricultural;//农副食品加功
    private int electronic;//电子元器件制造
    private int canManufacture;//罐头食品制造

    private int technologyPerson;//R&D人员
    private int technologyFund;//R&D经费支出
}
