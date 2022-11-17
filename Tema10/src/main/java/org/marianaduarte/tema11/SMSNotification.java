package org.marianaduarte.tema11;

public class SMSNotification implements  Notification{

    @Override
    public String notifyUser() {
        return "Enviando uma notificação de SMS";
    }
}
