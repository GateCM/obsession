/**
 * 
 */
package com.gatecm.obsession.sms;

/**
 * @Description: TODO(短信模板)
 * @author chenxiaohui
 * @date 2017年5月10日 下午5:32:30
 *
 */
public enum EnumSMSTemplate {

	SIGN("【供应链】"),

	PARAM_ACTIVITY_NAME("${actName}"),

	PARAM_PROJECT_NAME("${projectName}"),

	PARAM_ELDER_NAME("${elderName}"),

	PARAM_VOLUNTEER_NAME("${volName}"),

	PARAM_TIME_YYMMDD("${time}"),

	USER_COMMIT_PRE("你提交的"),

	USER_REGISTER_PRE("你报名的 "),

	USER_RELEASE_PRE("你发布的 "),

	USER_DONATION_PRE("你捐助的 "),

	PROJECT_PAUSE_SUFFIX(" 项目，已被管理员置为募捐暂停，请及时联系客服。"),

	PROJECT_PAUSE_RESTAR_SUFFIX(" 项目，已被管理员从募捐暂停置为募捐中。"),

	PROJECT_AUDIT_SUCCESS_SUFFIX(" 项目，已经通过审核。"),

	PROJECT_AUDIT_FAIL_SUFFIX(" 项目，未通过审核，你可在重新编辑后重新提交审核。"),

	PROJECT_PROGRESS_NEW(" 项目有新的进展，可前往APP查看发生了什么有趣的事情。"),

	PROJECT_PROGRESS_END(" 项目已结束，感谢你对弱势群体的关爱。"),

	PROJECT_DONATION_END(" 项目，已经为执行中状态，请及时联系我们进行善款的接收。"),

	PROJECT_DONATION_START_REMIND(
			"你发布的 " + PARAM_PROJECT_NAME.getValue() + " 项目即将于明天（" + PARAM_TIME_YYMMDD.getValue() + "）开始募捐。"),

	PROJECT_DONATION_COMPLETED(" 项目，募捐进度已到100%，你可前往APP提前结束募捐。"),

	CARE_NESTER_START_REMIND_TO_COMMUNITY("你发布的 " + PARAM_ELDER_NAME.getValue() + " 老人的扶老配对，将于今天（"
			+ PARAM_TIME_YYMMDD.getValue() + "）开始与 " + PARAM_VOLUNTEER_NAME.getValue() + " 志愿者配对。"),

	CARE_NESTER_END_REMIND_TO_COMMUNITY("你发布的 " + PARAM_ELDER_NAME.getValue() + " 老人的扶老配对，将于明天（"
			+ PARAM_TIME_YYMMDD.getValue() + "）结束与 " + PARAM_VOLUNTEER_NAME.getValue() + " 志愿者配对。"),

	CARE_NESTER_START_REMIND_TO_VOLUNTEER(
			"亲爱的志愿者，我们已经为您匹配好需要帮助的老人，您报名参与的扶老配对将于今天（" + PARAM_TIME_YYMMDD.getValue() + "）开始，请登录一缕阳光APP查看详情。"),

	CARE_NESTER_END_REMIND_TO_VOLUNTEER(
			"亲爱的志愿者，你报名参与的扶老配对，将于明天（" + PARAM_TIME_YYMMDD.getValue() + "）结束配对。"),

	CARE_NESTER_END_APPLY("亲爱的志愿者，你报名参与的扶老配对，已经由社区申请结束配对，请登录一缕阳光APP查看详情。"),

	ACTIVITY_REGISTER_SUCCESS_SUFFIX(" 活动，已经通过审核。"),

	ACTIVITY_REGISTER_FAIL_SUFFIX(" 活动，未通过审核，你可查看其他合适的活动进行报名。"),

	ACTIVITY_REGISTER_START_REMIND("你发布的 " + PARAM_ACTIVITY_NAME.getValue() + " 活动即将于明天（" + PARAM_TIME_YYMMDD.getValue()
			+ "）开始招募，请认真审核并筛选合适的志愿者。"),

	ACTIVITY_START_REMIND(
			"你发布的 " + PARAM_ACTIVITY_NAME.getValue() + " 活动即将于明天（" + PARAM_TIME_YYMMDD.getValue() + "）开始，请准备活动相关事宜。"),

	ACTIVITY_START_REMIND_VOLUNTEER(
			"你报名的 " + PARAM_ACTIVITY_NAME.getValue() + " 活动即将于明天（" + PARAM_TIME_YYMMDD.getValue() + "）开始，请准时参加。"),

	ACTIVITY_AUDIT_SUCCESS_SUFFIX(" 活动，已经通过审核。"),

	ACTIVITY_AUDIT_FAIL_SUFFIX(" 活动，未通过审核，你可在重新编辑后重新提交审核。"),

	CERT_VOLUNTEER_SUCCESS("你提交的志愿者申请，已经通过审核。"),

	CERT_VOLUNTEER_FAIL("你提交的志愿者申请，未通过审核，你可在重新编辑后重新提交审核。未通过原因: "),

	CERT_WILL_SUCCESS("你提交的遗嘱库登记申请，已经通过审核。"),

	CERT_WILL_FAIL("你提交的遗嘱库登记申请，未通过审核，你可在重新编辑后重新提交审核。未通过原因: "),

	CERT_COMMUNITY_SUCCESS("你提交的社区入驻申请，已经通过审核。"),

	CERT_COMMUNITY_FAIL("你提交的社区入驻申请，未通过审核，你可在重新编辑后重新提交审核。未通过原因: "),

	VOCDE_REGISTER("验证码: "),

	VOCDE_REGISTER_SUCCESS("恭喜你，注册成功为一缕阳光的用户，愿美好的未来你我一起努力。"),

	VOCDE_PASSWORD_RESET("找回密码验证码: "),

	USER_PASSWORD_RESET_SUCCESS("恭喜您，成功找回密码，请妥善保管你的新密码。");

	private String value;

	EnumSMSTemplate(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
