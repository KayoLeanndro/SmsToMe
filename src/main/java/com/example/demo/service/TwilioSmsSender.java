package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SmsRequest;
import com.example.demo.configuration.TwilioConfiguration;
import com.example.demo.interfaces.ISmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSender implements ISmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (!isPhoneValid(smsRequest.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone: " + smsRequest.getPhoneNumber() + " is not valid");
        }
        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());

        String UserSender = smsRequest.getUserSender();

        String message = smsRequest.getMessage() + "\n\nFrom: " + UserSender;

        MessageCreator creator = Message.creator(to, from, message);
        creator.create();
        LOGGER.info("SMS sent: " + smsRequest);
    }

    public boolean isPhoneValid(String PhoneNumber) {
        String phoneNumberRegex = "^\\+?[0-9. ()-]{7,15}$"; 
        return PhoneNumber != null && PhoneNumber.matches(phoneNumberRegex);    
    }
}
