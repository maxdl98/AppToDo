package com.example.demo.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class SmsService {

    @Value("${TWILIO_ACCOUNT_SID}")
    String  ACCOUNT_SID;



    @Value("${TWILIO_AUTH_TOKEN}")
    String  AUTH_TOKEN;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String  TWILIO_OUTGOING_SMS_NUMBER;



    @PostConstruct
    private void setUp() {
        System.out.println("ACCOUNT-SID: " + ACCOUNT_SID);
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);

    }

    public String sendSMS(String numero, String smsMessage){

        Message message = Message.creator(
                new PhoneNumber(numero),
                new PhoneNumber(TWILIO_OUTGOING_SMS_NUMBER),
                smsMessage                               // Contenuto SMS
        ).create();


        return message.getStatus().toString();
    }

}
