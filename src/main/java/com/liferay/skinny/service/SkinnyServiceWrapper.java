package com.liferay.skinny.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SkinnyService}.
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyService
 * @generated
 */
public class SkinnyServiceWrapper implements SkinnyService,
    ServiceWrapper<SkinnyService> {
    private SkinnyService _skinnyService;

    public SkinnyServiceWrapper(SkinnyService skinnyService) {
        _skinnyService = skinnyService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _skinnyService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _skinnyService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _skinnyService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.liferay.skinny.model.SkinnyDDLRecord> getSkinnyDDLRecords(
        long ddlRecordSetId) throws java.lang.Exception {
        return _skinnyService.getSkinnyDDLRecords(ddlRecordSetId);
    }

    @Override
    public java.util.List<com.liferay.skinny.model.SkinnyJournalArticle> getSkinnyJournalArticles(
        long companyId, java.lang.String groupName, long ddmStructureId,
        java.lang.String locale) throws java.lang.Exception {
        return _skinnyService.getSkinnyJournalArticles(companyId, groupName,
            ddmStructureId, locale);
    }

    @Override
    public com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticle(
        long groupId, java.lang.String articleId, int status,
        java.lang.String locale) throws java.lang.Exception {
        return _skinnyService.getSkinnyJournalArticle(groupId, articleId,
            status, locale);
    }

    @Override
    public java.util.List<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata> getSkinnyJournalArticleVersions(
        long groupId, java.lang.String articleId) throws java.lang.Exception {
        return _skinnyService.getSkinnyJournalArticleVersions(groupId, articleId);
    }

    @Override
    public com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticleByVersion(
        long groupId, java.lang.String articleId, java.lang.String version,
        java.lang.String locale) throws java.lang.Exception {
        return _skinnyService.getSkinnyJournalArticleByVersion(groupId,
            articleId, version, locale);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SkinnyService getWrappedSkinnyService() {
        return _skinnyService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSkinnyService(SkinnyService skinnyService) {
        _skinnyService = skinnyService;
    }

    @Override
    public SkinnyService getWrappedService() {
        return _skinnyService;
    }

    @Override
    public void setWrappedService(SkinnyService skinnyService) {
        _skinnyService = skinnyService;
    }
}
