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

package com.rivetlogic.hangouts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HangoutsGroupLocalService}.
 *
 * @author Rivet Logic
 * @see HangoutsGroupLocalService
 * @generated
 */
public class HangoutsGroupLocalServiceWrapper
	implements HangoutsGroupLocalService,
		ServiceWrapper<HangoutsGroupLocalService> {
	public HangoutsGroupLocalServiceWrapper(
		HangoutsGroupLocalService hangoutsGroupLocalService) {
		_hangoutsGroupLocalService = hangoutsGroupLocalService;
	}

	/**
	* Adds the hangouts group to the database. Also notifies the appropriate model listeners.
	*
	* @param hangoutsGroup the hangouts group
	* @return the hangouts group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup addHangoutsGroup(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.addHangoutsGroup(hangoutsGroup);
	}

	/**
	* Creates a new hangouts group with the primary key. Does not add the hangouts group to the database.
	*
	* @param hangoutsGroupId the primary key for the new hangouts group
	* @return the new hangouts group
	*/
	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup createHangoutsGroup(
		long hangoutsGroupId) {
		return _hangoutsGroupLocalService.createHangoutsGroup(hangoutsGroupId);
	}

	/**
	* Deletes the hangouts group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hangoutsGroupId the primary key of the hangouts group
	* @return the hangouts group that was removed
	* @throws PortalException if a hangouts group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup deleteHangoutsGroup(
		long hangoutsGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.deleteHangoutsGroup(hangoutsGroupId);
	}

	/**
	* Deletes the hangouts group from the database. Also notifies the appropriate model listeners.
	*
	* @param hangoutsGroup the hangouts group
	* @return the hangouts group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup deleteHangoutsGroup(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.deleteHangoutsGroup(hangoutsGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hangoutsGroupLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hangouts.model.impl.HangoutsGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hangouts.model.impl.HangoutsGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup fetchHangoutsGroup(
		long hangoutsGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.fetchHangoutsGroup(hangoutsGroupId);
	}

	/**
	* Returns the hangouts group with the primary key.
	*
	* @param hangoutsGroupId the primary key of the hangouts group
	* @return the hangouts group
	* @throws PortalException if a hangouts group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup getHangoutsGroup(
		long hangoutsGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.getHangoutsGroup(hangoutsGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> getHangoutsGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.getHangoutsGroups(start, end);
	}

	/**
	* Returns the number of hangouts groups.
	*
	* @return the number of hangouts groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHangoutsGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.getHangoutsGroupsCount();
	}

	/**
	* Updates the hangouts group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hangoutsGroup the hangouts group
	* @return the hangouts group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup updateHangoutsGroup(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.updateHangoutsGroup(hangoutsGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _hangoutsGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_hangoutsGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _hangoutsGroupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rivetlogic.hangouts.model.HangoutsGroup> getHangoutsGroupByUserId(
		java.lang.Long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.getHangoutsGroupByUserId(userId,
			start, end, obc);
	}

	@Override
	public int getHangoutsGroupByUserIdCount(java.lang.Long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.getHangoutsGroupByUserIdCount(userId);
	}

	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup createHangoutsGroup(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hangoutsGroupLocalService.createHangoutsGroup(hangoutsGroup);
	}

	@Override
	public com.rivetlogic.hangouts.model.HangoutsGroup findByUserIdAndGroupName(
		java.lang.Long userId, java.lang.String groupName) {
		return _hangoutsGroupLocalService.findByUserIdAndGroupName(userId,
			groupName);
	}

	@Override
	public int countByUserIdAndGroupName(java.lang.Long userId,
		java.lang.String groupName) {
		return _hangoutsGroupLocalService.countByUserIdAndGroupName(userId,
			groupName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HangoutsGroupLocalService getWrappedHangoutsGroupLocalService() {
		return _hangoutsGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHangoutsGroupLocalService(
		HangoutsGroupLocalService hangoutsGroupLocalService) {
		_hangoutsGroupLocalService = hangoutsGroupLocalService;
	}

	@Override
	public HangoutsGroupLocalService getWrappedService() {
		return _hangoutsGroupLocalService;
	}

	@Override
	public void setWrappedService(
		HangoutsGroupLocalService hangoutsGroupLocalService) {
		_hangoutsGroupLocalService = hangoutsGroupLocalService;
	}

	private HangoutsGroupLocalService _hangoutsGroupLocalService;
}