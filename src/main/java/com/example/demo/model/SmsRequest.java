package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class SmsRequest {

    @NotBlank
    private final String phoneNumber;

    @NotBlank
    private final String UserSender;

    @NotBlank
    private final String message;

    public SmsRequest(
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("message") String message,
            @JsonProperty("userSender") String UserSender) {
        this.phoneNumber = phoneNumber;
        this.UserSender = UserSender;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getUserSender() {
        return UserSender;
    }

    @Override
    public String toString() {
        return "SmsRequest [phoneNumber=" 
        + phoneNumber 
        + ", UserSender=" 
        + UserSender 
        + ", message=" 
        + message 
        + "]";
    }

    
}
