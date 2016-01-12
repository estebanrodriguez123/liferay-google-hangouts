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

package com.rivetlogic.hangouts.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author christopherjimenez
 *
 */
public class Constants {
    public static final String PROP_DELTA = "default.delta.view";
    
    public static final String SIGNED_IN = "isSignedIn";
    public static final int DEFAULT_INT_VALUE = 0;
    public static final int DEFAULT_ELEMENT_VALUE = 1;
    public static final int UNDEFINED_ID = -1;
    public static final Long DEFAULT_ELEMENT_ID = 0L;
    public static final int DEFAULT_DELTA = GetterUtil.getInteger(PortletProps.get(PROP_DELTA));
    
    //Json Names
    public static final String COMPANY_ID = "company-id";
    public static final String CREATE_DATE = "create-date";
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "first-name";
    public static final String HANGOUTS_GROUP_ID = "hangouts-group-id";
    public static final String HANGOUTS_GROUP_NAME = "hangouts-group-name";
    public static final String GROUP_INFO = "group-info";
    public static final String GROUPS = "groups";
    public static final String IDS = "ids";
    public static final String LAST_NAME = "last-name";
    public static final String MODIFIED_DATE = "modified-date";
    public static final String TOTAL = "total";
    public static final String USER_ID = "user-id";
    public static final String USER_NAME = "user-name";
    public static final String USERS = "users";
    
    
    //CMD
    public static final String CMD = "hangoutscmd";
    public static final String CMD_ADD_GROUP = "add-group";
    public static final String CMD_GET_GROUP = "get-group";
    public static final String CMD_LIST_GROUPS = "list-groups";
    public static final String CMD_LIST_USERS = "list-users";
    public static final String CMD_REMOVE_GROUP = "remove-group";
    public static final String CMD_SUCCESS = "success";
    public static final String CMD_UPDATE_GROUP = "update-group";
    public static final String CMD_UPDATE_GROUP_NAME = "update-group-name";
    
    //Parameters Names
    public static String CURRENT_PAGE = "curPage";
    public static String DELTA = "delta";
    public static String ORDER_BY_COL = "orderByCol";
    public static String IS_ASC = "isAsc";
    public static String SEARCH = "search";
    
    //Preferences Params
    public static String USERS_PER_PAGE = "usersPerPage";
    public static String GROUPS_PER_PAGE = "groupsPerPage";
    public static String PREF_BEAN = "prefBean";
    
    //Error messages
    public static String ERRORS = "errors"; 
    public static String EMPTY_GROUP_NAME = "empty.group.name";
    public static String EMPTY_CONTACTS = "empty.contacts";
    public static String NOT_UNIQUE_GROUP = "not.unique.group";
    public static String UNEXPECTED_ERROR = "unexpected.error";
    
}
