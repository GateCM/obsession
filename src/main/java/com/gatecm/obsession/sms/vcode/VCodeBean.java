/**
 * 
 */
package com.gatecm.obsession.sms.vcode;

import java.util.Date;

import com.gatecm.obsession.util.TimeUtils;

/**
 * @Description: TODO(验证码实体)
 * @author chenxiaohui
 * @date 2017年5月2日 上午10:13:06
 *
 */
public class VCodeBean {

	private String vcode;// 验证码
	private Date sendDate;// 发送时间

	public VCodeBean(String vcode, Date sendDate) {
		this.vcode = vcode;
		this.sendDate = sendDate;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	// 获取发送间隔，单位：min
	public Long getInterval(Date customDate) {
		return TimeUtils.minuteDiff(customDate, sendDate);
	}
}
