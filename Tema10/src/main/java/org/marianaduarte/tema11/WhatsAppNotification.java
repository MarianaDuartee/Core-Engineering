package org.marianaduarte.tema11;

public class WhatsAppNotification implements Notification{
    @Override
    public String notifyUser() {
        return "Enviando uma notificação do WhatsApp";
    }
}
