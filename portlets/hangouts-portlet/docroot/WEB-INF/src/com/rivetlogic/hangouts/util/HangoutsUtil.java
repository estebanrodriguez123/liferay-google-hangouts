package com.rivetlogic.hangouts.util;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.comparator.UserFirstNameComparator;
import com.liferay.portal.util.comparator.UserLastNameComparator;
import com.rivetlogic.hangouts.beans.UserBean;
import com.rivetlogic.hangouts.model.HangoutsGroup;
import com.rivetlogic.hangouts.service.HangoutsGroupLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author christopherjimenez
 *
 */
public class HangoutsUtil {
	private static final Log LOG = LogFactoryUtil.getLog(HangoutsUtil.class);
	
	private static UserBean parseUser(User user){
		UserBean userBean = new UserBean();
		userBean.setUserId(user.getUserId())
			.setFirstName(user.getFirstName())
			.setLastName(user.getLastName())
			.setEmail(user.getEmailAddress());
		return userBean;
	}
	
	public static UserBean getUserBean(Long userId){
		UserBean userBean = null;
		User user = null;
		try{
			user = UserLocalServiceUtil.getUser(userId);
			userBean = parseUser(user);
		}catch (Exception e) {
			LOG.error(e);
		}
		return userBean;
	}
	
	public static List<UserBean> getUserBeans(Long companyId, String search, int start, int end, OrderByComparator obc){
		List<UserBean> results = new ArrayList<UserBean>();
		List<User> users = null;
		UserBean userBean = null;
		try{
			if(search == null){
				users = UserLocalServiceUtil.search(companyId, null, WorkflowConstants.STATUS_APPROVED, null, start, end, obc);
			}else{
				users = UserLocalServiceUtil.search(companyId, search, null, search, null, null,
						WorkflowConstants.STATUS_APPROVED, null, false, start, end, obc);
			}
			
			for(User user : users){
				userBean = parseUser(user);
				results.add(userBean);
			}
		}catch (Exception e) {
			LOG.error(e);
		}
		
		return results;
	}
	
	public static int getUserBeansCount(Long companyId, String search){
		int count = Constants.DEFAULT_INT_VALUE;
		try{
			if(search == null){
				count = UserLocalServiceUtil.searchCount(companyId, null, WorkflowConstants.STATUS_APPROVED, null);
			}else{
				count = UserLocalServiceUtil.searchCount(companyId, search, null, search, null,
						null, WorkflowConstants.STATUS_APPROVED, null, false);
			}
			
		}catch(Exception e){
			LOG.error(e);
		}
		return count;
	}
	
	public static List<HangoutsGroup> getHangoutsGroups(Long userId, int start, int end, OrderByComparator obc){
		List<HangoutsGroup> groups = new ArrayList<HangoutsGroup>();
		try{
			groups = HangoutsGroupLocalServiceUtil.getHangoutsGroupByUserId(userId, start, end, obc);
		}catch (Exception e) {
			LOG.error(e);
		}
		return groups;
	}
	
	public static int getHangoutsGroupsCount(Long userId){
		int count = Constants.DEFAULT_INT_VALUE;
		try{
			count = HangoutsGroupLocalServiceUtil.getHangoutsGroupByUserIdCount(userId);
		}catch (Exception e) {
			LOG.error(e);
		}
		return count;
	}
	
	public static OrderByComparator getHangoutsComparator(String orderByCol, boolean asc){
		OrderByComparator obc = null;
		
		if(Constants.FIRST_NAME.equalsIgnoreCase(orderByCol)){
			obc = new UserFirstNameComparator(asc);
		}else if(Constants.LAST_NAME.equalsIgnoreCase(orderByCol)){
			obc = new UserLastNameComparator(asc);
		}
		return obc;
	}
	
	public List<HangoutsGroup> getHangoutsGroupByUserId(Long userId, int start, int end, OrderByComparator obc){
		List<HangoutsGroup> groups = new ArrayList<HangoutsGroup>();
		try{
			groups = HangoutsGroupLocalServiceUtil.getHangoutsGroupByUserId(userId, start, end, obc);
		}catch (Exception e) {
			LOG.error("Retrieving user hangouts groups: ", e);
		}
		return groups;
	}
	
	public static void returnJSONObject(PortletResponse response, JSONObject jsonObj) {
        HttpServletResponse servletResponse = PortalUtil.getHttpServletResponse(response);
        servletResponse.setHeader(HttpHeaders.CACHE_CONTROL, HttpHeaders.CACHE_CONTROL_NO_CACHE_VALUE);
		servletResponse.setHeader(HttpHeaders.PRAGMA, HttpHeaders.PRAGMA_NO_CACHE_VALUE);
		servletResponse.setHeader(HttpHeaders.EXPIRES, String.valueOf(Constants.UNDEFINED_ID));
        PrintWriter pw;
        try {
            pw = servletResponse.getWriter();
            pw.write(jsonObj.toString());
            pw.close();
        } catch (IOException e) {
            LOG.error("Error while returning json", e);
        }
    }

}
