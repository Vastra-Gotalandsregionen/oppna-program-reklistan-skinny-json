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

package com.liferay.skinny.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Skinny}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Skinny
 * @generated
 */
@ProviderType
public class SkinnyWrapper implements Skinny, ModelWrapper<Skinny> {
	public SkinnyWrapper(Skinny skinny) {
		_skinny = skinny;
	}

	@Override
	public Class<?> getModelClass() {
		return Skinny.class;
	}

	@Override
	public String getModelClassName() {
		return Skinny.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dummyId", getDummyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dummyId = (Long)attributes.get("dummyId");

		if (dummyId != null) {
			setDummyId(dummyId);
		}
	}

	@Override
	public Object clone() {
		return new SkinnyWrapper((Skinny)_skinny.clone());
	}

	@Override
	public int compareTo(Skinny skinny) {
		return _skinny.compareTo(skinny);
	}

	/**
	* Returns the dummy ID of this skinny.
	*
	* @return the dummy ID of this skinny
	*/
	@Override
	public long getDummyId() {
		return _skinny.getDummyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _skinny.getExpandoBridge();
	}

	/**
	* Returns the primary key of this skinny.
	*
	* @return the primary key of this skinny
	*/
	@Override
	public long getPrimaryKey() {
		return _skinny.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _skinny.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _skinny.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _skinny.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _skinny.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _skinny.isNew();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_skinny.setCachedModel(cachedModel);
	}

	/**
	* Sets the dummy ID of this skinny.
	*
	* @param dummyId the dummy ID of this skinny
	*/
	@Override
	public void setDummyId(long dummyId) {
		_skinny.setDummyId(dummyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_skinny.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_skinny.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_skinny.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_skinny.setNew(n);
	}

	/**
	* Sets the primary key of this skinny.
	*
	* @param primaryKey the primary key of this skinny
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_skinny.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_skinny.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Skinny> toCacheModel() {
		return _skinny.toCacheModel();
	}

	@Override
	public Skinny toEscapedModel() {
		return new SkinnyWrapper(_skinny.toEscapedModel());
	}

	@Override
	public String toString() {
		return _skinny.toString();
	}

	@Override
	public Skinny toUnescapedModel() {
		return new SkinnyWrapper(_skinny.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _skinny.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkinnyWrapper)) {
			return false;
		}

		SkinnyWrapper skinnyWrapper = (SkinnyWrapper)obj;

		if (Objects.equals(_skinny, skinnyWrapper._skinny)) {
			return true;
		}

		return false;
	}

	@Override
	public Skinny getWrappedModel() {
		return _skinny;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _skinny.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _skinny.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_skinny.resetOriginalValues();
	}

	private final Skinny _skinny;
}