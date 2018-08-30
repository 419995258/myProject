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

//BaseRoleUrlMap
@Entity
@Table(name = "BASE_ROLE_URL_MAP")
public class BaseRoleUrlMap implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "MAP_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 40)
	//mapId
	private java.lang.String id;
		
	@Column(name = "URL_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	//urlId
	private java.lang.String urlId;
		
	@Column(name = "ROLE_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	//roleCode
	private java.lang.String roleCode;
		
	@Column(name = "ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	//roleId
	private java.lang.String roleId;



	

	
	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getUrlId() {
		return this.urlId;
	}
	
	public void setUrlId(java.lang.String value) {
		this.urlId = value;
	}
	
	public java.lang.String getRoleCode() {
		return this.roleCode;
	}
	
	public void setRoleCode(java.lang.String value) {
		this.roleCode = value;
	}
	
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("MapId",getId())
			.append("UrlId",getUrlId())
			.append("RoleCode",getRoleCode())
			.append("RoleId",getRoleId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BaseRoleUrlMap == false) return false;
		if(this == obj) return true;
		BaseRoleUrlMap other = (BaseRoleUrlMap)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

