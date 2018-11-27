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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.skinny.exception.NoSuchSkinnyException;
import com.liferay.skinny.model.Skinny;

/**
 * The persistence interface for the skinny service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.skinny.service.persistence.impl.SkinnyPersistenceImpl
 * @see SkinnyUtil
 * @generated
 */
@ProviderType
public interface SkinnyPersistence extends BasePersistence<Skinny> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkinnyUtil} to access the skinny persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the skinny in the entity cache if it is enabled.
	*
	* @param skinny the skinny
	*/
	public void cacheResult(Skinny skinny);

	/**
	* Caches the skinnies in the entity cache if it is enabled.
	*
	* @param skinnies the skinnies
	*/
	public void cacheResult(java.util.List<Skinny> skinnies);

	/**
	* Creates a new skinny with the primary key. Does not add the skinny to the database.
	*
	* @param dummyId the primary key for the new skinny
	* @return the new skinny
	*/
	public Skinny create(long dummyId);

	/**
	* Removes the skinny with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyId the primary key of the skinny
	* @return the skinny that was removed
	* @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	*/
	public Skinny remove(long dummyId) throws NoSuchSkinnyException;

	public Skinny updateImpl(Skinny skinny);

	/**
	* Returns the skinny with the primary key or throws a {@link NoSuchSkinnyException} if it could not be found.
	*
	* @param dummyId the primary key of the skinny
	* @return the skinny
	* @throws NoSuchSkinnyException if a skinny with the primary key could not be found
	*/
	public Skinny findByPrimaryKey(long dummyId) throws NoSuchSkinnyException;

	/**
	* Returns the skinny with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dummyId the primary key of the skinny
	* @return the skinny, or <code>null</code> if a skinny with the primary key could not be found
	*/
	public Skinny fetchByPrimaryKey(long dummyId);

	@Override
	public java.util.Map<java.io.Serializable, Skinny> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the skinnies.
	*
	* @return the skinnies
	*/
	public java.util.List<Skinny> findAll();

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
	public java.util.List<Skinny> findAll(int start, int end);

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
	public java.util.List<Skinny> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Skinny> orderByComparator);

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
	public java.util.List<Skinny> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Skinny> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the skinnies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of skinnies.
	*
	* @return the number of skinnies
	*/
	public int countAll();
}