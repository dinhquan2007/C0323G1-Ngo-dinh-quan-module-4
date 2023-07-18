package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceConvert implements IServiceConvert{
    @Override
    public double ConvertUSDToVND(float usd, float rate) {
    return usd*rate;
    }
}
