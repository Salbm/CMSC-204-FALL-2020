import java.util.ArrayDeque;

import java.util.Queue;

import java.util.Random;

public class CarQueue {

	Queue<Integer> Carqueue = new ArrayDeque<Integer>();

	Random rand = new Random();

	public CarQueue(){

		
		for(int k = 0; k<5;k++){

			Carqueue.add(rand.nextInt(4));

		}

	}

	public void addToQueue(){

		class myRunnable implements Runnable{

			

			@Override

			public void run() {

				try{

					Carqueue.add(rand.nextInt(4));

					
					Carqueue.add(rand.nextInt(4));

					Carqueue.add(rand.nextInt(4));

					Carqueue.add(rand.nextInt(4));

					Carqueue.add(rand.nextInt(4));

					Thread.sleep(1000);

				}catch (InterruptedException exception){

				}

			}

		}

		Runnable r = new myRunnable();

		Thread t = new Thread(r);

		t.start();

		
	}

	

	public int deleteQueue(){

		if(Carqueue.isEmpty()){

			
			return 0;

		}

		
		else return Carqueue.remove();

	}

}
