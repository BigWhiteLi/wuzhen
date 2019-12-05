package com.example.demo929.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseObject implements Serializable {
    long resultTime;
    String resultCode;
    String resultMsg;
    Object data;
}
