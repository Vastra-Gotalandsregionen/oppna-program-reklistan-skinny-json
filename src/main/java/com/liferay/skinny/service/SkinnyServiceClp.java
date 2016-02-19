package com.liferay.skinny.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SkinnyServiceClp implements SkinnyService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;

    public SkinnyServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getSkinnyDDLRecords";

        _methodParameterTypes3 = new String[] { "long" };

        _methodName4 = "getSkinnyJournalArticles";

        _methodParameterTypes4 = new String[] {
                "long", "java.lang.String", "long", "java.lang.String"
            };

        _methodName5 = "getSkinnyJournalArticle";

        _methodParameterTypes5 = new String[] {
                "long", "java.lang.String", "int", "java.lang.String"
            };

        _methodName6 = "getSkinnyJournalArticleVersions";

        _methodParameterTypes6 = new String[] { "long", "java.lang.String" };

        _methodName7 = "getSkinnyJournalArticleByVersion";

        _methodParameterTypes7 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public java.util.List<com.liferay.skinny.model.SkinnyDDLRecord> getSkinnyDDLRecords(
        long ddlRecordSetId) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3, new Object[] { ddlRecordSetId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.skinny.model.SkinnyDDLRecord>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.liferay.skinny.model.SkinnyJournalArticle> getSkinnyJournalArticles(
        long companyId, java.lang.String groupName, long ddmStructureId,
        java.lang.String locale) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        companyId,
                        
                    ClpSerializer.translateInput(groupName),
                        
                    ddmStructureId,
                        
                    ClpSerializer.translateInput(locale)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.skinny.model.SkinnyJournalArticle>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticle(
        long groupId, java.lang.String articleId, int status,
        java.lang.String locale) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        groupId,
                        
                    ClpSerializer.translateInput(articleId),
                        
                    status,
                        
                    ClpSerializer.translateInput(locale)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.skinny.model.SkinnyJournalArticle) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata> getSkinnyJournalArticleVersions(
        long groupId, java.lang.String articleId) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        groupId,
                        
                    ClpSerializer.translateInput(articleId)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.skinny.model.SkinnyJournalArticle getSkinnyJournalArticleByVersion(
        long groupId, java.lang.String articleId, java.lang.String version,
        java.lang.String locale) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        groupId,
                        
                    ClpSerializer.translateInput(articleId),
                        
                    ClpSerializer.translateInput(version),
                        
                    ClpSerializer.translateInput(locale)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.skinny.model.SkinnyJournalArticle) ClpSerializer.translateOutput(returnObj);
    }
}
