package org.marianaduarte.tema13;

public class Notification {
    private Strategy strategy;

    public Notification(Strategy strategy){
        this.strategy = strategy;
    }

    public String sendNotification(Client client){
        String msg = strategy.sendNotification() + Message.assembleMessage(client);
        return msg;
    }
}
