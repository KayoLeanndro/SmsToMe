package com.example.demo.interfaces;

import com.example.demo.model.SmsRequest;

public interface ISmsSender {
    void sendSms(SmsRequest smsRequest);
}
