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

package com.rivetlogic.hangouts.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.hangouts.model.HangoutsGroup;

/**
 * The persistence interface for the hangouts group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see HangoutsGroupPersistenceImpl
 * @see HangoutsGroupUtil
 * @generated
 */
public interface HangoutsGroupPersistence extends BasePersistence<HangoutsGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HangoutsGroupUtil} to access the hangouts group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the hangouts groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hangouts groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hangouts.model.impl.HangoutsGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of hangouts groups
	* @param end the upper bound of the range of hangouts groups (not inclusive)
	* @return the range of matching hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hangouts groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hangouts.model.impl.HangoutsGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of hangouts groups
	* @param end the upper bound of the range of hangouts groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hangouts group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hangouts group
	* @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a matching hangouts group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hangouts.NoSuchHangoutsGroupException;

	/**
	* Returns the first hangouts group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hangouts group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hangouts group
	* @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a matching hangouts group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hangouts.NoSuchHangoutsGroupException;

	/**
	* Returns the last hangouts group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hangouts groups before and after the current hangouts group in the ordered set where userId = &#63;.
	*
	* @param hangoutsGroupId the primary key of the current hangouts group
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hangouts group
	* @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a hangouts group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup[] findByUserId_PrevAndNext(
		long hangoutsGroupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hangouts.NoSuchHangoutsGroupException;

	/**
	* Removes all the hangouts groups where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hangouts groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hangouts group where userId = &#63; and groupName = &#63; or throws a {@link com.rivetlogic.hangouts.NoSuchHangoutsGroupException} if it could not be found.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching hangouts group
	* @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a matching hangouts group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup findByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hangouts.NoSuchHangoutsGroupException;

	/**
	* Returns the hangouts group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup fetchByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hangouts group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup fetchByUserIdAndGroupName(
		long userId, java.lang.String groupName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the hangouts group where userId = &#63; and groupName = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the hangouts group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup removeByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hangouts.NoSuchHangoutsGroupException;

	/**
	* Returns the number of hangouts groups where userId = &#63; and groupName = &#63;.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the number of matching hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndGroupName(long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the hangouts group in the entity cache if it is enabled.
	*
	* @param hangoutsGroup the hangouts group
	*/
	public void cacheResult(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup);

	/**
	* Caches the hangouts groups in the entity cache if it is enabled.
	*
	* @param hangoutsGroups the hangouts groups
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> hangoutsGroups);

	/**
	* Creates a new hangouts group with the primary key. Does not add the hangouts group to the database.
	*
	* @param hangoutsGroupId the primary key for the new hangouts group
	* @return the new hangouts group
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup create(
		long hangoutsGroupId);

	/**
	* Removes the hangouts group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hangoutsGroupId the primary key of the hangouts group
	* @return the hangouts group that was removed
	* @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a hangouts group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup remove(
		long hangoutsGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hangouts.NoSuchHangoutsGroupException;

	public com.rivetlogic.hangouts.model.HangoutsGroup updateImpl(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hangouts group with the primary key or throws a {@link com.rivetlogic.hangouts.NoSuchHangoutsGroupException} if it could not be found.
	*
	* @param hangoutsGroupId the primary key of the hangouts group
	* @return the hangouts group
	* @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a hangouts group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup findByPrimaryKey(
		long hangoutsGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hangouts.NoSuchHangoutsGroupException;

	/**
	* Returns the hangouts group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hangoutsGroupId the primary key of the hangouts group
	* @return the hangouts group, or <code>null</code> if a hangouts group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.hangouts.model.HangoutsGroup fetchByPrimaryKey(
		long hangoutsGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the hangouts groups.
	*
	* @return the hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hangouts groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hangouts.model.impl.HangoutsGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hangouts groups
	* @param end the upper bound of the range of hangouts groups (not inclusive)
	* @return the range of hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hangouts groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hangouts.model.impl.HangoutsGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hangouts groups
	* @param end the upper bound of the range of hangouts groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hangouts groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hangouts groups.
	*
	* @return the number of hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}