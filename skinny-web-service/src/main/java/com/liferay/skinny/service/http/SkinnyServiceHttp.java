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

package com.liferay.skinny.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.skinny.service.SkinnyServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SkinnyServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyServiceSoap
 * @generated
 */
public class SkinnyServiceHttp {
	public static java.util.List<com.liferay.skinny.model.SkinnyDDLRecord> getSkinnyDDLRecords(
		HttpPrincipal httpPrincipal, long ddlRecordSetId)
		throws Exception {
		try {
			MethodKey methodKey = new MethodKey(
				SkinnyServiceUtil.class, "getSkinnyDDLRecords",
				_getSkinnyDDLRecordsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ddlRecordSetId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof Exception) {
					throw (Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<com.liferay.skinny.model.SkinnyDDLRecord>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.skinny.model.SkinnyJournalArticle> getSkinnyJournalArticles(
		HttpPrincipal httpPrincipal, long companyId, String groupName,
		long ddmStructureId, String locale) throws Exception {
		try {
			MethodKey methodKey = new MethodKey(
				SkinnyServiceUtil.class, "getSkinnyJournalArticles",
				_getSkinnyJournalArticlesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, groupName, ddmStructureId, locale);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof Exception) {
					throw (Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.skinny.model.SkinnyJournalArticle>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticle(
		HttpPrincipal httpPrincipal, long groupId, String articleId,
		int status, String locale) throws Exception {
		try {
			MethodKey methodKey = new MethodKey(
				SkinnyServiceUtil.class, "getSkinnyJournalArticle",
				_getSkinnyJournalArticleParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, articleId, status, locale);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof Exception) {
					throw (Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.skinny.model.SkinnyJournalArticle)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata> getSkinnyJournalArticleVersions(
		HttpPrincipal httpPrincipal, long groupId, String articleId)
		throws Exception {
		try {
			MethodKey methodKey = new MethodKey(
				SkinnyServiceUtil.class, "getSkinnyJournalArticleVersions",
				_getSkinnyJournalArticleVersionsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, articleId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof Exception) {
					throw (Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticleByVersion(
		HttpPrincipal httpPrincipal, long groupId, String articleId,
		String version, String locale) throws Exception {
		try {
			MethodKey methodKey = new MethodKey(
				SkinnyServiceUtil.class, "getSkinnyJournalArticleByVersion",
				_getSkinnyJournalArticleByVersionParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, articleId, version, locale);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof Exception) {
					throw (Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.skinny.model.SkinnyJournalArticle)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SkinnyServiceHttp.class);
	private static final Class<?>[] _getSkinnyDDLRecordsParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getSkinnyJournalArticlesParameterTypes1 = new Class[] {
			long.class, String.class, long.class, String.class
		};
	private static final Class<?>[] _getSkinnyJournalArticleParameterTypes2 = new Class[] {
			long.class, String.class, int.class, String.class
		};
	private static final Class<?>[] _getSkinnyJournalArticleVersionsParameterTypes3 =
		new Class[] { long.class, String.class };
	private static final Class<?>[] _getSkinnyJournalArticleByVersionParameterTypes4 =
		new Class[] { long.class, String.class, String.class, String.class };
}
