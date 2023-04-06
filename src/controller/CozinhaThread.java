package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CozinhaThread extends Thread{
	
	Semaphore semaforo;
	int cozinheiro;
	
	public CozinhaThread(Semaphore semaforo, int cozinheiro) {
		this.semaforo = semaforo;
		this.cozinheiro = cozinheiro;
		
	}
	public void run() {
		Pratos();
		try {
			semaforo.acquire();
			Entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}
	
	long id = getId();
	public void Pratos() {
		Random random = new Random();
		if(id % 2 != 0) {
			for(int i=0; i<6 ; i++) {
				int sopaCeb = random.nextInt(5, 8);
				System.out.println("cozinheiro ==> "+cozinheiro+" iniciou preparo da Sopa de Cebola "+sopaCeb);
				double tempo = (int) sopaCeb/0.1;
				while(tempo < 100) {
					System.out.println("cozinheiro "+cozinheiro+" Percentual de cozimento "+tempo+"%");
					tempo += tempo;
					if(tempo >= 100) {
						Entrega();
					}
				}
			}	
		}else {
			for(int i=0; i<6 ; i++) {
				int lasanhaBol = random.nextInt(6, 12);
				System.out.println("cozinheiro ==> "+cozinheiro+" iniciou preparo da Lasanha a Bolonesa "+lasanhaBol);
				double tempo = (int) lasanhaBol/0.1;
				while(tempo < 100) {
					System.out.println("cozinheiro "+cozinheiro+" Percentual de cozimento "+tempo+"%");
					tempo += tempo;
					if(tempo >= 100) {
						Entrega();
					}
				}

			}
		}
	}
	public void Entrega() {
		System.out.println(cozinheiro+" terminou e entregou prato ==> "+id);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
