package Tema04;

import java.util.Random;


public class ThreadAImpar extends Thread{
	private Random num = new Random();
	private static final Integer EXECUTION_INTERVAL = 100;
	
	public void run() {
		while(true) {
			 try {
				 int numImpar = num.nextInt(EXECUTION_INTERVAL);
				 if (numImpar % 2 != 0) {
						System.out.println("Thread A-Impar: "+numImpar);
					}
                  Thread.sleep(100);
             } 
			 catch (InterruptedException e) {
                 e.printStackTrace();
             }
		}
	}
	

}