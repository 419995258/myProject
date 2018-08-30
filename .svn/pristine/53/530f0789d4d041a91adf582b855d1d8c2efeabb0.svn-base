package org.szd.base.entity;

import java.util.Date;

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

//学校表
@Entity
@Table(name = "BASE_SCHOOL")
public class BaseSchool implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SCHOOL_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 40)
	//schoolId
	private java.lang.String id;
		
	@Column(name = "AREA_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	//areaId
	private java.lang.String areaId;
		
	@Column(name = "SCHOOL_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//学校名称
	private java.lang.String schoolName;
		
	@Column(name = "SCHOOL_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//学校类型 ，从字典表中取得 小学、初中、九年一贯制、高中、完全中学 小学：schoolType.xiaoxue 初中：schoolType.chuzhong 高中：schoolType.gaozhong 完中：schoolType.wanzhong 九年一贯制：schoolType.9year
	private java.lang.String schoolType;
		
	@Column(name = "ADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	//学校地址
	private java.lang.String address;
		
	@Column(name = "ZIPCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 6)
	//邮政编码
	private java.lang.String zipcode;
		
	@Column(name = "PROVINCE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//学校所属省id
	private java.lang.String provinceId;
		
	@Column(name = "CITY_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//学校所属市id
	private java.lang.String cityId;
		
	@Column(name = "COUNTY_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//学校所属县id
	private java.lang.String countyId;
		
	@Column(name = "EDU_SYSTEM", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//学制： 63 54 other
	private java.lang.String eduSystem;
		
	@Column(name = "IS_WEAK", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	//是否为薄弱校：1是，0不是
	private java.lang.String isWeak;
		
	@Column(name = "CRE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//creTime
	private java.util.Date creTime;
		
	@Column(name = "CRE_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//creUser
	private java.lang.String creUser;
		
	@Column(name = "MOD_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//modTime
	private java.util.Date modTime;
		
	@Column(name = "MOD_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//modUser
	private java.lang.String modUser;
		
	@Column(name = "IS_INI", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//学校基本信息是否初始化， 1为初始化，0为未初始化
	private Integer isIni;
		
	@Column(name = "INI_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//初始化用户
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
	
	@Column(name = "DELETE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	//删除操作时间
	private java.util.Date deleteTime;
		
	@Column(name = "PHOTO_PATH", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//学校头像
	private java.lang.String photoPath;
		
	@Column(name = "STUDENT_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//学生数
	private Integer studentCnt;
		
	@Column(name = "TEACHER_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//专任教师数
	private Integer teacherCnt;
		
	@Column(name = "LAST_UPDATE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//数据填报最后更新时间
	private java.util.Date lastUpdateTime;
		
	@Column(name = "IS_INI_TB", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//学校填报信息是否初始化， 1为初始化，0为未初始化
	private Integer isIniTb;
		
	@Column(name = "INI_TB_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//iniTbUser
	private java.lang.String iniTbUser;
		
	@Column(name = "IS_SZMZ", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//是否是少数民族学校，默认0 否：0 是：1
	private Integer isSzmz;
		
	@Column(name = "MINZU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//如果IS_SZMZ 选择是，还要选是什么名族的（藏、蒙、维、哈、彝、朝、其他） 存属性，建立属性组
	private java.lang.String minzu;
		
	@Column(name = "SCHOOL_PROBLEM_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//学校信息疑似问题（1、0） 有问题：1 无问题：0 默认：0
	private Integer schoolProblemFlag;
		
	@Column(name = "SCHOOL_PROBLEM_CAUSE", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	//疑似问题原因(原因属性表维护 属性组：school.problem.cause 属性类别：school.problem.cause.01                     school.problem.cause.02                     等等。 逗号分隔开的属性值 例如 school.problem.cause.01,school.problem.cause.02
	private java.lang.String schoolProblemCause;
		
	@Column(name = "SCHOOL_PROBLEM_CONFIRM", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//疑似问题学校确认 默认：1 疑似问题未确认：0 疑似问题已确认：1 默认未确认0
	private Integer schoolProblemConfirm;
		
	@Column(name = "SCHOOL_PROBLEM_CONFIRM_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//疑似问题确认人
	private java.lang.String schoolProblemConfirmUser;
		
	@Column(name = "SCHOOL_PROBLEM_CONFIRM_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//疑似问题确认时间
	private java.util.Date schoolProblemConfirmTime;
		
	@Column(name = "DATA_PROBLEM_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//数据上报疑似问题（1、0） 有问题：1 无问题：0 默认：0
	private Integer dataProblemFlag;
		
	@Column(name = "DATA_PROBLEM_CAUSE", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	//疑似问题原因(原因属性表维护 属性组：data.problem.cause 属性类别：data.problem.cause.01                     data.problem.cause.02                     等等。 逗号分隔开的属性值 例如 data.problem.cause.01,data.problem.cause.02
	private java.lang.String dataProblemCause;
		
	@Column(name = "DATA_PROBLEM_CONFIRM", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//默认：1 疑似问题未确认：0 疑似问题已确认：1 默认未确认0
	private Integer dataProblemConfirm;
		
	@Column(name = "DATA_PROBLEM_CONFIRM_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//疑似问题确认人
	private java.lang.String dataProblemConfirmUser;
		
	@Column(name = "DATA_PROBLEM_CONFIRM_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//确认时间
	private java.util.Date dataProblemConfirmTime;
		
	@Column(name = "IS_XM_SCHOOL", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//教学点是否为项目学校：0否，1是
	private Integer isXmSchool;
	
	@Column(name = "XXJGBSM", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private java.lang.String xxjgbsm;
	
	@Column(name = "XXJGBXLXM1", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private java.lang.String xxjgbxlxm1;
	
	@Column(name = "XXJGBXLXM2", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private java.lang.String xxjgbxlxm2;
	
	@Column(name = "XXJGBXLXM3", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private java.lang.String xxjgbxlxm3;
	
	@Column(name = "CLASS_ROOM_CNT", unique = false, nullable = true, insertable = true, updatable = true)
	//班级数量
	private Integer classRoomCnt;
	
	@Column(name = "XXJGSZDCXFLM", unique = false, nullable = true, insertable = true, updatable = true)
	//学校（机构）所在地城乡分类码
	private String xxjgszdcxflm;
	
	@Column(name = "XXJGBXLXM", unique = false, nullable = true, insertable = true, updatable = true)
	//学校（机构）办学类型码
	private String xxjgbxlxm;
	
	@Column(name = "SCHOOL_STATUS", unique = false, nullable = true, insertable = true, updatable = true)
	//学校状态
	private String schoolStatus;
	
	@Column(name = "RESREC_WX", unique = false, nullable = true, insertable = true, updatable = true)
	private Integer resrecWx;
	
	@Column(name = "RESREC_WX_MAC", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecWxMac;
	
	@Column(name = "RESREC_WX_RTYPE", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecWxType;
	
	@Column(name = "RESREC_NET", unique = false, nullable = true, insertable = true, updatable = true)
	private Integer resrecNet;
	
	@Column(name = "RESREC_NET_MAC", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecNetMac;
	
	@Column(name = "RESREC_NET_MAC2", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecNetMac2;
	
	@Column(name = "RESREC_NET_MAC3", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecNetMac3;
	
	@Column(name = "RESREC_NET_RTYPE", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecNetType;
	
	@Column(name = "RESREC_NET_RTYPE2", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecNetType2;
	
	@Column(name = "RESREC_NET_RTYPE3", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecNetType3;
	
	@Column(name = "RESREC_USERNAME", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecUserName;
	
	@Column(name = "RESREC_USERPHONE", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecUserPhone;
	
	@Column(name = "RESREC_USEREMAIL", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecUserEmail;
	
	@Column(name = "RESREC_USERQQ", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecUserQQ;
	
	@Column(name = "RESREC_ADDRESS", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecUserAddress;
	
	@Column(name = "RESREC_ZIPCODE", unique = false, nullable = true, insertable = true, updatable = true)
	private String resrecUserZipCode;
	
	@Column(name = "SAT_JXD_BOOKCAT", unique = false, nullable = true, insertable = true, updatable = true)
	private String satJxdBookCat;
	
	@Column(name = "SAT_XX_BOOKCAT", unique = false, nullable = true, insertable = true, updatable = true)
	private String satXxBookCat;
	
	@Column(name = "SAT_ZX_BOOKCAT", unique = false, nullable = true, insertable = true, updatable = true)
	private String satZxBookCat;
	
	@Column(name = "NET_JXD_BOOKCAT", unique = false, nullable = true, insertable = true, updatable = true)
	private String netJxdBookCat;
	
	@Column(name = "NET_XX_BOOKCAT", unique = false, nullable = true, insertable = true, updatable = true)
	private String netXxBookCat;
	
	@Column(name = "NET_ZX_BOOKCAT", unique = false, nullable = true, insertable = true, updatable = true)
	private String netZxBookCat;
	
	@Column(name = "NET_JXD_BOOKCAT2", unique = false, nullable = true, insertable = true, updatable = true)
	private String netJxdBookCat2;
	
	@Column(name = "NET_XX_BOOKCAT2", unique = false, nullable = true, insertable = true, updatable = true)
	private String netXxBookCat2;
	
	@Column(name = "NET_ZX_BOOKCAT2", unique = false, nullable = true, insertable = true, updatable = true)
	private String netZxBookCat2;
	
	@Column(name = "NET_JXD_BOOKCAT3", unique = false, nullable = true, insertable = true, updatable = true)
	private String netJxdBookCat3;
	
	@Column(name = "NET_XX_BOOKCAT3", unique = false, nullable = true, insertable = true, updatable = true)
	private String netXxBookCat3;
	
	@Column(name = "NET_ZX_BOOKCAT3", unique = false, nullable = true, insertable = true, updatable = true)
	private String netZxBookCat3;
	
	@Column(name = "LAST_SUBMIT_TIME", unique = false, nullable = true, insertable = true, updatable = true)
	private Date lastSubmitTime;
	
	@Column(name = "DELETE_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	private Integer deleteType;

	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	private java.lang.String lastUpdateUser;
	
	public java.lang.String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(java.lang.String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Integer getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(Integer deleteType) {
		this.deleteType = deleteType;
	}

	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getAreaId() {
		return this.areaId;
	}
	
	public void setAreaId(java.lang.String value) {
		this.areaId = value;
	}
	
	public java.lang.String getSchoolName() {
		return this.schoolName;
	}
	
	public void setSchoolName(java.lang.String value) {
		this.schoolName = value;
	}
	
	public java.lang.String getSchoolType() {
		return this.schoolType;
	}
	
	public void setSchoolType(java.lang.String value) {
		this.schoolType = value;
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
	
	public java.lang.String getEduSystem() {
		return this.eduSystem;
	}
	
	public void setEduSystem(java.lang.String value) {
		this.eduSystem = value;
	}
	
	public java.lang.String getIsWeak() {
		return this.isWeak;
	}
	
	public void setIsWeak(java.lang.String value) {
		this.isWeak = value;
	}
	
	public java.util.Date getCreTime() {
		return this.creTime;
	}
	
	public void setCreTime(java.util.Date value) {
		this.creTime = value;
	}
	
	public java.lang.String getCreUser() {
		return this.creUser;
	}
	
	public void setCreUser(java.lang.String value) {
		this.creUser = value;
	}
	
	public java.util.Date getModTime() {
		return this.modTime;
	}
	
	public void setModTime(java.util.Date value) {
		this.modTime = value;
	}
	
	public java.lang.String getModUser() {
		return this.modUser;
	}
	
	public void setModUser(java.lang.String value) {
		this.modUser = value;
	}
	
	public Integer getIsIni() {
		return this.isIni;
	}
	
	public void setIsIni(Integer value) {
		this.isIni = value;
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
		return deleteTime;
	}

	public void setDeleteTime(java.util.Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public java.lang.String getPhotoPath() {
		return this.photoPath;
	}
	
	public void setPhotoPath(java.lang.String value) {
		this.photoPath = value;
	}
	
	public Integer getStudentCnt() {
		return this.studentCnt;
	}
	
	public void setStudentCnt(Integer value) {
		this.studentCnt = value;
	}
	
	public Integer getTeacherCnt() {
		return this.teacherCnt;
	}
	
	public void setTeacherCnt(Integer value) {
		this.teacherCnt = value;
	}
	
	public java.util.Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}
	
	public void setLastUpdateTime(java.util.Date value) {
		this.lastUpdateTime = value;
	}
	
	public Integer getIsIniTb() {
		return this.isIniTb;
	}
	
	public void setIsIniTb(Integer value) {
		this.isIniTb = value;
	}
	
	public java.lang.String getIniTbUser() {
		return this.iniTbUser;
	}
	
	public void setIniTbUser(java.lang.String value) {
		this.iniTbUser = value;
	}
	
	public Integer getIsSzmz() {
		return this.isSzmz;
	}
	
	public void setIsSzmz(Integer value) {
		this.isSzmz = value;
	}
	
	public java.lang.String getMinzu() {
		return this.minzu;
	}
	
	public void setMinzu(java.lang.String value) {
		this.minzu = value;
	}
	
	public Integer getSchoolProblemFlag() {
		return this.schoolProblemFlag;
	}
	
	public void setSchoolProblemFlag(Integer value) {
		this.schoolProblemFlag = value;
	}
	
	public java.lang.String getSchoolProblemCause() {
		return this.schoolProblemCause;
	}
	
	public void setSchoolProblemCause(java.lang.String value) {
		this.schoolProblemCause = value;
	}
	
	public Integer getSchoolProblemConfirm() {
		return this.schoolProblemConfirm;
	}
	
	public void setSchoolProblemConfirm(Integer value) {
		this.schoolProblemConfirm = value;
	}
	
	public java.lang.String getSchoolProblemConfirmUser() {
		return this.schoolProblemConfirmUser;
	}
	
	public void setSchoolProblemConfirmUser(java.lang.String value) {
		this.schoolProblemConfirmUser = value;
	}
	
	public java.util.Date getSchoolProblemConfirmTime() {
		return this.schoolProblemConfirmTime;
	}
	
	public void setSchoolProblemConfirmTime(java.util.Date value) {
		this.schoolProblemConfirmTime = value;
	}
	
	public Integer getDataProblemFlag() {
		return this.dataProblemFlag;
	}
	
	public void setDataProblemFlag(Integer value) {
		this.dataProblemFlag = value;
	}
	
	public java.lang.String getDataProblemCause() {
		return this.dataProblemCause;
	}
	
	public void setDataProblemCause(java.lang.String value) {
		this.dataProblemCause = value;
	}
	
	public Integer getDataProblemConfirm() {
		return this.dataProblemConfirm;
	}
	
	public void setDataProblemConfirm(Integer value) {
		this.dataProblemConfirm = value;
	}
	
	public java.lang.String getDataProblemConfirmUser() {
		return this.dataProblemConfirmUser;
	}
	
	public void setDataProblemConfirmUser(java.lang.String value) {
		this.dataProblemConfirmUser = value;
	}
	
	public java.util.Date getDataProblemConfirmTime() {
		return this.dataProblemConfirmTime;
	}
	
	public void setDataProblemConfirmTime(java.util.Date value) {
		this.dataProblemConfirmTime = value;
	}
	
	public Integer getIsXmSchool() {
		return this.isXmSchool;
	}
	
	public void setIsXmSchool(Integer value) {
		this.isXmSchool = value;
	}
	
	public java.lang.String getXxjgbsm() {
		return xxjgbsm;
	}

	public void setXxjgbsm(java.lang.String xxjgbsm) {
		this.xxjgbsm = xxjgbsm;
	}

	public java.lang.String getXxjgbxlxm1() {
		return xxjgbxlxm1;
	}

	public void setXxjgbxlxm1(java.lang.String xxjgbxlxm1) {
		this.xxjgbxlxm1 = xxjgbxlxm1;
	}

	public java.lang.String getXxjgbxlxm2() {
		return xxjgbxlxm2;
	}

	public void setXxjgbxlxm2(java.lang.String xxjgbxlxm2) {
		this.xxjgbxlxm2 = xxjgbxlxm2;
	}

	public java.lang.String getXxjgbxlxm3() {
		return xxjgbxlxm3;
	}

	public void setXxjgbxlxm3(java.lang.String xxjgbxlxm3) {
		this.xxjgbxlxm3 = xxjgbxlxm3;
	}
	

	public Integer getClassRoomCnt() {
		return classRoomCnt;
	}

	public void setClassRoomCnt(Integer classRoomCnt) {
		this.classRoomCnt = classRoomCnt;
	}

	public String getXxjgszdcxflm() {
		return xxjgszdcxflm;
	}

	public void setXxjgszdcxflm(String xxjgszdcxflm) {
		this.xxjgszdcxflm = xxjgszdcxflm;
	}

	public String getXxjgbxlxm() {
		return xxjgbxlxm;
	}

	public void setXxjgbxlxm(String xxjgbxlxm) {
		this.xxjgbxlxm = xxjgbxlxm;
	}

	public String getSchoolStatus() {
		return schoolStatus;
	}

	public void setSchoolStatus(String schoolStatus) {
		this.schoolStatus = schoolStatus;
	}

	public Integer getResrecWx() {
		return resrecWx;
	}

	public void setResrecWx(Integer resrecWx) {
		this.resrecWx = resrecWx;
	}

	public String getResrecWxMac() {
		return resrecWxMac;
	}

	public void setResrecWxMac(String resrecWxMac) {
		this.resrecWxMac = resrecWxMac;
	}

	public String getResrecWxType() {
		return resrecWxType;
	}

	public void setResrecWxType(String resrecWxType) {
		this.resrecWxType = resrecWxType;
	}

	public Integer getResrecNet() {
		return resrecNet;
	}

	public void setResrecNet(Integer resrecNet) {
		this.resrecNet = resrecNet;
	}

	public String getResrecNetMac() {
		return resrecNetMac;
	}

	public void setResrecNetMac(String resrecNetMac) {
		this.resrecNetMac = resrecNetMac;
	}

	public String getResrecNetMac2() {
		return resrecNetMac2;
	}

	public void setResrecNetMac2(String resrecNetMac2) {
		this.resrecNetMac2 = resrecNetMac2;
	}

	public String getResrecNetMac3() {
		return resrecNetMac3;
	}

	public void setResrecNetMac3(String resrecNetMac3) {
		this.resrecNetMac3 = resrecNetMac3;
	}

	public String getResrecNetType() {
		return resrecNetType;
	}

	public void setResrecNetType(String resrecNetType) {
		this.resrecNetType = resrecNetType;
	}

	public String getResrecNetType2() {
		return resrecNetType2;
	}

	public void setResrecNetType2(String resrecNetType2) {
		this.resrecNetType2 = resrecNetType2;
	}

	public String getResrecNetType3() {
		return resrecNetType3;
	}

	public void setResrecNetType3(String resrecNetType3) {
		this.resrecNetType3 = resrecNetType3;
	}

	public String getResrecUserName() {
		return resrecUserName;
	}

	public void setResrecUserName(String resrecUserName) {
		this.resrecUserName = resrecUserName;
	}

	public String getResrecUserPhone() {
		return resrecUserPhone;
	}

	public void setResrecUserPhone(String resrecUserPhone) {
		this.resrecUserPhone = resrecUserPhone;
	}

	public String getResrecUserEmail() {
		return resrecUserEmail;
	}

	public void setResrecUserEmail(String resrecUserEmail) {
		this.resrecUserEmail = resrecUserEmail;
	}

	public String getResrecUserQQ() {
		return resrecUserQQ;
	}

	public void setResrecUserQQ(String resrecUserQQ) {
		this.resrecUserQQ = resrecUserQQ;
	}

	public String getResrecUserAddress() {
		return resrecUserAddress;
	}

	public void setResrecUserAddress(String resrecUserAddress) {
		this.resrecUserAddress = resrecUserAddress;
	}

	public String getResrecUserZipCode() {
		return resrecUserZipCode;
	}

	public void setResrecUserZipCode(String resrecUserZipCode) {
		this.resrecUserZipCode = resrecUserZipCode;
	}

	public String getSatJxdBookCat() {
		return satJxdBookCat;
	}

	public void setSatJxdBookCat(String satJxdBookCat) {
		this.satJxdBookCat = satJxdBookCat;
	}

	public String getSatXxBookCat() {
		return satXxBookCat;
	}

	public void setSatXxBookCat(String satXxBookCat) {
		this.satXxBookCat = satXxBookCat;
	}

	public String getSatZxBookCat() {
		return satZxBookCat;
	}

	public void setSatZxBookCat(String satZxBookCat) {
		this.satZxBookCat = satZxBookCat;
	}

	public String getNetJxdBookCat() {
		return netJxdBookCat;
	}

	public void setNetJxdBookCat(String netJxdBookCat) {
		this.netJxdBookCat = netJxdBookCat;
	}

	public String getNetXxBookCat() {
		return netXxBookCat;
	}

	public void setNetXxBookCat(String netXxBookCat) {
		this.netXxBookCat = netXxBookCat;
	}

	public String getNetZxBookCat() {
		return netZxBookCat;
	}

	public void setNetZxBookCat(String netZxBookCat) {
		this.netZxBookCat = netZxBookCat;
	}

	public String getNetJxdBookCat2() {
		return netJxdBookCat2;
	}

	public void setNetJxdBookCat2(String netJxdBookCat2) {
		this.netJxdBookCat2 = netJxdBookCat2;
	}

	public String getNetXxBookCat2() {
		return netXxBookCat2;
	}

	public void setNetXxBookCat2(String netXxBookCat2) {
		this.netXxBookCat2 = netXxBookCat2;
	}

	public String getNetZxBookCat2() {
		return netZxBookCat2;
	}

	public void setNetZxBookCat2(String netZxBookCat2) {
		this.netZxBookCat2 = netZxBookCat2;
	}

	public String getNetJxdBookCat3() {
		return netJxdBookCat3;
	}

	public void setNetJxdBookCat3(String netJxdBookCat3) {
		this.netJxdBookCat3 = netJxdBookCat3;
	}

	public String getNetXxBookCat3() {
		return netXxBookCat3;
	}

	public void setNetXxBookCat3(String netXxBookCat3) {
		this.netXxBookCat3 = netXxBookCat3;
	}

	public String getNetZxBookCat3() {
		return netZxBookCat3;
	}

	public void setNetZxBookCat3(String netZxBookCat3) {
		this.netZxBookCat3 = netZxBookCat3;
	}

	public Date getLastSubmitTime() {
		return lastSubmitTime;
	}

	public void setLastSubmitTime(Date lastSubmitTime) {
		this.lastSubmitTime = lastSubmitTime;
	}
	
	@Column(name = "SEND_CLASSMEET_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 11)
	private Integer sendClassMeetCnt;
	public Integer getSendClassMeetCnt() {
		return sendClassMeetCnt;
	}

	public void setSendClassMeetCnt(Integer sendClassMeetCnt) {
		this.sendClassMeetCnt = sendClassMeetCnt;
	}

	@Column(name = "REV_CLASSMEET_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 11)
	private Integer revClassMeetCnt;
	public Integer getRevClassMeetCnt() {
		return revClassMeetCnt;
	}

	public void setRevClassMeetCnt(Integer revClassMeetCnt) {
		this.revClassMeetCnt = revClassMeetCnt;
	}
	
	
	@Column(name = "EP_TRAIN_TEACHER_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 11)
	private Integer epTrainTeacherCnt;
	public Integer getEpTrainTeacherCnt() {
		return epTrainTeacherCnt;
	}
	public void setEpTrainTeacherCnt(Integer epTrainTeacherCnt) {
		this.epTrainTeacherCnt = epTrainTeacherCnt;
	}
	
	@Column(name = "GUOJIA_LEVEL_TEACHER_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	private Integer guojiaLevelTeacherCnt;
	public Integer getGuojiaLevelTeacherCnt() {
		return guojiaLevelTeacherCnt;
	}

	public void setGuojiaLevelTeacherCnt(Integer guojiaLevelTeacherCnt) {
		this.guojiaLevelTeacherCnt = guojiaLevelTeacherCnt;
	}
	@Column(name = "PROVICE_LEVEL_TEACHER_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	private Integer provinceLevelTeacherCnt;
	public Integer getProvinceLevelTeacherCnt() {
		return provinceLevelTeacherCnt;
	}

	public void setProvinceLevelTeacherCnt(Integer provinceLevelTeacherCnt) {
		this.provinceLevelTeacherCnt = provinceLevelTeacherCnt;
	}
	@Column(name = "CITY_LEVEL_TEACHER_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	private Integer cityLevelTeacherCnt;
	public Integer getCityLevelTeacherCnt() {
		return cityLevelTeacherCnt;
	}

	public void setCityLevelTeacherCnt(Integer cityLevelTeacherCnt) {
		this.cityLevelTeacherCnt = cityLevelTeacherCnt;
	}
	@Column(name = "COUNTY_LEVEL_TEACHER_CNT", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	private Integer countyLevelTeacherCnt;
	public Integer getCountyLevelTeacherCnt() {
		return countyLevelTeacherCnt;
	}

	public void setCountyLevelTeacherCnt(Integer countyLevelTeacherCnt) {
		this.countyLevelTeacherCnt = countyLevelTeacherCnt;
	}


	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("SchoolId",getId())
			.append("AreaId",getAreaId())
			.append("SchoolName",getSchoolName())
			.append("SchoolType",getSchoolType())
			.append("Address",getAddress())
			.append("Zipcode",getZipcode())
			.append("ProvinceId",getProvinceId())
			.append("CityId",getCityId())
			.append("CountyId",getCountyId())
			.append("EduSystem",getEduSystem())
			.append("IsWeak",getIsWeak())
			.append("CreTime",getCreTime())
			.append("CreUser",getCreUser())
			.append("ModTime",getModTime())
			.append("ModUser",getModUser())
			.append("IsIni",getIsIni())
			.append("IniUser",getIniUser())
			.append("IniTime",getIniTime())
			.append("DeleteFlag",getDeleteFlag())
			.append("DeleteUser",getDeleteUser())
			.append("DeleteTime",getDeleteTime())
			.append("PhotoPath",getPhotoPath())
			.append("StudentCnt",getStudentCnt())
			.append("TeacherCnt",getTeacherCnt())
			.append("LastUpdateTime",getLastUpdateTime())
			.append("IsIniTb",getIsIniTb())
			.append("IniTbUser",getIniTbUser())
			.append("IsSzmz",getIsSzmz())
			.append("Minzu",getMinzu())
			.append("SchoolProblemFlag",getSchoolProblemFlag())
			.append("SchoolProblemCause",getSchoolProblemCause())
			.append("SchoolProblemConfirm",getSchoolProblemConfirm())
			.append("SchoolProblemConfirmUser",getSchoolProblemConfirmUser())
			.append("SchoolProblemConfirmTime",getSchoolProblemConfirmTime())
			.append("DataProblemFlag",getDataProblemFlag())
			.append("DataProblemCause",getDataProblemCause())
			.append("DataProblemConfirm",getDataProblemConfirm())
			.append("DataProblemConfirmUser",getDataProblemConfirmUser())
			.append("DataProblemConfirmTime",getDataProblemConfirmTime())
			.append("IsXmSchool",getIsXmSchool())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BaseSchool == false) return false;
		if(this == obj) return true;
		BaseSchool other = (BaseSchool)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

