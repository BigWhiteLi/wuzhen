package com.example.demo929.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo929.common.utils.RedisUtil;
import com.example.demo929.entity.*;
import com.example.demo929.mapper.DigitalEconomyInfoMapper;
import com.example.demo929.service.DigitaleconomylofoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service("DigitaleconomylofoService")
@Service
public class DigitaleconomylofoServiceImpl implements DigitaleconomylofoService {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    DigitalEconomyInfoMapper digitalEconomyInfoMapper;
//智慧经济第一屏
    @Override
    public Map<String, Object> getEconomyValue() {
        List<DigitalEconomyInfo> digitalEconomyInfoList;
        digitalEconomyInfoList = digitalEconomyInfoMapper.findEconomyValue();
        System.out.println("patent=" + digitalEconomyInfoList);

        List<Map<String, Object>> patentList = new ArrayList<>();
        List<Map<String, Object>> baseStationBroadbandList = new ArrayList<>();
        for (DigitalEconomyInfo digitalEconomyInfo : digitalEconomyInfoList) {
            Map<String, Object> patentMap = new HashMap<>();
            patentMap.put("ctime", digitalEconomyInfo.getCtime());
            patentMap.put("patentApplication", digitalEconomyInfo.getPatentApplication());
            patentMap.put("patentAuthorization", digitalEconomyInfo.getPatentAuthorization());
            patentList.add(patentMap);

            Map<String, Object> map = new HashMap<>();
            map.put("ctime", digitalEconomyInfo.getCtime());
            map.put("broadbandAccess", digitalEconomyInfo.getBroadbandAccess());
            map.put("baseStation", digitalEconomyInfo.getBaseStation());
            baseStationBroadbandList.add(map);
        }


        Map<String, Object> digitalEconomyData = new HashMap<>();
        digitalEconomyData.put("patent", patentList);
        digitalEconomyData.put("infrastructure", baseStationBroadbandList);
        Map<Object, Object> redisDataMap = redisUtil.hmget("digitalEconomyData");
        for (Map.Entry<Object, Object> entry : redisDataMap.entrySet()) {
            if (entry.getKey().toString().equals("itIndustry")) {
                digitalEconomyData.put("itIndustry", entry.getValue());
            }
            if (entry.getKey().toString().equals("innovate")) {
                digitalEconomyData.put("innovate", entry.getValue());
            }
            if (entry.getKey().toString().equals("influence")) {
                digitalEconomyData.put("influence", entry.getValue());
            }
            if (entry.getKey().toString().equals("digitalEconomy")) {
                digitalEconomyData.put("digitalEconomy", entry.getValue());
            }
        }
        return digitalEconomyData;
    }
//智慧经济中间地图数据
    @Override
    public List<Map<String, Object>>  getEconomyBackgroundValue() {
        List<DigitalEconomyMapInfo> digitalEconomyMapInfoList;
        List<Map<String, Object>> governanceOverviewList = new ArrayList<>();
        digitalEconomyMapInfoList = digitalEconomyInfoMapper.findEconomyBackgroundValue();//将数据库返回的数据存到List中

        for (DigitalEconomyMapInfo digitalEconomyMapInfo : digitalEconomyMapInfoList) {
            System.out.println("test1");
            Map<String, Object> gdpIncomeMap = new HashMap<>();
            gdpIncomeMap.put("ruralName", digitalEconomyMapInfo.getRuralName());
            gdpIncomeMap.put("enterprises", digitalEconomyMapInfo.getEnterprises());
            gdpIncomeMap.put("ruralPerIncome", digitalEconomyMapInfo.getRuralPerIncome());
           gdpIncomeMap.put("lng", digitalEconomyMapInfo.getLng());
           gdpIncomeMap.put("lat", digitalEconomyMapInfo.getLat());
            governanceOverviewList.add(gdpIncomeMap);
        }
        return governanceOverviewList;
    }
//智慧经济第二屏
    @Override
    public Map<String, Object> getEconomyValue2() {
        Map<String, Object> dataMap = new HashMap<>();
        List<DigitalEconomyIndustryInfo> digitalEconomyIndustryInfoList;
        digitalEconomyIndustryInfoList = digitalEconomyInfoMapper.findDigitalEconomyIndustryValue();
        List<Map<String, Object>> investmentList = new ArrayList<>();
        List<Map<String, Object>> industryList = new ArrayList<>();
        List<Map<String, Object>> technologyList = new ArrayList<>();
        int ctime;
        for (DigitalEconomyIndustryInfo digitalEconomyIndustryInfo : digitalEconomyIndustryInfoList) {
            ctime = digitalEconomyIndustryInfo.getCtime();

            Map<String, Object> investmentListMap = new HashMap<>();
            investmentListMap.put("ctime", ctime);
            investmentListMap.put("industryOne", digitalEconomyIndustryInfo.getIndustryOne());
            investmentListMap.put("industryTwo", digitalEconomyIndustryInfo.getIndustryTwo());
            investmentListMap.put("industryThree", digitalEconomyIndustryInfo.getIndustryThree());
            investmentList.add(investmentListMap);

            Map<String, Object> industryMap = new HashMap<>();
            industryMap.put("ctime", ctime);
            industryMap.put("textile", digitalEconomyIndustryInfo.getTextile());
            industryMap.put("clothManufacture", digitalEconomyIndustryInfo.getClothManufacture());
            industryMap.put("agricultural", digitalEconomyIndustryInfo.getAgricultural());
            industryMap.put("electronic", digitalEconomyIndustryInfo.getElectronic());
            industryMap.put("canManufacture", digitalEconomyIndustryInfo.getCanManufacture());
            industryList.add(industryMap);

            Map<String, Object> technologyMap = new HashMap<>();
            technologyMap.put("ctime", ctime);
            technologyMap.put("technologyPerson", digitalEconomyIndustryInfo.getTechnologyPerson());
            technologyMap.put("technologyFund", digitalEconomyIndustryInfo.getTechnologyFund());
            technologyList.add(technologyMap);
        }
        dataMap.put("investment",investmentList);
        dataMap.put("industry",industryList);
        dataMap.put("technology",technologyList);

        String redisDataMap1 = redisUtil.hget("digitalEconomyData","agriculture").toString();
        List<EconomyAgricultureInfo> heatMapInfo1 = JSONObject.parseArray(redisDataMap1,EconomyAgricultureInfo.class);
        dataMap.put("agriculture",heatMapInfo1);

        String redisDataMap2 = redisUtil.hget("digitalEconomyData","service").toString();
        List<ThreeIndustryInfo> heatMapInfo2 = JSONObject.parseArray(redisDataMap2,ThreeIndustryInfo.class);
        dataMap.put("service",heatMapInfo2);

        String redisDataMap3 = redisUtil.hget("digitalEconomyData","threeIndustry").toString();
        List<ThreeIndustryInfo> heatMapInfo3 = JSONObject.parseArray(redisDataMap3,ThreeIndustryInfo.class);
        dataMap.put("threeIndustry",heatMapInfo3);
        return dataMap;
 /*
        //获取redis中的数据，方式一
        Map<Object, Object> redisDataMap = redisUtil.hmget("digitalEconomyData");
        for (Map.Entry<Object, Object> entry : redisDataMap.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
            if (entry.getKey().toString().equals("agriculture")) {
                dataMap.put("agriculture", entry.getValue());///信息产业
            }
            if (entry.getKey().toString().equals("service")) {
                dataMap.put("service", entry.getValue());///科技创新（创新）
            }
          //  if (entry.getKey().toString().equals("threeIndustry")) {
            //    dataMap.put("threeIndustry", entry.getValue());///影响因素
            //}
        }
  */
    }
}
