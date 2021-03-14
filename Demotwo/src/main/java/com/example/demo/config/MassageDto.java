package com.example.demo.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MassageDto {
   private String id;
   private String massage;
   private Long timeRequest;
   private Long timeResponse;
}

