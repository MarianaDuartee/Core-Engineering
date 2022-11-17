package org.marianaduarte.tema13;

public class SmsNotification implements Strategy{
    @Override
    public String sendNotification() {
        return "| SMS | " ;
    }
}
