package org.marianaduarte.tema15;

import java.util.Objects;

public abstract class NotificationHandler {
    protected NotificationHandler next;


    public NotificationHandler(NotificationHandler next){
        this.next = next;
    }

    public abstract String notificationRequest(Request request);

    public String addNext(Request request){
        if(Objects.nonNull(this.next)){
            return this.next.notificationRequest(request);
        }
        return "A proxima notificação não pode ser nula";
    }

}
