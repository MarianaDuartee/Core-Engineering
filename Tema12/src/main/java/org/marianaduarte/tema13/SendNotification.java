package org.marianaduarte.tema13;

public class SendNotification {
    private Notification notification;

    public String sendNotification(Client client) {
        if(client.getNome() == null || client.getEmail() == null || client.getTelefone() == null){
            throw  new IllegalArgumentException("ERRO! Você preencheu com campo(s) nulo(s)");
        }
        if(client.getTelefone().isBlank()){
            notification = new Notification(new EmailNotification());
        }
        else{
            notification = new Notification(new SmsNotification());
        }
        if(client.getEmail().isBlank()){
            throw  new IllegalArgumentException("ERRO! O campo do email é obrigatório!");
        }

        return notification.sendNotification(client);
    }
}
