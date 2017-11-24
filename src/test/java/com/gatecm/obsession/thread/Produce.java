/**
 * 
 */
package com.gatecm.obsession.thread;

import java.util.Random;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年11月6日 下午4:57:04
 *
 */
public class Produce implements Runnable {

	private PCManager PCManager;

	public Produce(PCManager PCManager) {
		this.PCManager = PCManager;
	}

	@Override
	public void run() {
		while (true) {
			try {
				PCManager.produce();
				Thread.sleep(new Random().nextInt(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
