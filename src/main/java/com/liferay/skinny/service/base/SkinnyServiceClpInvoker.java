package com.liferay.skinny.service.base;

import com.liferay.skinny.service.SkinnyServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SkinnyServiceClpInvoker {
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName46;
    private String[] _methodParameterTypes46;

    public SkinnyServiceClpInvoker() {
        _methodName38 = "getBeanIdentifier";

        _methodParameterTypes38 = new String[] {  };

        _methodName39 = "setBeanIdentifier";

        _methodParameterTypes39 = new String[] { "java.lang.String" };

        _methodName42 = "getSkinnyDDLRecords";

        _methodParameterTypes42 = new String[] { "long" };

        _methodName43 = "getSkinnyJournalArticles";

        _methodParameterTypes43 = new String[] {
                "long", "java.lang.String", "long", "java.lang.String"
            };

        _methodName44 = "getSkinnyJournalArticle";

        _methodParameterTypes44 = new String[] {
                "long", "java.lang.String", "int", "java.lang.String"
            };

        _methodName45 = "getSkinnyJournalArticleVersions";

        _methodParameterTypes45 = new String[] { "long", "java.lang.String" };

        _methodName46 = "getSkinnyJournalArticleByVersion";

        _methodParameterTypes46 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            return SkinnyServiceUtil.getBeanIdentifier();
        }

        if (_methodName39.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
            SkinnyServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return SkinnyServiceUtil.getSkinnyDDLRecords(((Long) arguments[0]).longValue());
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return SkinnyServiceUtil.getSkinnyJournalArticles(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3]);
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return SkinnyServiceUtil.getSkinnyJournalArticle(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                ((Integer) arguments[2]).intValue(),
                (java.lang.String) arguments[3]);
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            return SkinnyServiceUtil.getSkinnyJournalArticleVersions(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return SkinnyServiceUtil.getSkinnyJournalArticleByVersion(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
