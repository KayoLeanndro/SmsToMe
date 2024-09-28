package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.SmsRequest;

@Service
public class TwilioSmsSenderService {
    
    private final TwilioSmsSender twilioSmsSender;

    public TwilioSmsSenderService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        twilioSmsSender.sendSms(smsRequest);
    }
    
}
