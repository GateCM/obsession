/**
 * 
 */
package com.gatecm.obsession.thread;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年11月6日 下午4:57:04
 *
 */
public class PCManager{

	private Integer productNum;
	private static final int MAX = 15;
	private static final int MIN = 10;

	public PCManager(Integer productNum) {
		this.productNum = productNum;
	}

	public synchronized void produce() throws InterruptedException {
		if (productNum < MAX) {
			productNum++;
			System.err.println("生产1个产品，库存" + productNum + "个产品");
			notifyAll();
		} else {
			wait();
			System.err.println("库存已满");
		}
	}
	
	public synchronized void consume() throws InterruptedException {
		if (productNum <= MIN) {
			System.err.println("库存不足");
			wait();
		} else {
			System.err.println("消费1个产品，剩余" + productNum + "个产品");
			productNum--;
			notifyAll();
		}
	}

}
