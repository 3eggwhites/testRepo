package com.thread;

import java.util.concurrent.TimeUnit;

public class FirstWay {

	public static void main(String[] args) {
		FirstTask ft = new FirstTask();
		Thread t1 = new Thread(ft);
		Thread t2 = new Thread(ft);
		t1.start();
		t2.start();
	}
//comment add check
}

class FirstTask implements Runnable {
	private static int count = 0;
	private int id = 0;

	@Override
	public void run() {
		count = 0;
		id = 0;
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < 1000; i++) {
			synchronized (this) {
				id++;
				++count;
				System.out.println(id + " " + count + " " + "from thread " + tName);
				try {
					System.out.println("gonna go home");
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					//use logger than stacktrace
					e.printStackTrace();
				}
			}
		}
	}
}
