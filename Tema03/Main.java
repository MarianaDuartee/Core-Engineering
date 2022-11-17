package Tema04;

public class Main {

	public static void main(String[] args) {
		
		ThreadAImpar A = new ThreadAImpar();
		ThreadBPar B = new ThreadBPar();
		
		A.start();
		B.start();

	}

}