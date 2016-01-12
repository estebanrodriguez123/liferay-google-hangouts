/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.rivetlogic.hangouts.beans;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.rivetlogic.hangouts.util.Constants;
import com.rivetlogic.hangouts.util.HangoutsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author christopherjimenez
 *
 */
public class ContactsBean extends PaginationBean{
	private Long userId;
	private Long companyId;
	private String search;
	private List<UserBean> users;
	
	
	public ContactsBean(Long userId, Long companyId){
		super();
		this.userId = userId;
		this.companyId = companyId;
		this.users = new ArrayList<UserBean>();
		this.total = Constants.DEFAULT_INT_VALUE;
	}
	
	
	public JSONObject toJSON(){
		JSONObject doc = JSONFactoryUtil.createJSONObject();
		doc.put(Constants.USER_ID, userId);
		doc.put(Constants.COMPANY_ID, companyId);
		doc.put(Constants.TOTAL, total);
		doc.put(Constants.USERS, usersToJSON());
		
		return doc;
	}
	
	private JSONArray usersToJSON(){
		JSONArray jsonUsers = JSONFactoryUtil.createJSONArray();
		for(UserBean userBean : users){
			jsonUsers.put(userBean.toJSON());
		}
		return jsonUsers;
	}
	
	public String getSearch(){
		return search;
	}
	
	public void setSearch(String search){
		this.search = search;
	}
	
	@Override
	public void load(){
		total = HangoutsUtil.getUserBeansCount(companyId, search);
		users = HangoutsUtil.getUserBeans(companyId, search, start, end, obc);
	}
	
}
