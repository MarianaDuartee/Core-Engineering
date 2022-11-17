package org.marianaduarte.tema11;

import java.io.IOException;
import java.util.Scanner;

public class NotificationService {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        NotificationFactory notificationFactory = new NotificationFactory();
        System.out.println("Bem-vindo(a) ao serviço de Notificações");
        int choice;
        do{
            System.out.println("Selecione o tipo de notificação que deseja enviar:\n" +
                    "1 - SMS\n" +
                    "2 - EMAIL\n" +
                    "3 - WHATSAPP\n" +
                    "4 - FACEBOOK\n" +
                    "5 - INSTAGRAM\n" +
                    "6 - Nenhum\n");
            choice = scan.nextInt();

            switch (choice){
                case 1:{
                    Notification notification = notificationFactory.createNotification("sms");
                    System.out.println(notification.notifyUser());
                    System.out.println("Pressione Enter para continuar ...");
                    System.in.read();
                }
                break;
                case 2:{
                    Notification notification = notificationFactory.createNotification("email");
                    System.out.println(notification.notifyUser());
                    System.out.println("Pressione Enter para continuar ...");
                    System.in.read();
                }
                break;
                case 3:{
                    Notification notification = notificationFactory.createNotification("whatsapp");
                    System.out.println(notification.notifyUser());
                    System.out.println("Pressione Enter para continuar ...");
                    System.in.read();
                }
                break;
                case 4:{
                    Notification notification = notificationFactory.createNotification("facebook");
                    System.out.println(notification.notifyUser());
                    System.out.println("Pressione Enter para continuar ...");
                    System.in.read();
                }
                break;
                case 5:{
                    Notification notification = notificationFactory.createNotification("instagram");
                    System.out.println(notification.notifyUser());
                    System.out.println("Pressione Enter para continuar ...");
                    System.in.read();
                }
                break;
                default:
                    return;
            }
        }while(choice != 6);
    }
}
