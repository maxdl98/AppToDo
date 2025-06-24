package com.example.demo.service;

public class SmsSent {

    private String destinationSmsNumero;

    private String smsMessage;

    public SmsSent(){}

    public SmsSent(String destinationSmsNumero, String smsMessage) {
        this.destinationSmsNumero = destinationSmsNumero;
        this.smsMessage = smsMessage;
    }

    public String getDestinationSmsNumero() {
        return destinationSmsNumero;
    }

    public void setDestinationSmsNumero(String destinationSmsNumero) {
        this.destinationSmsNumero = destinationSmsNumero;
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }
}
