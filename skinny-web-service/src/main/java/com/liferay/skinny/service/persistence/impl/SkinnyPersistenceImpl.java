/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.skinny.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.skinny.exception.NoSuchSkinnyException;
import com.liferay.skinny.model.Skinny;
import com.liferay.skinny.model.impl.SkinnyImpl;
import com.liferay.skinny.model.impl.SkinnyModelImpl;
import com.liferay.skinny.service.persistence.SkinnyPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the skinny service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyPersistence
 * @see com.liferay.skinny.service.persistence.SkinnyUtil
 * @generated
 */
@ProviderType
public class SkinnyPersistenceImpl extends BasePersistenceImpl<Skinny>
	implements SkinnyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SkinnyUtil} to access the skinny persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SkinnyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
			SkinnyModelImpl.FINDER_CACHE_ENABLED, SkinnyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
			SkinnyModelImpl.FINDER_CACHE_ENABLED, SkinnyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
			SkinnyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SkinnyPersistenceImpl() {
		setModelClass(Skinny.class);
	}

	/**
	 * Caches the skinny in the entity cache if it is enabled.
	 *
	 * @param skinny the skinny
	 */
	@Override
	public void cacheResult(Skinny skinny) {
		entityCache.putResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
			SkinnyImpl.class, skinny.getPrimaryKey(), skinny);

		skinny.resetOriginalValues();
	}

	/**
	 * Caches the skinnies in the entity cache if it is enabled.
	 *
	 * @param skinnies the skinnies
	 */
	@Override
	public void cacheResult(List<Skinny> skinnies) {
		for (Skinny skinny : skinnies) {
			if (entityCache.getResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
						SkinnyImpl.class, skinny.getPrimaryKey()) == null) {
				cacheResult(skinny);
			}
			else {
				skinny.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all skinnies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SkinnyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skinny.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Skinny skinny) {
		entityCache.removeResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
			SkinnyImpl.class, skinny.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Skinny> skinnies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Skinny skinny : skinnies) {
			entityCache.removeResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
				SkinnyImpl.class, skinny.getPrimaryKey());
		}
	}

	/**
	 * Creates a new skinny with the primary key. Does not add the skinny to the database.
	 *
	 * @param dummyId the primary key for the new skinny
	 * @return the new skinny
	 */
	@Override
	public Skinny create(long dummyId) {
		Skinny skinny = new SkinnyImpl();

		skinny.setNew(true);
		skinny.setPrimaryKey(dummyId);

		return skinny;
	}

	/**
	 * Removes the skinny with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dummyId the primary key of the skinny
	 * @return the skinny that was removed
	 * @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	 */
	@Override
	public Skinny remove(long dummyId) throws NoSuchSkinnyException {
		return remove((Serializable)dummyId);
	}

	/**
	 * Removes the skinny with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skinny
	 * @return the skinny that was removed
	 * @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	 */
	@Override
	public Skinny remove(Serializable primaryKey) throws NoSuchSkinnyException {
		Session session = null;

		try {
			session = openSession();

			Skinny skinny = (Skinny)session.get(SkinnyImpl.class, primaryKey);

			if (skinny == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkinnyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skinny);
		}
		catch (NoSuchSkinnyException nsee) {
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
	protected Skinny removeImpl(Skinny skinny) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skinny)) {
				skinny = (Skinny)session.get(SkinnyImpl.class,
						skinny.getPrimaryKeyObj());
			}

			if (skinny != null) {
				session.delete(skinny);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skinny != null) {
			clearCache(skinny);
		}

		return skinny;
	}

	@Override
	public Skinny updateImpl(Skinny skinny) {
		boolean isNew = skinny.isNew();

		Session session = null;

		try {
			session = openSession();

			if (skinny.isNew()) {
				session.save(skinny);

				skinny.setNew(false);
			}
			else {
				skinny = (Skinny)session.merge(skinny);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
			SkinnyImpl.class, skinny.getPrimaryKey(), skinny, false);

		skinny.resetOriginalValues();

		return skinny;
	}

	/**
	 * Returns the skinny with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skinny
	 * @return the skinny
	 * @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	 */
	@Override
	public Skinny findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkinnyException {
		Skinny skinny = fetchByPrimaryKey(primaryKey);

		if (skinny == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkinnyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skinny;
	}

	/**
	 * Returns the skinny with the primary key or throws a {@link NoSuchSkinnyException} if it could not be found.
	 *
	 * @param dummyId the primary key of the skinny
	 * @return the skinny
	 * @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	 */
	@Override
	public Skinny findByPrimaryKey(long dummyId) throws NoSuchSkinnyException {
		return findByPrimaryKey((Serializable)dummyId);
	}

	/**
	 * Returns the skinny with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skinny
	 * @return the skinny, or <code>null</code> if a skinny with the primary key could not be found
	 */
	@Override
	public Skinny fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
				SkinnyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Skinny skinny = (Skinny)serializable;

		if (skinny == null) {
			Session session = null;

			try {
				session = openSession();

				skinny = (Skinny)session.get(SkinnyImpl.class, primaryKey);

				if (skinny != null) {
					cacheResult(skinny);
				}
				else {
					entityCache.putResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
						SkinnyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
					SkinnyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skinny;
	}

	/**
	 * Returns the skinny with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dummyId the primary key of the skinny
	 * @return the skinny, or <code>null</code> if a skinny with the primary key could not be found
	 */
	@Override
	public Skinny fetchByPrimaryKey(long dummyId) {
		return fetchByPrimaryKey((Serializable)dummyId);
	}

	@Override
	public Map<Serializable, Skinny> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Skinny> map = new HashMap<Serializable, Skinny>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Skinny skinny = fetchByPrimaryKey(primaryKey);

			if (skinny != null) {
				map.put(primaryKey, skinny);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
					SkinnyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Skinny)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SKINNY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Skinny skinny : (List<Skinny>)q.list()) {
				map.put(skinny.getPrimaryKeyObj(), skinny);

				cacheResult(skinny);

				uncachedPrimaryKeys.remove(skinny.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SkinnyModelImpl.ENTITY_CACHE_ENABLED,
					SkinnyImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the skinnies.
	 *
	 * @return the skinnies
	 */
	@Override
	public List<Skinny> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skinnies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkinnyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skinnies
	 * @param end the upper bound of the range of skinnies (not inclusive)
	 * @return the range of skinnies
	 */
	@Override
	public List<Skinny> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the skinnies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkinnyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skinnies
	 * @param end the upper bound of the range of skinnies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skinnies
	 */
	@Override
	public List<Skinny> findAll(int start, int end,
		OrderByComparator<Skinny> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the skinnies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkinnyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skinnies
	 * @param end the upper bound of the range of skinnies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of skinnies
	 */
	@Override
	public List<Skinny> findAll(int start, int end,
		OrderByComparator<Skinny> orderByComparator, boolean retrieveFromCache) {
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

		List<Skinny> list = null;

		if (retrieveFromCache) {
			list = (List<Skinny>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SKINNY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKINNY;

				if (pagination) {
					sql = sql.concat(SkinnyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Skinny>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Skinny>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the skinnies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Skinny skinny : findAll()) {
			remove(skinny);
		}
	}

	/**
	 * Returns the number of skinnies.
	 *
	 * @return the number of skinnies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKINNY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SkinnyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the skinny persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SkinnyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SKINNY = "SELECT skinny FROM Skinny skinny";
	private static final String _SQL_SELECT_SKINNY_WHERE_PKS_IN = "SELECT skinny FROM Skinny skinny WHERE dummyId IN (";
	private static final String _SQL_COUNT_SKINNY = "SELECT COUNT(skinny) FROM Skinny skinny";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skinny.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Skinny exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SkinnyPersistenceImpl.class);
}