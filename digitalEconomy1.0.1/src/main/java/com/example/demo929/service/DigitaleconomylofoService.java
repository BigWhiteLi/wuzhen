package com.example.demo929.service;

import com.example.demo929.entity.DigitaleconomyIofo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface DigitaleconomylofoService {
    Map<String, Object> getEconomyValue();
    Object getEconomyBackgroundValue();
    Map<String, Object> getEconomyValue2();
}
