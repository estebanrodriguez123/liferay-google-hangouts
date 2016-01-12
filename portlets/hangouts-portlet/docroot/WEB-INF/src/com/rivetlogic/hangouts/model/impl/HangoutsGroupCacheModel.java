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

package com.rivetlogic.hangouts.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.hangouts.model.HangoutsGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HangoutsGroup in entity cache.
 *
 * @author Rivet Logic
 * @see HangoutsGroup
 * @generated
 */
public class HangoutsGroupCacheModel implements CacheModel<HangoutsGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{hangoutsGroupId=");
		sb.append(hangoutsGroupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", hangoutsContacts=");
		sb.append(hangoutsContacts);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HangoutsGroup toEntityModel() {
		HangoutsGroupImpl hangoutsGroupImpl = new HangoutsGroupImpl();

		hangoutsGroupImpl.setHangoutsGroupId(hangoutsGroupId);
		hangoutsGroupImpl.setUserId(userId);

		if (userName == null) {
			hangoutsGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			hangoutsGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			hangoutsGroupImpl.setCreateDate(null);
		}
		else {
			hangoutsGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			hangoutsGroupImpl.setModifiedDate(null);
		}
		else {
			hangoutsGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (groupName == null) {
			hangoutsGroupImpl.setGroupName(StringPool.BLANK);
		}
		else {
			hangoutsGroupImpl.setGroupName(groupName);
		}

		if (hangoutsContacts == null) {
			hangoutsGroupImpl.setHangoutsContacts(StringPool.BLANK);
		}
		else {
			hangoutsGroupImpl.setHangoutsContacts(hangoutsContacts);
		}

		hangoutsGroupImpl.resetOriginalValues();

		return hangoutsGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		hangoutsGroupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		groupName = objectInput.readUTF();
		hangoutsContacts = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(hangoutsGroupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		if (hangoutsContacts == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hangoutsContacts);
		}
	}

	public long hangoutsGroupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String groupName;
	public String hangoutsContacts;
}