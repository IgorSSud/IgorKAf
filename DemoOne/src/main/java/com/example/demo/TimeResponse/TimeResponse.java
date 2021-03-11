package com.example.demo.TimeResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class TimeResponse {

static Long RequestTime;
static Long ResponseTime;
    public static Long getResultResponseTime(Long request,Long response){
        return request-response;
    }

    public static Long getRequestTime() {
        return RequestTime;
    }

    public static void setRequestTime(Long requestTime) {
        RequestTime = requestTime;
    }

    public static Long getResponseTime() {
        return ResponseTime;
    }

    public static void setResponseTime(Long responseTime) {
        ResponseTime = responseTime;
    }
}
