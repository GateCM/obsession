/**
 * 
 */
package com.gatecm.obsession.error;

/**
 * @Description: TODO(API错误码)
 * @author chenxiaohui
 * @date 2017年4月28日 上午10:31:08
 *
 */
public enum APIErrorEnum {

	/** 系统异常 **/

	UNKNOWN_ERROR(00000, "系统错误"), // 未知错误

	RESOURCE_NOT_FUND(00001, "资源未找到"),

	OPER_UPDATE_FAIL(00002, "更新失败"),

	REQUEST_URL_FAIL(00003, "请求路径错误"),

	UPLOAD_IMG_FAIL(00004, "图片上传失败！"),

	NO_AUTHORITY(00005, "权限不足"),

	/** 状态异常 **/

	NOT_LOGGED_IN(10000, "用户尚未登录"),

	PENDING_CERT(10001, "等待认证"),

	HAS_CERT(10002, "已认证"),

	NOT_CERT(10003, "未认证"),

	PHONE_NUMBER_UNLL(10004, "该手机号未注册"),

	PHONE_NUMBER_REGISTERED(10005, "该手机号已注册"),

	PHONE_NUMBER_LOCKED(10006, "该手机号处于锁定中, 请等待解锁！"),

	PHONE_NUMBER_TEMPORARY_LOCKED(10007, "该手机号处于临时锁定中, 请使用验证码登录！"),

	PHONE_NUMBER_DISABLE(10008, "该手机号处于冻结中, 请联系管理员解锁！"),

	USER_CERT_ID_NUMBER(10009, "认证失败，请重新认证"),

	USER_CERT_ID_NUMBER_REPEAT(10010, "已实名"),

	VCODE_ERROR(10011, "验证码错误, 请重新输入"),

	VCODE_TIME_OUT(10012, "该验证码已过期, 请重新获取"),

	VCODE_REQUEST_WAIT(10013, "验证码请求过于频繁"),

	PASSWORD_ERROR(10014, "密码错误，请重新输入"),

	NOT_REAL_NAME(10015, " 进行信息完善前, 请先完成身份认证"),

	OLD_PASSWORD_ERROR(10016, "原密码错误"),

	NICKNAME_EXIST(10017, "该昵称已存在"),

	NICKNAME_ALREADY_SET(10018, "昵称已设置, 不可修改"),

	NOT_AUDIT(10019, "资源尚未通过审核"),

	NOT_IN_DONATION(10020, "项目未在募捐状态中"),

	NOT_PAUSE_DONATION(10021, "项目未暂停募捐"),

	NOT_AUDIT_FAIL(10022, "项目未审核或审核通过"),

	NO_VOLUNTEER_INFO(10023, "志愿者信息未完善"),

	NO_COMMUNITY_INFO(10024, "社区信息未完善"),

	NO_WILL_INFO(10025, "遗嘱库信息未完善"),

	ACTIVITY_NOT_IN_RECRUIT(10026, "活动尚未开始招募志愿者"),

	ACTIVITY_NOT_BELONG_USER(10027, "只有活动发起者才可以进行活动管理"),

	VOLUNTEER_EVALUATE_REPEAT_ERROR(10028, "已评价，不能重复评价"),

	VOLUNTEER_EVALUATE_NO_REGISTER_ERROR(10029, "未报名活动不能评价"),

	VOLUNTEER_EVALUATE_NO_ATTEND_ERROR(10030, "未参加活动不能评价"),

	ACTIVITY_EVALUATE_NO_PRIVILEGE(10031, "非活动发起者,不能对志愿者评价"),

	ACTIVITY_GET_INFO_REGISTER(10032, "获取志愿者报名信息失败"),

	ACTIVITY_NOT_IN_SIGNING(10033, "活动未开始招募或招募已结束"),

	ACTIVITY_NOT_END(10034, "活动未结束"),

	ACTIVITY_REPOER_HAS_EXSIT(10035, "活动媒体报道已存在"),

	VERIFY_INTERFACE_RESPONSE(10036, "实名检测接口响应异常"),

	VERIFY_INTERFACE_VERIFY_SCORE(10037, "匹配度过低"),

	PROJECT_NOT_COMMUNITY(10038, " 发起募捐项目前, 请先完成社区认证"),

	PROJECT_NOT_BELONG_USER(10039, "只有募捐发起者才可以进行募捐管理"),

