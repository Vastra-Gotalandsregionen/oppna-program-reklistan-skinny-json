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

package com.liferay.skinny.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.skinny.model.Skinny;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the skinny service. This utility wraps {@link com.liferay.skinny.service.persistence.impl.SkinnyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyPersistence
 * @see com.liferay.skinny.service.persistence.impl.SkinnyPersistenceImpl
 * @generated
 */
@ProviderType
public class SkinnyUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Skinny skinny) {
		getPersistence().clearCache(skinny);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Skinny> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Skinny> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Skinny> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Skinny> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Skinny update(Skinny skinny) {
		return getPersistence().update(skinny);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Skinny update(Skinny skinny, ServiceContext serviceContext) {
		return getPersistence().update(skinny, serviceContext);
	}

	/**
	* Caches the skinny in the entity cache if it is enabled.
	*
	* @param skinny the skinny
	*/
	public static void cacheResult(Skinny skinny) {
		getPersistence().cacheResult(skinny);
	}

	/**
	* Caches the skinnies in the entity cache if it is enabled.
	*
	* @param skinnies the skinnies
	*/
	public static void cacheResult(List<Skinny> skinnies) {
		getPersistence().cacheResult(skinnies);
	}

	/**
	* Creates a new skinny with the primary key. Does not add the skinny to the database.
	*
	* @param dummyId the primary key for the new skinny
	* @return the new skinny
	*/
	public static Skinny create(long dummyId) {
		return getPersistence().create(dummyId);
	}

	/**
	* Removes the skinny with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyId the primary key of the skinny
	* @return the skinny that was removed
	* @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	*/
	public static Skinny remove(long dummyId)
		throws com.liferay.skinny.exception.NoSuchSkinnyException {
		return getPersistence().remove(dummyId);
	}

	public static Skinny updateImpl(Skinny skinny) {
		return getPersistence().updateImpl(skinny);
	}

	/**
	* Returns the skinny with the primary key or throws a {@link NoSuchSkinnyException} if it could not be found.
	*
	* @param dummyId the primary key of the skinny
	* @return the skinny
	* @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	*/
	public static Skinny findByPrimaryKey(long dummyId)
		throws com.liferay.skinny.exception.NoSuchSkinnyException {
		return getPersistence().findByPrimaryKey(dummyId);
	}

	/**
	* Returns the skinny with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dummyId the primary key of the skinny
	* @return the skinny, or <code>null</code> if a skinny with the primary key could not be found
	*/
	public static Skinny fetchByPrimaryKey(long dummyId) {
		return getPersistence().fetchByPrimaryKey(dummyId);
	}

	public static java.util.Map<java.io.Serializable, Skinny> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the skinnies.
	*
	* @return the skinnies
	*/
	public static List<Skinny> findAll() {
		return getPersistence().findAll();
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
	public static List<Skinny> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Skinny> findAll(int start, int end,
		OrderByComparator<Skinny> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Skinny> findAll(int start, int end,
		OrderByComparator<Skinny> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the skinnies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of skinnies.
	*
	* @return the number of skinnies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SkinnyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SkinnyPersistence, SkinnyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SkinnyPersistence.class);

		ServiceTracker<SkinnyPersistence, SkinnyPersistence> serviceTracker = new ServiceTracker<SkinnyPersistence, SkinnyPersistence>(bundle.getBundleContext(),
				SkinnyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}