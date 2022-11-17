package org.marianaduarte.tema15;

public class SmsNotification extends NotificationHandler{

   public SmsNotification(NotificationHandler next){
       super(next);
   }

    @Override
    public String notificationRequest(Request request) {
        if(RequestType.SMS.equals(request.getType())) {
            return "Notificação de SMS: "+request.getMsg();
        }
        return addNext(request);
    }
}

