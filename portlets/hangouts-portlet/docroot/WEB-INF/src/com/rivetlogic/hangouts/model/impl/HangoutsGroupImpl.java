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

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.hangouts.util.Constants;
import com.rivetlogic.hangouts.beans.UserBean;
import com.rivetlogic.hangouts.util.HangoutsUtil;

/**
 * The extended model implementation for the HangoutsGroup service. Represents a row in the &quot;rivetlogic_hangouts_HangoutsGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.hangouts.model.HangoutsGroup} interface.
 * </p>
 *
 * @author Rivet Logic
 */
public class HangoutsGroupImpl extends HangoutsGroupBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a hangouts group model instance should use the {@link com.rivetlogic.hangouts.model.HangoutsGroup} interface instead.
	 */
    
    private static final Log LOG = LogFactoryUtil.getLog(HangoutsGroupBaseImpl.class);
    
	public HangoutsGroupImpl() {
	}
	
	public JSONObject toJSON(){
        JSONObject doc = JSONFactoryUtil.createJSONObject();
        doc.put(Constants.HANGOUTS_GROUP_ID, getHangoutsGroupId());
        doc.put(Constants.HANGOUTS_GROUP_NAME, getGroupName());
        doc.put(Constants.USER_ID, getUserId());
        doc.put(Constants.USER_NAME, getUserName());
        doc.put(Constants.CREATE_DATE, getCreateDate());
        doc.put(Constants.MODIFIED_DATE, getModifiedDate());
        doc.put(Constants.IDS, getContactsArray());
        return doc;
    }
	
	private JSONArray getContactsArray() {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        Long userId = null;
        UserBean ub = null;
        JSONObject item = null;
        JSONObject value = null;
        JSONArray contacts = null;
        try {
            contacts = JSONFactoryUtil.createJSONArray(getHangoutsContacts());
            if(contacts != null){
                for(int i = 0;  contacts.length() > i; i++){
                    item = contacts.getJSONObject(i);
                    userId = item.getLong(Constants.USER_ID);
                    ub = HangoutsUtil.getUserBean(userId);
                    if(ub != null){
                        value = JSONFactoryUtil.createJSONObject();
                        value.put(Constants.FIRST_NAME, ub.getFirstName());
                        value.put(Constants.LAST_NAME, ub.getLastName());
                        value.put(Constants.USER_ID, ub.getUserId());
                        value.put(Constants.EMAIL, ub.getEmail());
                        
                        array.put(value);
                    }
                }
            }
            
        } catch (JSONException e) {
            LOG.error(e);
        }
        
        return array;
    }
}