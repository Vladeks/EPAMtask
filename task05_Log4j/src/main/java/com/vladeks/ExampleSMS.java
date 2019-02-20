package com.vladeks;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class ExampleSMS {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC2067c7fdd67cc27462718d4949ed312d";
    public static final String AUTH_TOKEN = "4d18fe4a25f9e063cfe6b79c537e0cb4";

    public static void send(String str) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new PhoneNumber("+3801111111111"),
                        /*my phone number*/
                        new PhoneNumber("+19722222222222"), str).create();
        /*attached to me number*/
    }

    public static void main(String[] args) {
        ExampleSMS.send("WOW");
    }
}
