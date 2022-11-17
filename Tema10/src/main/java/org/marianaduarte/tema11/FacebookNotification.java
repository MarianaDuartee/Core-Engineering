package org.marianaduarte.tema11;

public class FacebookNotification implements Notification{
    @Override
    public String notifyUser() {
        return "Enviando uma notificação do Facebook";
    }
}
