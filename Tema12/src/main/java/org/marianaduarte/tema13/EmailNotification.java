package org.marianaduarte.tema13;

public class EmailNotification implements Strategy{
    @Override
    public String sendNotification() {
        return "| EMAIL | ";
    }
}
