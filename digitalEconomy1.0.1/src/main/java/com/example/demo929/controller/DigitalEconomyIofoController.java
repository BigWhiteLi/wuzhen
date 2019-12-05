package com.example.demo929.controller;

import com.example.demo929.common.ResponseObject;
import com.example.demo929.service.DigitaleconomylofoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
@Api(tags = "Restful API示例", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping("/v1/wuzhen")
public class DigitalEconomyIofoController {
    @Autowired
    DigitaleconomylofoService digitaleconomylofoService;
    @ApiOperation(value = "智慧经济1屏6个图表数据",notes = "获取智慧经济1屏6个图表数据")
    @GetMapping("/economy/interface1/chart")
    public ResponseObject reBackEconomyValue() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setResultTime((System.currentTimeMillis()) / 1000);
        responseObject.setResultCode("0");
        responseObject.setResultMsg("server is success!");
        Map<String, Object> data = digitaleconomylofoService.getEconomyValue();
        responseObject.setData(data);
        return responseObject;
    }

    @ApiOperation(value = "智慧经济村庄企业数量、人均收入数据", notes = "获取智慧经济村庄企业数量、人均收入数据")
    @GetMapping("/economy/interface/map")
    public ResponseObject reBackEconomyBackgroundValue() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setResultTime((System.currentTimeMillis()) / 1000);
        responseObject.setResultCode("0");
        responseObject.setResultMsg("server is success!");
        Object data = digitaleconomylofoService.getEconomyBackgroundValue();
        responseObject.setData(data);
        return responseObject;
    }

    @ApiOperation(value = "智慧经济2屏6个图表数据", notes = "获取智慧经济2屏6个图表数据")
    @GetMapping("/economy/interface2/chart")
    public ResponseObject reBackDigitalEconomyIndustryValue() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setResultTime((System.currentTimeMillis()) / 1000);
        responseObject.setResultCode("0");
        responseObject.setResultMsg("server is success!");
        Object data = digitaleconomylofoService.getEconomyValue2();
        responseObject.setData(data);
        return responseObject;
    }

}
