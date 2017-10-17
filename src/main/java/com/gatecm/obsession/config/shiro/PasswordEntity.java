/**
 * 
 */
package com.gatecm.obsession.config.shiro;

/**
 * @Description: TODO(密码实体)
 * @author chenxiaohui
 * @date 2017年10月17日 上午10:39:24
 *
 */
public class PasswordEntity {

	private String password;
	private String salt;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "PasswordEntity [password=" + password + ", salt=" + salt + "]";
	}

}
