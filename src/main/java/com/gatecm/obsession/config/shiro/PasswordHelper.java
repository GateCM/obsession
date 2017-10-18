/**
 * 
 */
package com.gatecm.obsession.config.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月16日 下午1:20:47
 *
 */
public class PasswordHelper {

	/**
	 * 密码加密,使用随机salt
	 * 
	 * @param password
	 * @return
	 */
	public PasswordEntity encryptPassword(String password) {
		PasswordEntity passwordAndSalt = new PasswordEntity();
		RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = randomNumberGenerator.nextBytes().toHex();
		// 将密码经过散列算法替换成一个不可逆的新密码保存进数据，散列过程使用了盐
		String newPassword = new SimpleHash(ShiroConstant.ALGORITHM_NAME, password, ByteSource.Util.bytes(salt),
				ShiroConstant.HASH_ITERATIONS).toHex();
		passwordAndSalt.setSalt(salt);
		passwordAndSalt.setPassword(newPassword);
		return passwordAndSalt;
	}

	/**
	 * 密码加密
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public String encryptPassword(String password, String salt) {
		return new SimpleHash(ShiroConstant.ALGORITHM_NAME, password, ByteSource.Util.bytes(salt),
				ShiroConstant.HASH_ITERATIONS).toHex();
	}

	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		PasswordEntity passwordAndSalt = passwordHelper.encryptPassword("12345");
		System.err.println(passwordAndSalt.toString());
		System.err.println(passwordHelper.encryptPassword("0000", "08923075514e1d7a2161cf6cf9749c57"));
	}

}
