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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Rivet Logic
 * @generated
 */
public class HangoutsGroupSoap implements Serializable {
	public static HangoutsGroupSoap toSoapModel(HangoutsGroup model) {
		HangoutsGroupSoap soapModel = new HangoutsGroupSoap();

		soapModel.setHangoutsGroupId(model.getHangoutsGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setHangoutsContacts(model.getHangoutsContacts());

		return soapModel;
	}

	public static HangoutsGroupSoap[] toSoapModels(HangoutsGroup[] models) {
		HangoutsGroupSoap[] soapModels = new HangoutsGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HangoutsGroupSoap[][] toSoapModels(HangoutsGroup[][] models) {
		HangoutsGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HangoutsGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HangoutsGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HangoutsGroupSoap[] toSoapModels(List<HangoutsGroup> models) {
		List<HangoutsGroupSoap> soapModels = new ArrayList<HangoutsGroupSoap>(models.size());

		for (HangoutsGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HangoutsGroupSoap[soapModels.size()]);
	}

	public HangoutsGroupSoap() {
	}

	public long getPrimaryKey() {
		return _hangoutsGroupId;
	}

	public void setPrimaryKey(long pk) {
		setHangoutsGroupId(pk);
	}

	public long getHangoutsGroupId() {
		return _hangoutsGroupId;
	}

	public void setHangoutsGroupId(long hangoutsGroupId) {
		_hangoutsGroupId = hangoutsGroupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public String getHangoutsContacts() {
		return _hangoutsContacts;
	}

	public void setHangoutsContacts(String hangoutsContacts) {
		_hangoutsContacts = hangoutsContacts;
	}

	private long _hangoutsGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _groupName;
	private String _hangoutsContacts;
}