/**
 * 
 */
package com.gatecm.obsession.thread;

import java.util.Random;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年11月6日 下午4:59:51
 *
 */
public class Consume implements Runnable {

	private PCManager PCManager;

	public Consume(PCManager PCManager) {
		this.PCManager = PCManager;
	}

	@Override
	public void run() {
		while (true) {
			try {
				PCManager.consume();
				Thread.sleep(new Random().nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
