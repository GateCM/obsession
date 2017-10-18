/**
 * 
 */
package com.gatecm.obsession.constant;

/**
 * @Description: TODO(响应参数名定义)
 * @author chenxiaohui
 * @date 2017年4月25日 下午3:41:53
 *
 */
public enum EnumResponseParam {

	PAGE_RESULT("pageResult"), // back

	SELECT_PARAM("selectParam"), // back

	RESULT("result"),

	TOKEN("token"),

	STATUS("status"),

	IMG_URL("imgUrl"),

	PAGINATION_PAGE("page"),

	PAGINATION_PAGE_SIZE("pageSize"),

	PAGE_MY_INFO("myPageInfo"),

	COMPONENT_INFOS("componentInfos"),

	COMPONENT_CARE_DELDER_COUNT("elderCount"),

	COMPONENT_WILL_COUNT("willCount"),

	SCHOOL_INFOS("schoolInfos"),

	SCHOOL_CODE("schNo"),

	INSTITUE_INFOS("insInfos"),

	PROFESSION_INFOS("proInfos"),

	CLASS_INFOS("classInfos"),

	COMPONENT_DETAIL_INFO("componentDetailInfo"),

	BANNER_INFO("bannerInfo"),

	BANNER_INFOS("bannerInfos"),

	START_FALSH_INFO("startFlashBannerInfo"),

	VCODE_SEND_TIME("vcodeSendTime"),

	LOGIN_STATUS("loginStatus"),

	USER_STATUS("userStatus"),

	USER_STATUS_INFO("statusInfo"),

	USER_INFO("userInfo"),

	USER_INFOS("userInfos"),

	USER_ID_CARD_INFO("userIdCardInfo"),

	USER_LIVENESS_INFO("userLivenessInfo"),

	CERT_STATUS("certStatus"),

	USER_LOCK_TIME("userLockTime"),

	VOLUNTEER_ID("volunteerId"),

	VOLUNTEER_TYPE("volType"),

	VOLUNTEER_INFO("volunteerInfo"),

	VOLUNTEER_AUTO_FAIL_FEED_BACK("volunteerFeedBack"),

	VOLUNTEER_INFOS("volunteerInfos"),

	VOLUNTEER_EVALUATE_HEAD("volEvaHead"),

	REGISTER_VOLUNTEER_INFOS("registerVolunteerInfos"),

	VOLUNTEER_IMG_INFO("volunteerImgInfo"),

	VOLUNTEER_IMG_INFOS("volunteerImgInfos"),

	VOLUNTEER_IS_SIGN_UP("isSignUp"),

	WILL_ID("willId"),

	WILL_INFO("willInfo"),

	COMMUNITY_ID("communityId"),

	COMMUNITY_INFO("communityInfo"),

	COMMUNITY_INFOS("communityInfos"),

	COMMUNITY_EVALUATE_HEAD("comEvaHead"),

	COMMUNITY_AVG_SCORE("communityAvgCore"),

	CERT_INFO("certInfo"),

	CERT_INFOS("certInfos"),

	AUDIT_INFO("auditInfo"),

	AUDIT_INFOS("auditInfos"),

	WHITE_KNIGHT_RESULT("whiteKnightResult"),

	FRAUD_API_RESPONSE("fraudApiResponse"),

	FOOTPRINT_INFO("footprintInfo"),

	ACTIVITY_REGISTER_INFO("activityRegisterInfo"),

	ACTIVITY_INFO("activityInfo"),

	ACTIVITY_REGISTER_STATUS("actRegStatus"),

	ACTIVITY_EVALUATE_INFO("evaluateInfo"),

	ACTIVITY_EVALUATE_INFOS("evaluateInfos"),

	ACTIVITY_EVALUATE_AVG_SCORE("actEvaScore"),

	PROJECT_INFO("projectInfo"),

	PROJECT_DONA_INFO("projectDonaInfo"),

	PROJECT_INFOS("projectInfos"),

	PROJECT_STATUS_COUNT_INFOS("pscInfos"),

	PROJECT_EDIT_STATUS_INFO("editStatusInfo"),

	PROJECT_PAY_STATUS("projectPayStatus"),

	PROGRESS_INFO("progressInfo"),

	PROGRESS_INFOS("progressInfos"),

	ORGANIZATION_INFOS("orgInfos"),

	FOOTPRINT_INFOS("footprintInfos"),

	CARE_NESTER_INFO("careNesterInfo"),

	CARE_NESTER_INFOS("careNesterInfos"),

	CARE_NESTER_CURRENT_STATUS("currentStatus"),

	CARE_ELDER_INFOS("careElderInfos"),

	CARE_ELDER_INFO("careElderInfo"),

	CARE_ELDER_COUNT_INFO("careElderCountInfo"),

	CARE_ELDER_RECORD_INFOS("careElderRecordInfos"),

	CARE_ELDER_RECORD_INFO("careElderRecordInfo"),

	CARE_REGISTER_INFO("registerInfo"),

	CARE_REGISTER_INFOS("registerInfos"),

	CARE_VOLUNTEER_REGISTER_INFOS("volRegisterInfos"),

	CARE_RECORD_CALENDAR_INFOS("dateInfos"),

	CARE_RECORD_DAY_INFOS("recordDayInfos"),

	RESULT_TOTAL("resultTotal"),

	ERROR("error"),

	USER_NEWS_INFOS("userNewsInfos"),

	LOGIN_ERROR_COUNT("loginErrorCount"),

	LOGIN_TYPE("loginType"),

	RESOURCES_NOT_FUND("resourcesNotFund"),

	SAME_USER_LOACL("sameUserLocal"),

	LATER_USER("laterUser"),

	CARE_ELDER_DETAIL("careElderDatail"),

	UC_VOLUNTEER_DTO("ucVolunteerDTO");

	String value;

	private EnumResponseParam(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
