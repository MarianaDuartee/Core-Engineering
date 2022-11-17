package org.marianaduarte.tema11;

public class EmailNotification implements Notification{

    @Override
    public String notifyUser() {
        return "Enviando uma notificação de Email";
    }
}
