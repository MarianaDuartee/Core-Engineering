package org.marianaduarte.tema13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SendNotificationTest {
    private SendNotification sendNotification;
    private Client client;

    @BeforeEach
    public void setUp(){
        sendNotification = new SendNotification();
    }

    @Test
    public void shouldNotAllowNullFieldsOfClient(){
        client = new Client(null,null,null);
        assertThrows(IllegalArgumentException.class,()->sendNotification.sendNotification(client));
    }

    @Test
    public void shouldNotAllowEmptyEmailOfClient(){
        client = new Client("Mariana","","379999999");
        assertThrows(IllegalArgumentException.class,()->sendNotification.sendNotification(client));
    }

    @Test
    public void shouldSendASMSNotification(){
        client = new Client("Mariana","mariana@gmail.com","3799999999");
        assertEquals("| SMS | Hello Mariana",sendNotification.sendNotification(client));
    }

    @Test
    public void shouldSendAEmailNotification(){
        client = new Client("Mariana","mariana@gmail.com","");
        assertEquals("| EMAIL | Hello Mariana",sendNotification.sendNotification(client));
    }

}
