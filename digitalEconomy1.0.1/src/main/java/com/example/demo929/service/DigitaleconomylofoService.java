package com.example.demo929.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface DigitaleconomylofoService {
    Map<String, Object> getEconomyValue();
    Object getEconomyBackgroundValue();
    Map<String, Object> getEconomyValue2();
}
