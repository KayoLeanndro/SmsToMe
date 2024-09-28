package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@Configuration
public class TwilioInitializer {

    private final TwilioConfiguration twilioConfiguration;
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
   
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @PostConstruct
    public void initializeTwilio() {
        // Inicializa o Twilio
        Twilio.init(
            twilioConfiguration.getAccountSid(), 
            twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized with account SID: {}", twilioConfiguration.getAccountSid());
    }
}
