package org.marianaduarte.tema15;

public class Main {

    public static void main(String[] args) {
       NotificationHandler emailNotification = new EmailNotification(null);
       NotificationHandler smsNotification = new SmsNotification(emailNotification);
       NotificationHandler whatsappNotification = new WhatsappNotification(smsNotification);

       Request email = new Request("1º Notificação",RequestType.EMAIL);
       Request sms = new Request("2º Notificação",RequestType.SMS);
       Request wpp = new Request("3º Notificação",RequestType.WHATSAPP);

       System.out.println(emailNotification.notificationRequest(email));
       System.out.println(smsNotification.notificationRequest(sms));
       System.out.println(whatsappNotification.notificationRequest(wpp));

    }
}