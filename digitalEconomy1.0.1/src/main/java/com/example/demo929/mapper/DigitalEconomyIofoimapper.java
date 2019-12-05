package com.example.demo929.mapper;

import com.example.demo929.entity.DigitalEconomyBackgroundInfo;
import com.example.demo929.entity.DigitalEconomyIndustryInfo;
import com.example.demo929.entity.DigitaleconomyIofo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DigitalEconomyIofoimapper {
    List<DigitaleconomyIofo> findEconomyValue();
    List<DigitalEconomyBackgroundInfo> findEconomyBackgroundValue();
    List<DigitalEconomyIndustryInfo> findDigitalEconomyIndustryValue();
}
