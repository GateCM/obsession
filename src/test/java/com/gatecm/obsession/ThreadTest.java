/**
 * 
 */
package com.gatecm.obsession;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年11月6日 下午3:32:22
 *
 */
public class ThreadTest implements Runnable {
	private Thread thread;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		t.start();
		ThreadTest t2 = new ThreadTest();
		t2.start();
		ThreadTest t3 = new ThreadTest();
		t3.start();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Thread.dumpStack();
			System.err.println(Thread.currentThread().getName());
		}
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(new ThreadTest());
		}
		thread.start();

	}

}
