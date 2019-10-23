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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Skinny. This utility wraps
 * <code>com.liferay.skinny.service.impl.SkinnyServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyService
 * @generated
 */
public class SkinnyServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.skinny.service.impl.SkinnyServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.skinny.model.SkinnyDDLRecord>
			getSkinnyDDLRecords(long ddlRecordSetId)
		throws Exception {

		return getService().getSkinnyDDLRecords(ddlRecordSetId);
	}

	public static com.liferay.skinny.model.SkinnyJournalArticle
			getSkinnyJournalArticle(
				long groupId, String articleId, int status, String locale)
		throws Exception {

		return getService().getSkinnyJournalArticle(
			groupId, articleId, status, locale);
	}

	public static com.liferay.skinny.model.SkinnyJournalArticle
			getSkinnyJournalArticleByVersion(
				long groupId, String articleId, String version, String locale)
		throws Exception {

		return getService().getSkinnyJournalArticleByVersion(
			groupId, articleId, version, locale);
	}

	public static java.util.List<com.liferay.skinny.model.SkinnyJournalArticle>
			getSkinnyJournalArticles(
				long companyId, String groupName, long ddmStructureId,
				String locale)
		throws Exception {

		return getService().getSkinnyJournalArticles(
			companyId, groupName, ddmStructureId, locale);
	}

	public static java.util.List
		<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata>
				getSkinnyJournalArticleVersions(long groupId, String articleId)
			throws Exception {

		return getService().getSkinnyJournalArticleVersions(groupId, articleId);
	}

	public static SkinnyService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SkinnyService, SkinnyService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SkinnyService.class);

		ServiceTracker<SkinnyService, SkinnyService> serviceTracker =
			new ServiceTracker<SkinnyService, SkinnyService>(
				bundle.getBundleContext(), SkinnyService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}