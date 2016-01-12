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

package com.rivetlogic.hangouts.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.rivetlogic.hangouts.model.HangoutsGroup;
import com.rivetlogic.hangouts.service.base.HangoutsGroupLocalServiceBaseImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the hangouts group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.hangouts.service.HangoutsGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rivet Logic
 * @see com.rivetlogic.hangouts.service.base.HangoutsGroupLocalServiceBaseImpl
 * @see com.rivetlogic.hangouts.service.HangoutsGroupLocalServiceUtil
 */
public class HangoutsGroupLocalServiceImpl
	extends HangoutsGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.hangouts.service.HangoutsGroupLocalServiceUtil} to access the hangouts group local service.
	 */
    
private static final Log LOG = LogFactoryUtil.getLog(HangoutsGroupLocalServiceImpl.class);
    
    public List<HangoutsGroup> getHangoutsGroupByUserId(Long userId, int start, int end, OrderByComparator obc) throws SystemException{
        return hangoutsGroupPersistence.findByUserId(userId, start, end, obc);
    }
    
    public int getHangoutsGroupByUserIdCount(Long userId) throws SystemException{
        return hangoutsGroupPersistence.countByUserId(userId);
    }
    
    public HangoutsGroup createHangoutsGroup(HangoutsGroup hangoutsGroup) throws SystemException, PortalException{
        hangoutsGroup.setHangoutsGroupId(counterLocalService.increment(HangoutsGroup.class.getName()));
        User user = UserLocalServiceUtil.getUser(hangoutsGroup.getUserId());
        Date now = getTodayDate();
        
        hangoutsGroup.setUserName(user.getScreenName());
        hangoutsGroup.setCreateDate(now);
        hangoutsGroup.setModifiedDate(now);
        
        hangoutsGroupPersistence.update(hangoutsGroup);
        LOG.debug("New hangoutsGroup: " + hangoutsGroup.toJSON());
        return hangoutsGroup;
    }
    
    public HangoutsGroup updateHangoutsGroup(HangoutsGroup hangoutsGroup) throws SystemException{
        Date now = getTodayDate();
        hangoutsGroup.setModifiedDate(now);
        hangoutsGroupPersistence.update(hangoutsGroup);
        LOG.debug("Contacts: " + hangoutsGroup.getHangoutsContacts());
        return hangoutsGroup;
    }
    
    public HangoutsGroup findByUserIdAndGroupName(Long userId, String groupName){
        HangoutsGroup hangoutsGroup = null;
        try{
            hangoutsGroup = hangoutsGroupPersistence.findByUserIdAndGroupName(userId, groupName);
        }catch (Exception e) {
            
        }
        return hangoutsGroup;
    }
    
    public int countByUserIdAndGroupName(Long userId, String groupName){
        int count = 0;
        try {
            count = hangoutsGroupPersistence.countByUserIdAndGroupName(userId, groupName);
        } catch (SystemException e) {
            count = -1;
            LOG.error(e);
        }
        return count;
    }
    
    private Date getTodayDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
}