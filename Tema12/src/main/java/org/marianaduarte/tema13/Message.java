package org.marianaduarte.tema13;

public class Message {
    public static String assembleMessage(Client client){
        return "Hello " + client.getNome();
    }
}
