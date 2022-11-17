package org.marianaduarte.tema13;

public class Main {
    public static void main(String[] args) throws Exception {
        Client client1 = new Client("Mariana","mariana@gmail.com","");
        Client client2 = new Client("Pedro","pedro@gmail.com","999999999");

        SendNotification sendNotification = new SendNotification();

        System.out.println(sendNotification.sendNotification(client1));
        System.out.println(sendNotification.sendNotification(client2));

    }
}