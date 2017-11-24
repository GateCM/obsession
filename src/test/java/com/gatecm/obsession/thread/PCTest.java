/**
 * 
 */
package com.gatecm.obsession.thread;

/**
* @Description: TODO()
* @author chenxiaohui
* @date 2017年11月6日 下午5:08:45
*
*/
public class PCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer productNum = 8;
		PCManager PCManager = new PCManager(productNum);
		Produce produce = new Produce(PCManager);
		Consume consume = new Consume(PCManager);
		new Thread(consume).start();
		new Thread(produce).start();
		

	}

}
