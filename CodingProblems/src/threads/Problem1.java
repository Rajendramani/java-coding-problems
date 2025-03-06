package threads;

import java.util.concurrent.Semaphore;

/*
 * ஒரு string [] வில் {a,b,c....z} வரையான alphabets உள்ளன 
 * இதை 3 Thread ஐ வைத்து print செய்ய வேண்டும் 
 * Thread t1 -> a 
 * Thread t2 -> b 
 * Thread t3 -> c
 * Thread t1 -> d 
 * இது மாதிரி z வரை print செய்ய வேண்டும் 
 */
public class Problem1 {

	private static final String[] aphabets = "abcdefghijklmnopqrstuvwxyz".split("");
	private static final int THREAD_COUNT = 3;
	private static final Semaphore[] semaphore = new Semaphore[THREAD_COUNT];

	public static void main(String[] args) {
		System.out.println("Hello");

		// Creating semaphore
		for (int i = 0; i < THREAD_COUNT; i++) {
			semaphore[i] = new Semaphore(i == 0 ? 1 : 0);
			System.out.println("Creating semaphore"+(i+1));
		}

		// Creating 3 Threads index
		for (int i = 0; i < THREAD_COUNT; i++) {
			System.out.println("Creating Thread"+(i+1));
			final int threadIdex = i;

			// Thread created and started one by one
			new Thread(() -> {
				for (int j = threadIdex; j < aphabets.length; j += THREAD_COUNT) {
					System.out.println("Printing thread : "+(threadIdex + 1));
					try {
						semaphore[threadIdex].acquire();
						System.out.println("Thread:" + (threadIdex + 1) + " Print:" + aphabets[j]);
						semaphore[(threadIdex + 1) % THREAD_COUNT].release();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();;
		}
	}

}
