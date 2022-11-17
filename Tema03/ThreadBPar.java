package Tema04;

import java.util.Random;


public class ThreadBPar extends Thread{
	private Random num = new Random();
	private static final Integer EXECUTION_INTERVAL = 100;
	
	public void run() {
		while(true) {
			try {
			  int numPar = num.nextInt(EXECUTION_INTERVAL);
			  if (numPar % 2 == 0) {
				System.out.println("Thread B-Par: "+numPar);
			}
			  Thread.sleep(500);
             } 
			catch (InterruptedException e) {
                 e.printStackTrace();
             }
		}
	}
	

}