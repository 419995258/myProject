package org.szd.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */

//用户表（包括各种类型的用户）
@Entity
@Table(name = "BASE_USER")
public class BaseUser implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "USER_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 40)
	//userId
	private java.lang.String id;
		
	@Column(name = "LOGIN_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	//登录名
	private java.lang.String loginName;
		
	@Column(name = "PASSWORD", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//密码
	private java.lang.String password;
		
	@Column(name = "STATUS", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//状态  1:正常  0:封杀
	private java.lang.String status;
		
	@Column(name = "REALNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//真实姓名
	private java.lang.String realname;
		
	@Column(name = "NICKNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//昵称
	private java.lang.String nickname;
		
	@Column(name = "ID_CARD", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	//身份证号
	private java.lang.String idCard;
		
	@Column(name = "SEX", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	//性别  1男  0女
	private java.lang.String sex;
		
	@Column(name = "BIRTHDAY", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//生日
	private java.util.Date birthday;
		
	@Column(name = "PHOTO_PATH", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//头像路径
	private java.lang.String photoPath;
		
	@Column(name = "OFFICE_PHONE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//办公电话
	private java.lang.String officePhone;
		
	@Column(name = "MOBILE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//移动电话
	private java.lang.String mobile;
		
	@Column(name = "EMAIL", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//email
	private java.lang.String email;
		
	@Column(name = "ADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//地址
	private java.lang.String address;
		
	@Column(name = "ZIPCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	//邮编
	private java.lang.String zipcode;
		
	@Column(name = "MSN", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//msn
	private java.lang.String msn;
		
	@Column(name = "QQ", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//QQ
	private java.lang.String qq;
		
	@Column(name = "LOGIN_COUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//登录次数
	private Integer loginCount;
		
	@Column(name = "LAST_LOGIN_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//最后一次登录时间 到秒
	private java.util.Date lastLoginTime;
		
	@Column(name = "LAST_LOGIN_IP", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//最后一次登录ip
	private java.lang.String lastLoginIp;
		
	@Column(name = "CRE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//创建时间
	private java.util.Date creTime;
		
	@Column(name = "MOD_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//修改时间
	private java.util.Date modTime;
		
	@Column(name = "PROVINCE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//省id
	private java.lang.String provinceId;
		
	@Column(name = "CITY_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//市id
	private java.lang.String cityId;
		
	@Column(name = "COUNTY_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//县id
	private java.lang.String countyId;
		
	@Column(name = "SCHOOL_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//学校id
	private java.lang.String schoolId;
		
	@Column(name = "DEFAULT_ROLE_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//defaultRoleCode
	private java.lang.String defaultRoleCode;
		
	@Column(name = "IS_INI", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//是否初始化，1为初始化，0为未初始化
	private Integer isIni;
		
	@Column(name = "AREA_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//所属地区id
	private java.lang.String areaId;
		
	@Column(name = "INI_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//初始化时间
	private java.lang.String iniUser;
		
	@Column(name = "INI_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//初始化时间
	private java.util.Date iniTime;
		
	@Column(name = "DELETE_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	//删除标记 0：未删除 1：已删除
	private java.lang.String deleteFlag;
		
	@Column(name = "DELETE_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//删除操作人
	private java.lang.String deleteUser;
		
	@Column(name = "DELETE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//删除操作时间
	private java.util.Date deleteTime;
		
	@Column(name = "CRE_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//creUser
	private java.lang.String creUser;
		
	@Column(name = "MOD_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//modUser
	private java.lang.String modUser;
		
	@Column(name = "SCHOOL_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//冗余school_name
	private java.lang.String schoolName;
		
	@Column(name = "NAME_ABBREVIATE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//真实姓名的首字母
	private java.lang.String nameAbbreviate;
		
	@Column(name = "VERIFY_HASH", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//找回密码的hash，通过org.work.platform.ObjectIDFactory getGuid()方法取得一个数存入，用来做校验。
	private java.lang.String verifyHash;
		
	@Column(name = "MARK", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	//个人签名或简介
	private java.lang.String mark;
		
	@Column(name = "UNIT", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	//工作单位
	private java.lang.String unit;
		
	@Column(name = "UNIT_WEBSITE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//工作单位网址
	private java.lang.String unitWebsite;
		
	@Column(name = "BLOG", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//个人博客
	private java.lang.String blog;
		
	@Column(name = "MICROBLOG", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//微博
	private java.lang.String microblog;
		
	@Column(name = "HOBBY", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	//爱好 从属性组取得吧
	private java.lang.String hobby;
		
	@Column(name = "MOTTO", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	//格言
	private java.lang.String motto;
		
	@Column(name = "IS_PASSWORD_VALIDATE", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//弱口令是否已验证 默认0 已验证：1 未验证：0
	private Integer isPasswordValidate;



	

	
	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getLoginName() {
		return this.loginName;
	}
	
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getRealname() {
		return this.realname;
	}
	
	public void setRealname(java.lang.String value) {
		this.realname = value;
	}
	
	public java.lang.String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(java.lang.String value) {
		this.nickname = value;
	}
	
	public java.lang.String getIdCard() {
		return this.idCard;
	}
	
	public void setIdCard(java.lang.String value) {
		this.idCard = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(java.util.Date value) {
		this.birthday = value;
	}
	
	public java.lang.String getPhotoPath() {
		return this.photoPath;
	}
	
	public void setPhotoPath(java.lang.String value) {
		this.photoPath = value;
	}
	
	public java.lang.String getOfficePhone() {
		return this.officePhone;
	}
	
	public void setOfficePhone(java.lang.String value) {
		this.officePhone = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getZipcode() {
		return this.zipcode;
	}
	
	public void setZipcode(java.lang.String value) {
		this.zipcode = value;
	}
	
	public java.lang.String getMsn() {
		return this.msn;
	}
	
	public void setMsn(java.lang.String value) {
		this.msn = value;
	}
	
	public java.lang.String getQq() {
		return this.qq;
	}
	
	public void setQq(java.lang.String value) {
		this.qq = value;
	}
	
	public Integer getLoginCount() {
		return this.loginCount;
	}
	
	public void setLoginCount(Integer value) {
		this.loginCount = value;
	}
	
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	
	public void setLastLoginTime(java.util.Date value) {
		this.lastLoginTime = value;
	}
	
	public java.lang.String getLastLoginIp() {
		return this.lastLoginIp;
	}
	
	public void setLastLoginIp(java.lang.String value) {
		this.lastLoginIp = value;
	}
	
	public java.util.Date getCreTime() {
		return this.creTime;
	}
	
	public void setCreTime(java.util.Date value) {
		this.creTime = value;
	}
	
	public java.util.Date getModTime() {
		return this.modTime;
	}
	
	public void setModTime(java.util.Date value) {
		this.modTime = value;
	}
	
	public java.lang.String getProvinceId() {
		return this.provinceId;
	}
	
	public void setProvinceId(java.lang.String value) {
		this.provinceId = value;
	}
	
	public java.lang.String getCityId() {
		return this.cityId;
	}
	
	public void setCityId(java.lang.String value) {
		this.cityId = value;
	}
	
	public java.lang.String getCountyId() {
		return this.countyId;
	}
	
	public void setCountyId(java.lang.String value) {
		this.countyId = value;
	}
	
	public java.lang.String getSchoolId() {
		return this.schoolId;
	}
	
	public void setSchoolId(java.lang.String value) {
		this.schoolId = value;
	}
	
	public java.lang.String getDefaultRoleCode() {
		return this.defaultRoleCode;
	}
	
	public void setDefaultRoleCode(java.lang.String value) {
		this.defaultRoleCode = value;
	}
	
	public Integer getIsIni() {
		return this.isIni;
	}
	
	public void setIsIni(Integer value) {
		this.isIni = value;
	}
	
	public java.lang.String getAreaId() {
		return this.areaId;
	}
	
	public void setAreaId(java.lang.String value) {
		this.areaId = value;
	}
	
	public java.lang.String getIniUser() {
		return this.iniUser;
	}
	
	public void setIniUser(java.lang.String value) {
		this.iniUser = value;
	}
	
	public java.util.Date getIniTime() {
		return this.iniTime;
	}
	
	public void setIniTime(java.util.Date value) {
		this.iniTime = value;
	}
	
	public java.lang.String getDeleteFlag() {
		return this.deleteFlag;
	}
	
	public void setDeleteFlag(java.lang.String value) {
		this.deleteFlag = value;
	}
	
	public java.lang.String getDeleteUser() {
		return this.deleteUser;
	}
	
	public void setDeleteUser(java.lang.String value) {
		this.deleteUser = value;
	}
	
	public java.util.Date getDeleteTime() {
		return this.deleteTime;
	}
	
	public void setDeleteTime(java.util.Date value) {
		this.deleteTime = value;
	}
	
	public java.lang.String getCreUser() {
		return this.creUser;
	}
	
	public void setCreUser(java.lang.String value) {
		this.creUser = value;
	}
	
	public java.lang.String getModUser() {
		return this.modUser;
	}
	
	public void setModUser(java.lang.String value) {
		this.modUser = value;
	}
	
	public java.lang.String getSchoolName() {
		return this.schoolName;
	}
	
	public void setSchoolName(java.lang.String value) {
		this.schoolName = value;
	}
	
	public java.lang.String getNameAbbreviate() {
		return this.nameAbbreviate;
	}
	
	public void setNameAbbreviate(java.lang.String value) {
		this.nameAbbreviate = value;
	}
	
	public java.lang.String getVerifyHash() {
		return this.verifyHash;
	}
	
	public void setVerifyHash(java.lang.String value) {
		this.verifyHash = value;
	}
	
	public java.lang.String getMark() {
		return this.mark;
	}
	
	public void setMark(java.lang.String value) {
		this.mark = value;
	}
	
	public java.lang.String getUnit() {
		return this.unit;
	}
	
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}
	
	public java.lang.String getUnitWebsite() {
		return this.unitWebsite;
	}
	
	public void setUnitWebsite(java.lang.String value) {
		this.unitWebsite = value;
	}
	
	public java.lang.String getBlog() {
		return this.blog;
	}
	
	public void setBlog(java.lang.String value) {
		this.blog = value;
	}
	
	public java.lang.String getMicroblog() {
		return this.microblog;
	}
	
	public void setMicroblog(java.lang.String value) {
		this.microblog = value;
	}
	
	public java.lang.String getHobby() {
		return this.hobby;
	}
	
	public void setHobby(java.lang.String value) {
		this.hobby = value;
	}
	
	public java.lang.String getMotto() {
		return this.motto;
	}
	
	public void setMotto(java.lang.String value) {
		this.motto = value;
	}
	
	public Integer getIsPasswordValidate() {
		return this.isPasswordValidate;
	}
	
	public void setIsPasswordValidate(Integer value) {
		this.isPasswordValidate = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UserId",getId())
			.append("LoginName",getLoginName())
			.append("Password",getPassword())
			.append("Status",getStatus())
			.append("Realname",getRealname())
			.append("Nickname",getNickname())
			.append("IdCard",getIdCard())
			.append("Sex",getSex())
			.append("Birthday",getBirthday())
			.append("PhotoPath",getPhotoPath())
			.append("OfficePhone",getOfficePhone())
			.append("Mobile",getMobile())
			.append("Email",getEmail())
			.append("Address",getAddress())
			.append("Zipcode",getZipcode())
			.append("Msn",getMsn())
			.append("Qq",getQq())
			.append("LoginCount",getLoginCount())
			.append("LastLoginTime",getLastLoginTime())
			.append("LastLoginIp",getLastLoginIp())
			.append("CreTime",getCreTime())
			.append("ModTime",getModTime())
			.append("ProvinceId",getProvinceId())
			.append("CityId",getCityId())
			.append("CountyId",getCountyId())
			.append("SchoolId",getSchoolId())
			.append("DefaultRoleCode",getDefaultRoleCode())
			.append("IsIni",getIsIni())
			.append("AreaId",getAreaId())
			.append("IniUser",getIniUser())
			.append("IniTime",getIniTime())
			.append("DeleteFlag",getDeleteFlag())
			.append("DeleteUser",getDeleteUser())
			.append("DeleteTime",getDeleteTime())
			.append("CreUser",getCreUser())
			.append("ModUser",getModUser())
			.append("SchoolName",getSchoolName())
			.append("NameAbbreviate",getNameAbbreviate())
			.append("VerifyHash",getVerifyHash())
			.append("Mark",getMark())
			.append("Unit",getUnit())
			.append("UnitWebsite",getUnitWebsite())
			.append("Blog",getBlog())
			.append("Microblog",getMicroblog())
			.append("Hobby",getHobby())
			.append("Motto",getMotto())
			.append("IsPasswordValidate",getIsPasswordValidate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BaseUser == false) return false;
		if(this == obj) return true;
		BaseUser other = (BaseUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

