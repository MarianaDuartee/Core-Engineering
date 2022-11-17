package org.marianaduarte.tema15;

public class EmailNotification extends NotificationHandler{

    public EmailNotification(NotificationHandler next){
        super(next);
    }

    @Override
    public String notificationRequest(Request request) {
        if(RequestType.EMAIL.equals(request.getType())) {
            return "Notificação de Email: "+request.getMsg();
        }
        return addNext(request);
    }
}