	PROJECT_NOT_COMPLETE(10040, "请添加好募捐项目后，再提交审核！"),

	PROJECT_DONATION_TIME_WRONGFUL(10041, "募捐周期设置错误"),

	PROJECT_UN_REPEATE_COMMIT(10042, "不可重复提交"),

	PROJECT_STATUS_NOT_END(10043, "只有执行中的项目才能添加进展"),

	PROJECT_STATUS_NOT_AUDIT_FAIL(10044, "只有审核不通过的项目才可重新编辑"),

	PROJECT_STATUS_NOT_AUDIT_FAIL_2(10045, "只有审核不通过的项目才可查看原因"),

	PROJECT_STATUS_NOT_DONATION_STARTED(10046, "只有募捐中的项目才可结束募捐"),

	PROJECT_STATUS_NOT_PENGDING_COMMIT(10047, "该募捐项目已提交不能删除"),

	PROJECT_PAY_STATUS_ERROR(10048, "募捐状态获取失败"),

	PROJECT_PAY_STATUS_ERROR_ERROR(10049, "募捐状态获取失败,用户未登录"),

	CARE_NESTER_ELDER_NO_BELONG(10050, "只能操作本社区老人信息"),

	CARE_NESTER_REPEAT(10051, "不可重复发起配对"),

	CARE_NESTER_UN_REPEATE_COMMIT(10052, "不可重复提交"),

	CARE_NOT_BELONG_USER(10053, "只有配对发起者才可以进行配对管理"),

	NOT_IN_RECRUIT(10054, "尚未开始或招募已结束"),

	NOT_REPEAT_SIGN_UP(10055, "不可重复报名"),

	NOT_IN_RECRUIT_FAIL(10056, "只有招募失败才可重新招募"),
	
	NOT_RIGHT_VOLUNTEER_TYPE(10057, "志愿者类型不匹配"),

	/** 参数异常 **/

	NOT_NULL_PASSWORD(20000, "密码不能为空"),

	NOT_NULL_PHONE_NUMBER(20001, "手机号不能为空"),

	NOT_NULL_ID_CARD_FRONT_IMG(20002, "手持身份证正面照未上传"),

	NOT_NULL_ID_CARD_OPPOSITE_IMG(20003, "手持身份证反面照未上传"),

	NOT_NULL_NICKNAME(20004, "昵称不能为空"),

	NOT_NULL_HEAD_IMG(20005, "头像不能为空"),

	ACTIVITY_GET_ERROR(20006, "获取活动信息失败"),

	ACTIVITY_GET_NAME_ERROR(20007, "获取活动信息名称失败"),

	ACTIVITY_GET_CONTEXT_ERROR(20008, "获取活动信息失败"),

	ACTIVITY_GET_INFO_ERROR(20009, "获取活动信息失败"),

	ACTIVITY_GET_INFO_NEED_ERROR(20010, "获取活动信息需求失败"),

	ACTIVITY_GET_INFO_GET_ERROR(20011, "获取活动信息获取失败"),

	ACTIVITY_GET_INFO_STATUS_ERROR(20012, "修改活动信息状态失败"),

	ACTIVITY_GET_INFO_DELETE_ERROR(20013, "活动删除失败"),

	UPLOAD_IMG_ROUTE_FAIL(20014, "图片加载失败"),

	USER_CERT_ID_NUMBER_EXIST(20015, "该身份证已被认证"),

	ADUIT_ERROR(20016, "审核失败"),

	RECRUIT_ERROR(20017, "招募相关信息失败"),

	ATTEND_ERROR(20018, "签到失败"),

	ACTIVITY_COUNT_GET_ERROR(20019, "某志愿者参与活动次数获取失败"),

	ACTIVITY_RE_COUNT_GET_ERROR(20020, "活动志愿者符合不符合数量获取失败"),

	VOLUNTEER_ACTIVITY_GET_ERROR(20021, "志愿者获取失败"),

	DONNA_GET_ERROR(20022, "捐赠获取失败"),

	YIFUBAO_LOGIN_ERROR(20024, "token没有传"),

	NOT_NULL_PARAM(20023, "请求参数不完整"),

	VOLUN_ERROR_GET(20024, " 获取志愿者信息失败");

	private String msg;
	private int code;

	private APIErrorEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public int getCode() {
		return this.code;
	}

}
