/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.hangouts.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HangoutsGroup}.
 * </p>
 *
 * @author Rivet Logic
 * @see HangoutsGroup
 * @generated
 */
public class HangoutsGroupWrapper implements HangoutsGroup,
	ModelWrapper<HangoutsGroup> {
	public HangoutsGroupWrapper(HangoutsGroup hangoutsGroup) {
		_hangoutsGroup = hangoutsGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return HangoutsGroup.class;
	}

	@Override
	public String getModelClassName() {
		return HangoutsGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hangoutsGroupId", getHangoutsGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupName", getGroupName());
		attributes.put("hangoutsContacts", getHangoutsContacts());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long hangoutsGroupId = (Long)attributes.get("hangoutsGroupId");

		if (hangoutsGroupId != null) {
			setHangoutsGroupId(hangoutsGroupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String hangoutsContacts = (String)attributes.get("hangoutsContacts");

		if (hangoutsContacts != null) {
			setHangoutsContacts(hangoutsContacts);
		}
	}

	/**
	* Returns the primary key of this hangouts group.
	*
	* @return the primary key of this hangouts group
	*/
	@Override
	public long getPrimaryKey() {
		return _hangoutsGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this hangouts group.
	*
	* @param primaryKey the primary key of this hangouts group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_hangoutsGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the hangouts group ID of this hangouts group.
	*
	* @return the hangouts group ID of this hangouts group
	*/
	@Override
	public long getHangoutsGroupId() {
		return _hangoutsGroup.getHangoutsGroupId();
	}

	/**
	* Sets the hangouts group ID of this hangouts group.
	*
	* @param hangoutsGroupId the hangouts group ID of this hangouts group
	*/
	@Override
	public void setHangoutsGroupId(long hangoutsGroupId) {
		_hangoutsGroup.setHangoutsGroupId(hangoutsGroupId);
	}

	/**
	* Returns the user ID of this hangouts group.
	*
	* @return the user ID of this hangouts group
	*/
	@Override
	public long getUserId() {
		return _hangoutsGroup.getUserId();
	}

	/**
	* Sets the user ID of this hangouts group.
	*
	* @param userId the user ID of this hangouts group
	*/
	@Override
	public void setUserId(long userId) {
		_hangoutsGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this hangouts group.
	*
	* @return the user uuid of this hangouts group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this hangouts group.
	*
	* @param userUuid the user uuid of this hangouts group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_hangoutsGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this hangouts group.
	*
	* @return the user name of this hangouts group
	*/
	@Override
	public java.lang.String getUserName() {
		return _hangoutsGroup.getUserName();
	}

	/**
	* Sets the user name of this hangouts group.
	*
	* @param userName the user name of this hangouts group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_hangoutsGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this hangouts group.
	*
	* @return the create date of this hangouts group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _hangoutsGroup.getCreateDate();
	}

	/**
	* Sets the create date of this hangouts group.
	*
	* @param createDate the create date of this hangouts group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_hangoutsGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this hangouts group.
	*
	* @return the modified date of this hangouts group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _hangoutsGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this hangouts group.
	*
	* @param modifiedDate the modified date of this hangouts group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_hangoutsGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the group name of this hangouts group.
	*
	* @return the group name of this hangouts group
	*/
	@Override
	public java.lang.String getGroupName() {
		return _hangoutsGroup.getGroupName();
	}

	/**
	* Sets the group name of this hangouts group.
	*
	* @param groupName the group name of this hangouts group
	*/
	@Override
	public void setGroupName(java.lang.String groupName) {
		_hangoutsGroup.setGroupName(groupName);
	}

	/**
	* Returns the hangouts contacts of this hangouts group.
	*
	* @return the hangouts contacts of this hangouts group
	*/
	@Override
	public java.lang.String getHangoutsContacts() {
		return _hangoutsGroup.getHangoutsContacts();
	}

	/**
	* Sets the hangouts contacts of this hangouts group.
	*
	* @param hangoutsContacts the hangouts contacts of this hangouts group
	*/
	@Override
	public void setHangoutsContacts(java.lang.String hangoutsContacts) {
		_hangoutsGroup.setHangoutsContacts(hangoutsContacts);
	}

	@Override
	public boolean isNew() {
		return _hangoutsGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_hangoutsGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _hangoutsGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_hangoutsGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _hangoutsGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _hangoutsGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hangoutsGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hangoutsGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_hangoutsGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_hangoutsGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hangoutsGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HangoutsGroupWrapper((HangoutsGroup)_hangoutsGroup.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup) {
		return _hangoutsGroup.compareTo(hangoutsGroup);
	}

	@Override
	public int hashCode() {
		return _hangoutsGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.hangouts.model.HangoutsGroup> toCacheModel() {
		return _hangoutsGroup.toCacheModel();
	}

	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup toEscapedModel() {
		return new HangoutsGroupWrapper(_hangoutsGroup.toEscapedModel());
	}

	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup toUnescapedModel() {
		return new HangoutsGroupWrapper(_hangoutsGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hangoutsGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _hangoutsGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hangoutsGroup.persist();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return _hangoutsGroup.toJSON();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HangoutsGroupWrapper)) {
			return false;
		}

		HangoutsGroupWrapper hangoutsGroupWrapper = (HangoutsGroupWrapper)obj;

		if (Validator.equals(_hangoutsGroup, hangoutsGroupWrapper._hangoutsGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HangoutsGroup getWrappedHangoutsGroup() {
		return _hangoutsGroup;
	}

	@Override
	public HangoutsGroup getWrappedModel() {
		return _hangoutsGroup;
	}

	@Override
	public void resetOriginalValues() {
		_hangoutsGroup.resetOriginalValues();
	}

	private HangoutsGroup _hangoutsGroup;
}