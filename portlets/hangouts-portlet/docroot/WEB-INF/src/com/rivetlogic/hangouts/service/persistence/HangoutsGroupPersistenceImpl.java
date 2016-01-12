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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.hangouts.NoSuchHangoutsGroupException;
import com.rivetlogic.hangouts.model.HangoutsGroup;
import com.rivetlogic.hangouts.model.impl.HangoutsGroupImpl;
import com.rivetlogic.hangouts.model.impl.HangoutsGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the hangouts group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see HangoutsGroupPersistence
 * @see HangoutsGroupUtil
 * @generated
 */
public class HangoutsGroupPersistenceImpl extends BasePersistenceImpl<HangoutsGroup>
	implements HangoutsGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HangoutsGroupUtil} to access the hangouts group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HangoutsGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED,
			HangoutsGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED,
			HangoutsGroupImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED,
			HangoutsGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED,
			HangoutsGroupImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			HangoutsGroupModelImpl.USERID_COLUMN_BITMASK |
			HangoutsGroupModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the hangouts groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching hangouts groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HangoutsGroup> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<HangoutsGroup> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

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
	@Override
	public List<HangoutsGroup> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<HangoutsGroup> list = (List<HangoutsGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (HangoutsGroup hangoutsGroup : list) {
				if ((userId != hangoutsGroup.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_HANGOUTSGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HangoutsGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<HangoutsGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HangoutsGroup>(list);
				}
				else {
					list = (List<HangoutsGroup>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first hangouts group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hangouts group
	 * @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a matching hangouts group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchHangoutsGroupException, SystemException {
		HangoutsGroup hangoutsGroup = fetchByUserId_First(userId,
				orderByComparator);

		if (hangoutsGroup != null) {
			return hangoutsGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHangoutsGroupException(msg.toString());
	}

	/**
	 * Returns the first hangouts group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<HangoutsGroup> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hangouts group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hangouts group
	 * @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a matching hangouts group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchHangoutsGroupException, SystemException {
		HangoutsGroup hangoutsGroup = fetchByUserId_Last(userId,
				orderByComparator);

		if (hangoutsGroup != null) {
			return hangoutsGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHangoutsGroupException(msg.toString());
	}

	/**
	 * Returns the last hangouts group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<HangoutsGroup> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public HangoutsGroup[] findByUserId_PrevAndNext(long hangoutsGroupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchHangoutsGroupException, SystemException {
		HangoutsGroup hangoutsGroup = findByPrimaryKey(hangoutsGroupId);

		Session session = null;

		try {
			session = openSession();

			HangoutsGroup[] array = new HangoutsGroupImpl[3];

			array[0] = getByUserId_PrevAndNext(session, hangoutsGroup, userId,
					orderByComparator, true);

			array[1] = hangoutsGroup;

			array[2] = getByUserId_PrevAndNext(session, hangoutsGroup, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HangoutsGroup getByUserId_PrevAndNext(Session session,
		HangoutsGroup hangoutsGroup, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HANGOUTSGROUP_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(HangoutsGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hangoutsGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HangoutsGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hangouts groups where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (HangoutsGroup hangoutsGroup : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(hangoutsGroup);
		}
	}

	/**
	 * Returns the number of hangouts groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching hangouts groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HANGOUTSGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "hangoutsGroup.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME = new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED,
			HangoutsGroupImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndGroupName",
			new String[] { Long.class.getName(), String.class.getName() },
			HangoutsGroupModelImpl.USERID_COLUMN_BITMASK |
			HangoutsGroupModelImpl.GROUPNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME = new FinderPath(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndGroupName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the hangouts group where userId = &#63; and groupName = &#63; or throws a {@link com.rivetlogic.hangouts.NoSuchHangoutsGroupException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the matching hangouts group
	 * @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a matching hangouts group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup findByUserIdAndGroupName(long userId, String groupName)
		throws NoSuchHangoutsGroupException, SystemException {
		HangoutsGroup hangoutsGroup = fetchByUserIdAndGroupName(userId,
				groupName);

		if (hangoutsGroup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", groupName=");
			msg.append(groupName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHangoutsGroupException(msg.toString());
		}

		return hangoutsGroup;
	}

	/**
	 * Returns the hangouts group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup fetchByUserIdAndGroupName(long userId, String groupName)
		throws SystemException {
		return fetchByUserIdAndGroupName(userId, groupName, true);
	}

	/**
	 * Returns the hangouts group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching hangouts group, or <code>null</code> if a matching hangouts group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup fetchByUserIdAndGroupName(long userId,
		String groupName, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, groupName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					finderArgs, this);
		}

		if (result instanceof HangoutsGroup) {
			HangoutsGroup hangoutsGroup = (HangoutsGroup)result;

			if ((userId != hangoutsGroup.getUserId()) ||
					!Validator.equals(groupName, hangoutsGroup.getGroupName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_HANGOUTSGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_USERID_2);

			boolean bindGroupName = false;

			if (groupName == null) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_1);
			}
			else if (groupName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_3);
			}
			else {
				bindGroupName = true;

				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindGroupName) {
					qPos.add(groupName);
				}

				List<HangoutsGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
						finderArgs, list);
				}
				else {
					HangoutsGroup hangoutsGroup = list.get(0);

					result = hangoutsGroup;

					cacheResult(hangoutsGroup);

					if ((hangoutsGroup.getUserId() != userId) ||
							(hangoutsGroup.getGroupName() == null) ||
							!hangoutsGroup.getGroupName().equals(groupName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
							finderArgs, hangoutsGroup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (HangoutsGroup)result;
		}
	}

	/**
	 * Removes the hangouts group where userId = &#63; and groupName = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the hangouts group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup removeByUserIdAndGroupName(long userId,
		String groupName) throws NoSuchHangoutsGroupException, SystemException {
		HangoutsGroup hangoutsGroup = findByUserIdAndGroupName(userId, groupName);

		return remove(hangoutsGroup);
	}

	/**
	 * Returns the number of hangouts groups where userId = &#63; and groupName = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the number of matching hangouts groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndGroupName(long userId, String groupName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME;

		Object[] finderArgs = new Object[] { userId, groupName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HANGOUTSGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_USERID_2);

			boolean bindGroupName = false;

			if (groupName == null) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_1);
			}
			else if (groupName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_3);
			}
			else {
				bindGroupName = true;

				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindGroupName) {
					qPos.add(groupName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_USERID_2 = "hangoutsGroup.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_1 = "hangoutsGroup.groupName IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_2 = "hangoutsGroup.groupName = ?";
	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_3 = "(hangoutsGroup.groupName IS NULL OR hangoutsGroup.groupName = '')";

	public HangoutsGroupPersistenceImpl() {
		setModelClass(HangoutsGroup.class);
	}

	/**
	 * Caches the hangouts group in the entity cache if it is enabled.
	 *
	 * @param hangoutsGroup the hangouts group
	 */
	@Override
	public void cacheResult(HangoutsGroup hangoutsGroup) {
		EntityCacheUtil.putResult(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupImpl.class, hangoutsGroup.getPrimaryKey(),
			hangoutsGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
			new Object[] { hangoutsGroup.getUserId(), hangoutsGroup.getGroupName() },
			hangoutsGroup);

		hangoutsGroup.resetOriginalValues();
	}

	/**
	 * Caches the hangouts groups in the entity cache if it is enabled.
	 *
	 * @param hangoutsGroups the hangouts groups
	 */
	@Override
	public void cacheResult(List<HangoutsGroup> hangoutsGroups) {
		for (HangoutsGroup hangoutsGroup : hangoutsGroups) {
			if (EntityCacheUtil.getResult(
						HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
						HangoutsGroupImpl.class, hangoutsGroup.getPrimaryKey()) == null) {
				cacheResult(hangoutsGroup);
			}
			else {
				hangoutsGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hangouts groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HangoutsGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HangoutsGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hangouts group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HangoutsGroup hangoutsGroup) {
		EntityCacheUtil.removeResult(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupImpl.class, hangoutsGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(hangoutsGroup);
	}

	@Override
	public void clearCache(List<HangoutsGroup> hangoutsGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HangoutsGroup hangoutsGroup : hangoutsGroups) {
			EntityCacheUtil.removeResult(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
				HangoutsGroupImpl.class, hangoutsGroup.getPrimaryKey());

			clearUniqueFindersCache(hangoutsGroup);
		}
	}

	protected void cacheUniqueFindersCache(HangoutsGroup hangoutsGroup) {
		if (hangoutsGroup.isNew()) {
			Object[] args = new Object[] {
					hangoutsGroup.getUserId(), hangoutsGroup.getGroupName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
				args, hangoutsGroup);
		}
		else {
			HangoutsGroupModelImpl hangoutsGroupModelImpl = (HangoutsGroupModelImpl)hangoutsGroup;

			if ((hangoutsGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hangoutsGroup.getUserId(), hangoutsGroup.getGroupName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					args, hangoutsGroup);
			}
		}
	}

	protected void clearUniqueFindersCache(HangoutsGroup hangoutsGroup) {
		HangoutsGroupModelImpl hangoutsGroupModelImpl = (HangoutsGroupModelImpl)hangoutsGroup;

		Object[] args = new Object[] {
				hangoutsGroup.getUserId(), hangoutsGroup.getGroupName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
			args);

		if ((hangoutsGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					hangoutsGroupModelImpl.getOriginalUserId(),
					hangoutsGroupModelImpl.getOriginalGroupName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
				args);
		}
	}

	/**
	 * Creates a new hangouts group with the primary key. Does not add the hangouts group to the database.
	 *
	 * @param hangoutsGroupId the primary key for the new hangouts group
	 * @return the new hangouts group
	 */
	@Override
	public HangoutsGroup create(long hangoutsGroupId) {
		HangoutsGroup hangoutsGroup = new HangoutsGroupImpl();

		hangoutsGroup.setNew(true);
		hangoutsGroup.setPrimaryKey(hangoutsGroupId);

		return hangoutsGroup;
	}

	/**
	 * Removes the hangouts group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hangoutsGroupId the primary key of the hangouts group
	 * @return the hangouts group that was removed
	 * @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a hangouts group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup remove(long hangoutsGroupId)
		throws NoSuchHangoutsGroupException, SystemException {
		return remove((Serializable)hangoutsGroupId);
	}

	/**
	 * Removes the hangouts group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hangouts group
	 * @return the hangouts group that was removed
	 * @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a hangouts group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup remove(Serializable primaryKey)
		throws NoSuchHangoutsGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HangoutsGroup hangoutsGroup = (HangoutsGroup)session.get(HangoutsGroupImpl.class,
					primaryKey);

			if (hangoutsGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHangoutsGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hangoutsGroup);
		}
		catch (NoSuchHangoutsGroupException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected HangoutsGroup removeImpl(HangoutsGroup hangoutsGroup)
		throws SystemException {
		hangoutsGroup = toUnwrappedModel(hangoutsGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hangoutsGroup)) {
				hangoutsGroup = (HangoutsGroup)session.get(HangoutsGroupImpl.class,
						hangoutsGroup.getPrimaryKeyObj());
			}

			if (hangoutsGroup != null) {
				session.delete(hangoutsGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (hangoutsGroup != null) {
			clearCache(hangoutsGroup);
		}

		return hangoutsGroup;
	}

	@Override
	public HangoutsGroup updateImpl(
		com.rivetlogic.hangouts.model.HangoutsGroup hangoutsGroup)
		throws SystemException {
		hangoutsGroup = toUnwrappedModel(hangoutsGroup);

		boolean isNew = hangoutsGroup.isNew();

		HangoutsGroupModelImpl hangoutsGroupModelImpl = (HangoutsGroupModelImpl)hangoutsGroup;

		Session session = null;

		try {
			session = openSession();

			if (hangoutsGroup.isNew()) {
				session.save(hangoutsGroup);

				hangoutsGroup.setNew(false);
			}
			else {
				session.merge(hangoutsGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HangoutsGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hangoutsGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hangoutsGroupModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { hangoutsGroupModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
			HangoutsGroupImpl.class, hangoutsGroup.getPrimaryKey(),
			hangoutsGroup);

		clearUniqueFindersCache(hangoutsGroup);
		cacheUniqueFindersCache(hangoutsGroup);

		return hangoutsGroup;
	}

	protected HangoutsGroup toUnwrappedModel(HangoutsGroup hangoutsGroup) {
		if (hangoutsGroup instanceof HangoutsGroupImpl) {
			return hangoutsGroup;
		}

		HangoutsGroupImpl hangoutsGroupImpl = new HangoutsGroupImpl();

		hangoutsGroupImpl.setNew(hangoutsGroup.isNew());
		hangoutsGroupImpl.setPrimaryKey(hangoutsGroup.getPrimaryKey());

		hangoutsGroupImpl.setHangoutsGroupId(hangoutsGroup.getHangoutsGroupId());
		hangoutsGroupImpl.setUserId(hangoutsGroup.getUserId());
		hangoutsGroupImpl.setUserName(hangoutsGroup.getUserName());
		hangoutsGroupImpl.setCreateDate(hangoutsGroup.getCreateDate());
		hangoutsGroupImpl.setModifiedDate(hangoutsGroup.getModifiedDate());
		hangoutsGroupImpl.setGroupName(hangoutsGroup.getGroupName());
		hangoutsGroupImpl.setHangoutsContacts(hangoutsGroup.getHangoutsContacts());

		return hangoutsGroupImpl;
	}

	/**
	 * Returns the hangouts group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hangouts group
	 * @return the hangouts group
	 * @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a hangouts group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHangoutsGroupException, SystemException {
		HangoutsGroup hangoutsGroup = fetchByPrimaryKey(primaryKey);

		if (hangoutsGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHangoutsGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return hangoutsGroup;
	}

	/**
	 * Returns the hangouts group with the primary key or throws a {@link com.rivetlogic.hangouts.NoSuchHangoutsGroupException} if it could not be found.
	 *
	 * @param hangoutsGroupId the primary key of the hangouts group
	 * @return the hangouts group
	 * @throws com.rivetlogic.hangouts.NoSuchHangoutsGroupException if a hangouts group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup findByPrimaryKey(long hangoutsGroupId)
		throws NoSuchHangoutsGroupException, SystemException {
		return findByPrimaryKey((Serializable)hangoutsGroupId);
	}

	/**
	 * Returns the hangouts group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hangouts group
	 * @return the hangouts group, or <code>null</code> if a hangouts group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		HangoutsGroup hangoutsGroup = (HangoutsGroup)EntityCacheUtil.getResult(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
				HangoutsGroupImpl.class, primaryKey);

		if (hangoutsGroup == _nullHangoutsGroup) {
			return null;
		}

		if (hangoutsGroup == null) {
			Session session = null;

			try {
				session = openSession();

				hangoutsGroup = (HangoutsGroup)session.get(HangoutsGroupImpl.class,
						primaryKey);

				if (hangoutsGroup != null) {
					cacheResult(hangoutsGroup);
				}
				else {
					EntityCacheUtil.putResult(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
						HangoutsGroupImpl.class, primaryKey, _nullHangoutsGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HangoutsGroupModelImpl.ENTITY_CACHE_ENABLED,
					HangoutsGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return hangoutsGroup;
	}

	/**
	 * Returns the hangouts group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hangoutsGroupId the primary key of the hangouts group
	 * @return the hangouts group, or <code>null</code> if a hangouts group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangoutsGroup fetchByPrimaryKey(long hangoutsGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)hangoutsGroupId);
	}

	/**
	 * Returns all the hangouts groups.
	 *
	 * @return the hangouts groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HangoutsGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<HangoutsGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<HangoutsGroup> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<HangoutsGroup> list = (List<HangoutsGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HANGOUTSGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HANGOUTSGROUP;

				if (pagination) {
					sql = sql.concat(HangoutsGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HangoutsGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HangoutsGroup>(list);
				}
				else {
					list = (List<HangoutsGroup>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the hangouts groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (HangoutsGroup hangoutsGroup : findAll()) {
			remove(hangoutsGroup);
		}
	}

	/**
	 * Returns the number of hangouts groups.
	 *
	 * @return the number of hangouts groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HANGOUTSGROUP);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the hangouts group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.hangouts.model.HangoutsGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HangoutsGroup>> listenersList = new ArrayList<ModelListener<HangoutsGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HangoutsGroup>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(HangoutsGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HANGOUTSGROUP = "SELECT hangoutsGroup FROM HangoutsGroup hangoutsGroup";
	private static final String _SQL_SELECT_HANGOUTSGROUP_WHERE = "SELECT hangoutsGroup FROM HangoutsGroup hangoutsGroup WHERE ";
	private static final String _SQL_COUNT_HANGOUTSGROUP = "SELECT COUNT(hangoutsGroup) FROM HangoutsGroup hangoutsGroup";
	private static final String _SQL_COUNT_HANGOUTSGROUP_WHERE = "SELECT COUNT(hangoutsGroup) FROM HangoutsGroup hangoutsGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hangoutsGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HangoutsGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HangoutsGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HangoutsGroupPersistenceImpl.class);
	private static HangoutsGroup _nullHangoutsGroup = new HangoutsGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HangoutsGroup> toCacheModel() {
				return _nullHangoutsGroupCacheModel;
			}
		};

	private static CacheModel<HangoutsGroup> _nullHangoutsGroupCacheModel = new CacheModel<HangoutsGroup>() {
			@Override
			public HangoutsGroup toEntityModel() {
				return _nullHangoutsGroup;
			}
		};
}