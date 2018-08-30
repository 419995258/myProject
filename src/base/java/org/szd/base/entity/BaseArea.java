package org.szd.base.entity;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */

//行政区划表
@Entity
@Table(name = "BASE_AREA")
public class BaseArea implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "AREA_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 40)
	//areaId
	private java.lang.String id;
		
	@Column(name = "AREA_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	//areaCode
	private java.lang.String areaCode;
		
	@Column(name = "PARENT_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	//parentCode
	private java.lang.String parentCode;
		
	@Column(name = "NODE_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	//nodeType
	private java.lang.String nodeType;
		
	@Column(name = "AREA_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	//areaName
	private java.lang.String areaName;
		
	@Column(name = "AREA_DESC", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//areaDesc
	private java.lang.String areaDesc;
		
	@Column(name = "AREA_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//中部、东部、西部
	private java.lang.String areaType;
		
	@Column(name = "NODE_LEVEL", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//nodeLevel
	private Integer nodeLevel;
		
	@Column(name = "NATIONAL_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//国家行政区划编码
	private java.lang.String nationalCode;
		
	@Column(name = "SEQ_NO", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//seqNo
	private Integer seqNo;
		
	@Column(name = "CRE_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//creUser
	private java.lang.String creUser;
		
	@Column(name = "MOD_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//modUser
	private java.lang.String modUser;
		
	@Column(name = "CRE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//creTime
	private java.util.Date creTime;
		
	@Column(name = "MOD_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//modTime
	private java.util.Date modTime;
		
	@Column(name = "DELETE_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//已删除：1 未删除：0
	private Integer deleteFlag;
		
	@Column(name = "IS_INI", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//IS_INI 是否初始化，1为初始化，0为未初始化 默认：0
	private Integer isIni;
		
	@Column(name = "INI_USER", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	//iniUser
	private java.lang.String iniUser;
		
	@Column(name = "INI_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//iniTime
	private java.util.Date iniTime;
		
	@Column(name = "LAST_UPDATE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//lastUpdateTime
	private java.util.Date lastUpdateTime;
	
	@Column(name = "LAST_SUBMIT_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//lastSubmitTime
	private java.util.Date lastSubmitTime;
		
	@Column(name = "MAP_AREA_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//mapAreaCode
	private java.lang.String mapAreaCode;
		
	@Column(name = "MAP_PARENT_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//mapParentCode
	private java.lang.String mapParentCode;
		
	@Column(name = "IS_MAP_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	//是否显示地图 显示：1 不显示：0 默认为：1
	private Integer isMapFlag;

	@Column(name = "AREA_TYPE_STAT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	private Long areaTypeStat;
	
	@Column(name = "jyglbmdm", unique = false, nullable = true, insertable = true, updatable = true)
	//教育管理部门代码
	private String jyglbmdm;
	@Column(name = "MAP_COLOR_RGB", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	private String mapColorRgb;
	
	//使用中
	@Column(name = "IN_USE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	//areaCode
	private java.lang.String inUse;
	
	@Column(name = "UPDATE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	//lastSubmitTime
	private java.util.Date updateTime;
	public String getMapColorRgb() {
		return mapColorRgb;
	}

	public void setMapColorRgb(String mapColorRgb) {
		this.mapColorRgb = mapColorRgb;
	}
	
	public String getJyglbmdm() {
		return jyglbmdm;
	}

	public void setJyglbmdm(String jyglbmdm) {
		this.jyglbmdm = jyglbmdm;
	}

	public Long getAreaTypeStat() {
		return areaTypeStat;
	}

	public void setAreaTypeStat(Long areaTypeStat) {
		this.areaTypeStat = areaTypeStat;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getAreaCode() {
		return this.areaCode;
	}
	
	public void setAreaCode(java.lang.String value) {
		this.areaCode = value;
	}
	
	public java.lang.String getParentCode() {
		return this.parentCode;
	}
	
	public void setParentCode(java.lang.String value) {
		this.parentCode = value;
	}
	
	public java.lang.String getNodeType() {
		return this.nodeType;
	}
	
	public void setNodeType(java.lang.String value) {
		this.nodeType = value;
	}
	
	public java.lang.String getAreaName() {
		return this.areaName;
	}
	
	public void setAreaName(java.lang.String value) {
		this.areaName = value;
	}
	
	public java.lang.String getAreaDesc() {
		return this.areaDesc;
	}
	
	public void setAreaDesc(java.lang.String value) {
		this.areaDesc = value;
	}
	
	public java.lang.String getAreaType() {
		return this.areaType;
	}
	
	public void setAreaType(java.lang.String value) {
		this.areaType = value;
	}
	
	public Integer getNodeLevel() {
		return this.nodeLevel;
	}
	
	public void setNodeLevel(Integer value) {
		this.nodeLevel = value;
	}
	
	public java.lang.String getNationalCode() {
		return this.nationalCode;
	}
	
	public void setNationalCode(java.lang.String value) {
		this.nationalCode = value;
	}
	
	public Integer getSeqNo() {
		return this.seqNo;
	}
	
	public void setSeqNo(Integer value) {
		this.seqNo = value;
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
	
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
	
	public void setDeleteFlag(Integer value) {
		this.deleteFlag = value;
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
	
	public java.util.Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}
	
	public void setLastUpdateTime(java.util.Date value) {
		this.lastUpdateTime = value;
	}
	
	public java.lang.String getMapAreaCode() {
		return this.mapAreaCode;
	}
	
	public void setMapAreaCode(java.lang.String value) {
		this.mapAreaCode = value;
	}
	
	public java.lang.String getMapParentCode() {
		return this.mapParentCode;
	}
	
	public void setMapParentCode(java.lang.String value) {
		this.mapParentCode = value;
	}
	
	public Integer getIsMapFlag() {
		return this.isMapFlag;
	}
	
	public void setIsMapFlag(Integer value) {
		this.isMapFlag = value;
	}
	

	public java.util.Date getLastSubmitTime() {
		return lastSubmitTime;
	}

	public void setLastSubmitTime(java.util.Date lastSubmitTime) {
		this.lastSubmitTime = lastSubmitTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("AreaId",getId())
			.append("AreaCode",getAreaCode())
			.append("ParentCode",getParentCode())
			.append("NodeType",getNodeType())
			.append("AreaName",getAreaName())
			.append("AreaDesc",getAreaDesc())
			.append("AreaType",getAreaType())
			.append("NodeLevel",getNodeLevel())
			.append("NationalCode",getNationalCode())
			.append("SeqNo",getSeqNo())
			.append("CreUser",getCreUser())
			.append("ModUser",getModUser())
			.append("CreTime",getCreTime())
			.append("ModTime",getModTime())
			.append("DeleteFlag",getDeleteFlag())
			.append("IsIni",getIsIni())
			.append("IniUser",getIniUser())
			.append("IniTime",getIniTime())
			.append("LastUpdateTime",getLastUpdateTime())
			.append("MapAreaCode",getMapAreaCode())
			.append("MapParentCode",getMapParentCode())
			.append("IsMapFlag",getIsMapFlag())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BaseArea == false) return false;
		if(this == obj) return true;
		BaseArea other = (BaseArea)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	/**
	 * @return the inUse
	 */
	public java.lang.String getInUse() {
		return inUse;
	}

	/**
	 * @param inUse the inUse to set
	 */
	public void setInUse(java.lang.String inUse) {
		this.inUse = inUse;
	}

	/**
	 * @return the updateTime
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
}

