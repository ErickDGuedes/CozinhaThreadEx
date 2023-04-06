package view;

import java.util.concurrent.Semaphore;

import controller.CozinhaThread;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		for(int i=1; i<22; i++) {
			Semaphore semaforo = new Semaphore(permissoes);
			CozinhaThread co = new CozinhaThread(semaforo, i);
			co.start();
		}
		

	}

}
