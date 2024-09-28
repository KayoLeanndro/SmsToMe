package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SmsRequest;
import com.example.demo.service.TwilioSmsSenderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/sms")
public class SmsSenderController {
    private final TwilioSmsSenderService twilioSmsSenderService;

    @Autowired
    public SmsSenderController(TwilioSmsSenderService twilioSmsSenderService) {
        this.twilioSmsSenderService = twilioSmsSenderService;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        twilioSmsSenderService.sendSms(smsRequest);
    }

}
