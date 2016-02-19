package com.liferay.skinny.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.skinny.service.SkinnyServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.skinny.service.SkinnyServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyServiceHttp
 * @see com.liferay.skinny.service.SkinnyServiceUtil
 * @generated
 */
public class SkinnyServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(SkinnyServiceSoap.class);

    public static com.liferay.skinny.model.SkinnyDDLRecord[] getSkinnyDDLRecords(
        long ddlRecordSetId) throws RemoteException {
        try {
            java.util.List<com.liferay.skinny.model.SkinnyDDLRecord> returnValue =
                SkinnyServiceUtil.getSkinnyDDLRecords(ddlRecordSetId);

            return returnValue.toArray(new com.liferay.skinny.model.SkinnyDDLRecord[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.skinny.model.SkinnyJournalArticle[] getSkinnyJournalArticles(
        long companyId, java.lang.String groupName, long ddmStructureId,
        java.lang.String locale) throws RemoteException {
        try {
            java.util.List<com.liferay.skinny.model.SkinnyJournalArticle> returnValue =
                SkinnyServiceUtil.getSkinnyJournalArticles(companyId,
                    groupName, ddmStructureId, locale);

            return returnValue.toArray(new com.liferay.skinny.model.SkinnyJournalArticle[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticle(
        long groupId, java.lang.String articleId, int status,
        java.lang.String locale) throws RemoteException {
        try {
            com.liferay.skinny.model.SkinnyJournalArticle returnValue = SkinnyServiceUtil.getSkinnyJournalArticle(groupId,
                    articleId, status, locale);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata[] getSkinnyJournalArticleVersions(
        long groupId, java.lang.String articleId) throws RemoteException {
        try {
            java.util.List<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata> returnValue =
                SkinnyServiceUtil.getSkinnyJournalArticleVersions(groupId,
                    articleId);

            return returnValue.toArray(new com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticleByVersion(
        long groupId, java.lang.String articleId, java.lang.String version,
        java.lang.String locale) throws RemoteException {
        try {
            com.liferay.skinny.model.SkinnyJournalArticle returnValue = SkinnyServiceUtil.getSkinnyJournalArticleByVersion(groupId,
                    articleId, version, locale);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
