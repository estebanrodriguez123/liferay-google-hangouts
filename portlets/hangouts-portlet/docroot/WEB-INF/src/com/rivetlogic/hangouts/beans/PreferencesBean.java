package com.rivetlogic.hangouts.beans;
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


import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.rivetlogic.hangouts.util.Constants;

import java.io.IOException;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

/**
 * @author christopherjimenez
 *
 */
public class PreferencesBean {
	private int usersPerPage;
	private int groupsPerPage;
	private String portletId;
	
	public PreferencesBean(PortletRequest request){
		PortletPreferences preferences = request.getPreferences();
		
		portletId = GetterUtil.getString(request.getAttribute(WebKeys.PORTLET_ID));
		usersPerPage = GetterUtil.getInteger(preferences.getValue(Constants.USERS_PER_PAGE,
				String.valueOf(Constants.DEFAULT_DELTA)));
		groupsPerPage = GetterUtil.getInteger(preferences.getValue(Constants.GROUPS_PER_PAGE,
				String.valueOf(Constants.DEFAULT_DELTA)));
	}
	
	public PreferencesBean(){
		usersPerPage = Constants.DEFAULT_INT_VALUE;
		groupsPerPage = Constants.DEFAULT_INT_VALUE;
	}
	
	public void save(PortletRequest request) throws ReadOnlyException, ValidatorException, IOException{
		PortletPreferences preferences = request.getPreferences();
		
		usersPerPage = ParamUtil.getInteger(request, Constants.USERS_PER_PAGE, usersPerPage);
		groupsPerPage = ParamUtil.getInteger(request, Constants.GROUPS_PER_PAGE, groupsPerPage);
		
		preferences.setValue(Constants.USERS_PER_PAGE, String.valueOf(usersPerPage));
		preferences.setValue(Constants.GROUPS_PER_PAGE, String.valueOf(groupsPerPage));
		
		preferences.store();
	}

	public int getUsersPerPage() {
		return usersPerPage;
	}

	public int getGroupsPerPage() {
		return groupsPerPage;
	}

	public String getPortletId(){
		return portletId;
	}
	
	public void setUsersPerPage(int usersPerPage) {
		this.usersPerPage = usersPerPage;
	}

	public void setGroupsPerPage(int groupsPerPage) {
		this.groupsPerPage = groupsPerPage;
	}
	
	public void setPortletId(String portletId){
		this.portletId = portletId;
	}
}
