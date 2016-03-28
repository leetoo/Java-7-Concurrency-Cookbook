package com.packtpub.java7.concurrency.chapter1.recipe1.core;

import com.packtpub.java7.concurrency.chapter1.recipe1.task.Calculator;

/**
 *  Main class of the example
 */
public class Main {

	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		//Launch 10 threads that make the operation with a different number
		Thread[] threads = new Thread[10];
		for (int i=1; i<=10; i++){
			Calculator calculator=new Calculator(i);
			Thread thread=new Thread(calculator,"T+"+i);
//			thread.setDaemon(true);
			threads[i-1] = thread;
			System.out.println(thread.getState());
			thread.start();
			//thread.sleep(Integer.MAX_VALUE);
		}
//		Thread.currentThread().sleep(Integer.MAX_VALUE);
		try {
			threads[0].join();
			threads[1].wait();
			threads[2].sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("T+1 线程执行完成");
	}
}
