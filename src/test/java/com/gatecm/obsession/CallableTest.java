/**
 * 
 */
package com.gatecm.obsession;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import net.bytebuddy.asm.Advice.Return;

/**
* @Description: TODO()
* @author chenxiaohui
* @date 2017年11月6日 下午3:41:53
*
*/
public class CallableTest implements Callable<String>{

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableTest test = new CallableTest();
		
		FutureTask<String> futureTask = new FutureTask<>(test);
//		System.err.println(futureTask.get());
		new Thread(futureTask).start();
		System.err.println(futureTask.get());

	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "sdfsfsdf";
	}

}
