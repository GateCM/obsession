package com.gatecm.obsession.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-11
 */
@TableName("uc_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 修改时间
     */
	@TableField("gmt_modify")
	private Date gmtModify;
    /**
     * 头像路径
     */
	@TableField("head_img")
	private String headImg;
    /**
     * 昵称
     */
	private String nickname;
    /**
     * 社区所在市
     */
	private String city;
    /**
     * 社区所在区
     */
	private String county;
    /**
     * 社区所在省
     */
	private String province;
    /**
     * 性别
     */
	@TableField("is_man_sex")
	private Integer isManSex;
    /**
     * 职业
     */
	private String occupation;
    /**
     * 个人签名
     */
	@TableField("person_motto")
	private String personMotto;
    /**
     * 年龄区间
     */
	@TableField("age_area")
	private String ageArea;
    /**
     * 密码
     */
	private String password;
    /**
     * 手机号
     */
	@TableField("phone_number")
	private String phoneNumber;
    /**
     * 身份证号
     */
	@TableField("id_number")
	private String idNumber;
    /**
     * 真实姓名
     */
	@TableField("real_name")
	private String realName;
    /**
     * 年龄
     */
	private Integer age;
    /**
     * 注册时间
     */
	@TableField("register_time")
	private Date registerTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 是否已身份认证
     */
	@TableField("is_real")
	private Integer isReal;
    /**
     * 2：冻结，无法使用；1：使用中；0：账号锁
     */
	@TableField("user_status")
	private String userStatus;
    /**
     * 0：未登录；1：已登录
     */
	@TableField("is_login")
	private Integer isLogin;
    /**
     * 锁定开始时间
     */
	@TableField("lock_time")
	private Date lockTime;
    /**
     * 社区ID
     */
	@TableField("community_id")
	private Long communityId;
    /**
     * 志愿者ID
     */
	@TableField("volunteer_id")
	private Long volunteerId;
    /**
     * 遗嘱库ID
     */
	@TableField("will_id")
	private Long willId;
    /**
     * token值
     */
	private String token;
    /**
     * token过期时间
     */
	@TableField("token_deadline")
	private Date tokenDeadline;
    /**
     * 设备号
     */
	private String udid;
	@TableField("is_del")
	private Integer isDel;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getIsManSex() {
		return isManSex;
	}

	public void setIsManSex(Integer isManSex) {
		this.isManSex = isManSex;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPersonMotto() {
		return personMotto;
	}

	public void setPersonMotto(String personMotto) {
		this.personMotto = personMotto;
	}

	public String getAgeArea() {
		return ageArea;
	}

	public void setAgeArea(String ageArea) {
		this.ageArea = ageArea;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsReal() {
		return isReal;
	}

	public void setIsReal(Integer isReal) {
		this.isReal = isReal;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public Long getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(Long volunteerId) {
		this.volunteerId = volunteerId;
	}

	public Long getWillId() {
		return willId;
	}

	public void setWillId(Long willId) {
		this.willId = willId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenDeadline() {
		return tokenDeadline;
	}

	public void setTokenDeadline(Date tokenDeadline) {
		this.tokenDeadline = tokenDeadline;
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", gmtCreate=" + gmtCreate +
			", gmtModify=" + gmtModify +
			", headImg=" + headImg +
			", nickname=" + nickname +
			", city=" + city +
			", county=" + county +
			", province=" + province +
			", isManSex=" + isManSex +
			", occupation=" + occupation +
			", personMotto=" + personMotto +
			", ageArea=" + ageArea +
			", password=" + password +
			", phoneNumber=" + phoneNumber +
			", idNumber=" + idNumber +
			", realName=" + realName +
			", age=" + age +
			", registerTime=" + registerTime +
			", updateTime=" + updateTime +
			", isReal=" + isReal +
			", userStatus=" + userStatus +
			", isLogin=" + isLogin +
			", lockTime=" + lockTime +
			", communityId=" + communityId +
			", volunteerId=" + volunteerId +
			", willId=" + willId +
			", token=" + token +
			", tokenDeadline=" + tokenDeadline +
			", udid=" + udid +
			", isDel=" + isDel +
			"}";
	}
}
