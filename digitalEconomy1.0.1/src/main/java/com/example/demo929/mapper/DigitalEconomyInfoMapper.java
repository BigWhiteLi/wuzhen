package com.example.demo929.mapper;

import com.example.demo929.entity.DigitalEconomyMapInfo;
import com.example.demo929.entity.DigitalEconomyIndustryInfo;
import com.example.demo929.entity.DigitalEconomyInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DigitalEconomyInfoMapper {
    List<DigitalEconomyInfo> findEconomyValue();
    List<DigitalEconomyMapInfo> findEconomyBackgroundValue();
    List<DigitalEconomyIndustryInfo> findDigitalEconomyIndustryValue();
}
