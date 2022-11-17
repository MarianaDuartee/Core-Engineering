package org.marianaduarte.tema15;

public class WhatsappNotification extends NotificationHandler{
    public WhatsappNotification(NotificationHandler next){
        super(next);
    }
    @Override
    public String notificationRequest(Request request) {
        if(RequestType.WHATSAPP.equals(request.getType())){
            return "Notificação de WhatsApp: "+request.getMsg();
        }
        return addNext(request);
    }
}
