package org.marianaduarte.tema11;

public class NotificationFactory {
    public Notification createNotification(String notificationType){
        if(notificationType == null){
            return null;
        }
        else if (notificationType.equalsIgnoreCase("sms")){
            return new SMSNotification();
        }
        else if (notificationType.equalsIgnoreCase("whatsapp")){
            return new WhatsAppNotification();
        }
        else if (notificationType.equalsIgnoreCase("email")){
            return new EmailNotification();
        }
        else if (notificationType.equalsIgnoreCase("instagram")){
            return new InstagramNotification();
        }
        else if (notificationType.equalsIgnoreCase("facebook")){
            return new FacebookNotification();
        }
        return null;
    }
}
