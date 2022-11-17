package org.marianaduarte.tema11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.*;

public class NotificationFactoryTest {
    private NotificationFactory notificationFactory;

    @BeforeEach
    public void setUp(){
        notificationFactory = new NotificationFactory();
    }

    @Test
    public void shoulSendSMSNotification(){
        Notification notification = notificationFactory.createNotification("sms");
        String saida = notification.notifyUser();
        assertEquals(saida, notification.notifyUser());
    }
    @Test
    public void shoulSendEmailNotification(){
        Notification notification = notificationFactory.createNotification("email");
        String saida = notification.notifyUser();
        assertEquals(saida, notification.notifyUser());
    }
    @Test
    public void shoulSendWhatsAppNotification(){
        Notification notification = notificationFactory.createNotification("whatsapp");
        String saida = notification.notifyUser();
        assertEquals(saida, notification.notifyUser());
    }
    @Test
    public void shoulSendFacebookNotification(){
        Notification notification = notificationFactory.createNotification("facebook");
        String saida = notification.notifyUser();
        assertEquals(saida, notification.notifyUser());
    }
    @Test
    public void shoulSendInstagramNotification(){
        Notification notification = notificationFactory.createNotification("instagram");
        String saida = notification.notifyUser();
        assertEquals(saida, notification.notifyUser());
    }
}
