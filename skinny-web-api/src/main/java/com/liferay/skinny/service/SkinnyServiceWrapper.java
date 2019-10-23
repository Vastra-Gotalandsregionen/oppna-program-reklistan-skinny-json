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

package com.liferay.skinny.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SkinnyService}.
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyService
 * @generated
 */
public class SkinnyServiceWrapper
	implements ServiceWrapper<SkinnyService>, SkinnyService {

	public SkinnyServiceWrapper(SkinnyService skinnyService) {
		_skinnyService = skinnyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _skinnyService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.skinny.model.SkinnyDDLRecord>
			getSkinnyDDLRecords(long ddlRecordSetId)
		throws Exception {

		return _skinnyService.getSkinnyDDLRecords(ddlRecordSetId);
	}

	@Override
	public com.liferay.skinny.model.SkinnyJournalArticle
			getSkinnyJournalArticle(
				long groupId, String articleId, int status, String locale)
		throws Exception {

		return _skinnyService.getSkinnyJournalArticle(
			groupId, articleId, status, locale);
	}

	@Override
	public com.liferay.skinny.model.SkinnyJournalArticle
			getSkinnyJournalArticleByVersion(
				long groupId, String articleId, String version, String locale)
		throws Exception {

		return _skinnyService.getSkinnyJournalArticleByVersion(
			groupId, articleId, version, locale);
	}

	@Override
	public java.util.List<com.liferay.skinny.model.SkinnyJournalArticle>
			getSkinnyJournalArticles(
				long companyId, String groupName, long ddmStructureId,
				String locale)
		throws Exception {

		return _skinnyService.getSkinnyJournalArticles(
			companyId, groupName, ddmStructureId, locale);
	}

	@Override
	public java.util.List
		<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata>
				getSkinnyJournalArticleVersions(long groupId, String articleId)
			throws Exception {

		return _skinnyService.getSkinnyJournalArticleVersions(
			groupId, articleId);
	}

	@Override
	public SkinnyService getWrappedService() {
		return _skinnyService;
	}

	@Override
	public void setWrappedService(SkinnyService skinnyService) {
		_skinnyService = skinnyService;
	}

	private SkinnyService _skinnyService;

}