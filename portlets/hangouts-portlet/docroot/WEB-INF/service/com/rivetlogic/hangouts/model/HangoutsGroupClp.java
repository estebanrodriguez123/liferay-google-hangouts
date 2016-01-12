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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rivetlogic.hangouts.service.ClpSerializer;
import com.rivetlogic.hangouts.service.HangoutsGroupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rivet Logic
 */
public class HangoutsGroupClp extends BaseModelImpl<HangoutsGroup>
	implements HangoutsGroup {
	public HangoutsGroupClp() {
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
	public long getPrimaryKey() {
		return _hangoutsGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHangoutsGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hangoutsGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getHangoutsGroupId() {
		return _hangoutsGroupId;
	}

	@Override
	public void setHangoutsGroupId(long hangoutsGroupId) {
		_hangoutsGroupId = hangoutsGroupId;

		if (_hangoutsGroupRemoteModel != null) {
			try {
				Class<?> clazz = _hangoutsGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setHangoutsGroupId", long.class);

				method.invoke(_hangoutsGroupRemoteModel, hangoutsGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_hangoutsGroupRemoteModel != null) {
			try {
				Class<?> clazz = _hangoutsGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_hangoutsGroupRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_hangoutsGroupRemoteModel != null) {
			try {
				Class<?> clazz = _hangoutsGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_hangoutsGroupRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_hangoutsGroupRemoteModel != null) {
			try {
				Class<?> clazz = _hangoutsGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_hangoutsGroupRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_hangoutsGroupRemoteModel != null) {
			try {
				Class<?> clazz = _hangoutsGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_hangoutsGroupRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupName() {
		return _groupName;
	}

	@Override
	public void setGroupName(String groupName) {
		_groupName = groupName;

		if (_hangoutsGroupRemoteModel != null) {
			try {
				Class<?> clazz = _hangoutsGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupName", String.class);

				method.invoke(_hangoutsGroupRemoteModel, groupName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHangoutsContacts() {
		return _hangoutsContacts;
	}

	@Override
	public void setHangoutsContacts(String hangoutsContacts) {
		_hangoutsContacts = hangoutsContacts;

		if (_hangoutsGroupRemoteModel != null) {
			try {
				Class<?> clazz = _hangoutsGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setHangoutsContacts",
						String.class);

				method.invoke(_hangoutsGroupRemoteModel, hangoutsContacts);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		try {
			String methodName = "toJSON";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.json.JSONObject returnObj = (com.liferay.portal.kernel.json.JSONObject)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getHangoutsGroupRemoteModel() {
		return _hangoutsGroupRemoteModel;
	}

	public void setHangoutsGroupRemoteModel(
		BaseModel<?> hangoutsGroupRemoteModel) {
		_hangoutsGroupRemoteModel = hangoutsGroupRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _hangoutsGroupRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_hangoutsGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HangoutsGroupLocalServiceUtil.addHangoutsGroup(this);
		}
		else {
			HangoutsGroupLocalServiceUtil.updateHangoutsGroup(this);
		}
	}

	@Override
	public HangoutsGroup toEscapedModel() {
		return (HangoutsGroup)ProxyUtil.newProxyInstance(HangoutsGroup.class.getClassLoader(),
			new Class[] { HangoutsGroup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HangoutsGroupClp clone = new HangoutsGroupClp();

		clone.setHangoutsGroupId(getHangoutsGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGroupName(getGroupName());
		clone.setHangoutsContacts(getHangoutsContacts());

		return clone;
	}

	@Override
	public int compareTo(HangoutsGroup hangoutsGroup) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				hangoutsGroup.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HangoutsGroupClp)) {
			return false;
		}

		HangoutsGroupClp hangoutsGroup = (HangoutsGroupClp)obj;

		long primaryKey = hangoutsGroup.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{hangoutsGroupId=");
		sb.append(getHangoutsGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", groupName=");
		sb.append(getGroupName());
		sb.append(", hangoutsContacts=");
		sb.append(getHangoutsContacts());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.hangouts.model.HangoutsGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hangoutsGroupId</column-name><column-value><![CDATA[");
		sb.append(getHangoutsGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupName</column-name><column-value><![CDATA[");
		sb.append(getGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hangoutsContacts</column-name><column-value><![CDATA[");
		sb.append(getHangoutsContacts());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hangoutsGroupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _groupName;
	private String _hangoutsContacts;
	private BaseModel<?> _hangoutsGroupRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.hangouts.service.ClpSerializer.class;
}