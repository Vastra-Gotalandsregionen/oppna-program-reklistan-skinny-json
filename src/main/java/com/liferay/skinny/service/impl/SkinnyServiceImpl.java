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

package com.liferay.skinny.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalFolder;
import com.liferay.portlet.journal.util.comparator.ArticleVersionComparator;
import com.liferay.skinny.model.SkinnyDDLRecord;
import com.liferay.skinny.model.SkinnyJournalArticle;
import com.liferay.skinny.model.SkinnyJournalArticleVersionMetadata;
import com.liferay.skinny.service.base.SkinnyServiceBaseImpl;

import java.io.Serializable;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author James Falkner
 * @author Amos Fong
 */
public class SkinnyServiceImpl extends SkinnyServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public List<SkinnyDDLRecord> getSkinnyDDLRecords(long ddlRecordSetId)
		throws Exception {

		List<SkinnyDDLRecord> skinnyDDLRecords =
			new ArrayList<>();

		PermissionChecker permissionChecker = getPermissionChecker();

		DDLRecordSet ddlRecordSet = ddlRecordSetLocalService.getRecordSet(
				ddlRecordSetId);

		if (permissionChecker.hasPermission(
				ddlRecordSet.getGroupId(), DDLRecordSet.class.getName(),
				ddlRecordSet.getRecordSetId(), ActionKeys.VIEW)) {

			for (DDLRecord ddlRecord : ddlRecordSet.getRecords()) {
				SkinnyDDLRecord skinnyDDLRecord = getSkinnyDDLRecord(ddlRecord, ddlRecordSet.getDDMStructure());

				skinnyDDLRecords.add(skinnyDDLRecord);
			}
		}

		return skinnyDDLRecords;
	}

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public List<SkinnyJournalArticle> getSkinnyJournalArticles(
			long companyId, String groupName, long ddmStructureId,
			String locale)
		throws Exception {

		List<SkinnyJournalArticle> skinnyJournalArticles =
			new ArrayList<>();

		Group group = groupLocalService.getGroup(companyId, groupName);

		DDMStructure ddmStructure = ddmStructureLocalService.getDDMStructure(
				ddmStructureId);

		Set<String> journalArticleIds = new HashSet<>();

		List<JournalArticle> journalArticles =
			journalArticleLocalService.getStructureArticles(
				group.getGroupId(), ddmStructure.getStructureKey());

		for (JournalArticle journalArticle : journalArticles) {
			if (journalArticleIds.contains(journalArticle.getArticleId())) {
				continue;
			}

			journalArticleIds.add(journalArticle.getArticleId());

			try {
				PermissionChecker permissionChecker = getPermissionChecker();

				if (permissionChecker.hasPermission(
						group.getGroupId(), JournalArticle.class.getName(),
						journalArticle.getResourcePrimKey(), ActionKeys.VIEW)) {

					JournalArticle latestJournalArticle =
						journalArticleLocalService.getLatestArticle(
							group.getGroupId(), journalArticle.getArticleId(),
							WorkflowConstants.STATUS_APPROVED);

					SkinnyJournalArticle skinnyJournalArticle =
						getSkinnyJournalArticle(latestJournalArticle, locale);

					skinnyJournalArticles.add(skinnyJournalArticle);
				}
			}
			catch (NoSuchArticleException nsae) {
			}
		}

		return skinnyJournalArticles;
	}

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public SkinnyJournalArticle getSkinnyJournalArticle(
			long groupId, String articleId, int status,
			String locale)
			throws Exception {

		JournalArticle journalArticle = journalArticleLocalService.
				getLatestArticle(groupId, articleId, status);

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				groupId, JournalArticle.class.getName(),
				journalArticle.getResourcePrimKey(), ActionKeys.VIEW)) {

			String msg = String.format("No JournalArticle exists with the key " +
					"{groupId=%d, articleId=%s, status=%d}",
					groupId, articleId, status);
			throw new NoSuchArticleException(msg);
		}

		return getSkinnyJournalArticle(journalArticle, locale);

	}

    @AccessControlled(guestAccessEnabled = true)
    @Override
    public List<SkinnyJournalArticleVersionMetadata> getSkinnyJournalArticleVersions(long groupId, String articleId)
        throws Exception {
        
        List<JournalArticle> articles = journalArticlePersistence.findByG_A(groupId, articleId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, new ArticleVersionComparator());
        
        List<SkinnyJournalArticleVersionMetadata> metadataList = new ArrayList<>(articles.size());
        
        for (JournalArticle article : articles) {
            metadataList.add(new SkinnyJournalArticleVersionMetadata(
                    article.getGroupId(), article.getArticleId(), article.getVersion(),
                    article.getModifiedDate(), article.getUserName(), article.getStatus()));
        }
        
        return metadataList;
    }

    @AccessControlled(guestAccessEnabled = true)
    @Override
    public SkinnyJournalArticle getSkinnyJournalArticleByVersion(long groupId, String articleId, String version, 
                                                                 String locale) 
        throws Exception {
        
        double v = Double.parseDouble(version);

        PermissionChecker permissionChecker = getPermissionChecker();

        JournalArticle article = journalArticleLocalService.fetchArticle(groupId, articleId, v);

        if (article == null) {
            throw new NoSuchArticleException();
        }
        
        if (!permissionChecker.hasPermission(
                groupId, JournalArticle.class.getName(),
                article.getResourcePrimKey(), ActionKeys.VIEW)) {

            throw new NoSuchArticleException();
        }
        
        return getSkinnyJournalArticle(article, locale);
    }
    
	protected SkinnyDDLRecord getSkinnyDDLRecord(DDLRecord ddlRecord, DDMStructure ddmStructure)
			throws Exception {

		SkinnyDDLRecord skinnyDDLRecord = new SkinnyDDLRecord();
		skinnyDDLRecord.setUuid(ddlRecord.getUuid());

		populateSkinnyDDLRecord(skinnyDDLRecord, ddmStructure, ddlRecord.getFields());

		return skinnyDDLRecord;
	}

	protected void populateSkinnyDDLRecord(SkinnyDDLRecord skinnyDDLRecord, DDMStructure ddmStructure, Fields fields) throws Exception {
		String rawDisplayFieldsValue = (String) fields.get("_fieldsDisplay").getValue();
		String[] rawDisplayFields = rawDisplayFieldsValue.split(",");
		List<Occurrence> occurrences = new ArrayList<>(rawDisplayFields.length);
		Map<String, Integer> fieldCounts = new HashMap<>();
		for (String instanceFieldName : rawDisplayFields) {
			String fieldName = instanceFieldName.replaceAll("_INSTANCE_.*$", "");
			Integer count = fieldCounts.get(fieldName);
			if (count == null) {
				occurrences.add(new Occurrence(fieldName, 0));
				fieldCounts.put(fieldName, 0);
			} else {
				occurrences.add(new Occurrence(fieldName, count + 1));
				fieldCounts.put(fieldName, count + 1);
			}
		}

		Map<String, List<Map<String, Object>>> targets = new HashMap<>();
		List<Map<String, Object>> rootFieldOccurrences = new ArrayList<>();
		for (String rootFieldName : ddmStructure.getRootFieldNames()) {
			targets.put(rootFieldName, rootFieldOccurrences);
		}

		for (Occurrence occurrence : occurrences) {
			String fieldName = occurrence.name;
			Map<String, Object> field = new HashMap<String, Object>();
			field.put("name", fieldName);
			field.put("value", getStringValue(fields.get(fieldName).getType(),
					fields.get(fieldName).getValue(Locale.getDefault(), occurrence.index)));

			List<String> childrenFieldNames = ddmStructure.getChildrenFieldNames(fieldName);
			if (!childrenFieldNames.isEmpty()) {
				List<Map<String, Object>> children = new ArrayList<>();
				field.put("children", children);

				for (String childFieldName : childrenFieldNames) {
					targets.put(childFieldName, children);
				}
			}
			targets.get(fieldName).add(field);
		}

		for (Map<String, Object> rootFieldOccurrence : rootFieldOccurrences) {
			skinnyDDLRecord.addField(rootFieldOccurrence);
		}
	}

	protected String getStringValue(String fieldDataType, Serializable fieldValue) {

		String fieldValueString = StringPool.BLANK;

		if (fieldDataType.equals("boolean")) {
			boolean booleanValue = GetterUtil.getBoolean(fieldValue);

			fieldValueString = String.valueOf(booleanValue);
		}
		else if (fieldDataType.equals("date")) {
			fieldValueString = _format.format(fieldValue);
		}
		else if (fieldDataType.equals("double")) {
			double doubleValue = GetterUtil.getDouble(fieldValue);

			fieldValueString = String.valueOf(doubleValue);
		}
		else if (fieldDataType.equals("integer") ||
				fieldDataType.equals("number")) {

			int intValue = GetterUtil.getInteger(fieldValue);

			fieldValueString = String.valueOf(intValue);
		}
		else {
			fieldValueString = GetterUtil.getString(fieldValue);
		}
		return fieldValueString;
	}


	protected SkinnyJournalArticle getSkinnyJournalArticle(
			JournalArticle journalArticle, String locale)
		throws Exception {

		SkinnyJournalArticle skinnyJournalArticle = new SkinnyJournalArticle();

		skinnyJournalArticle.setUuid(journalArticle.getUuid());
		skinnyJournalArticle.setTitle(journalArticle.getTitle(locale));
        skinnyJournalArticle.setPath(getArticlePath(journalArticle));
        
		String content = null;

		if (ArrayUtil.contains(journalArticle.getAvailableLocales(), locale)) {
			content = journalArticle.getContentByLocale(locale);
		}
		else {
			content = journalArticle.getContent();
		}

		Document document = SAXReaderUtil.read(content);

		Element rootElement = document.getRootElement();

		populateSkinnyJournalArticle(skinnyJournalArticle, rootElement);

		return skinnyJournalArticle;
	}

	protected void populateSkinnyJournalArticle(
		SkinnyJournalArticle skinnyJournalArticle, Element parentElement) {

		for (Map<String, Object> field : getNodeObjects(parentElement)) {
			skinnyJournalArticle.addField(field);
		}
	}


	protected List<Map<String, Object>> getNodeObjects(Element parent)  {

		List<Map<String, Object>> children = new ArrayList<>();
		for (Node child : parent.selectNodes("dynamic-element")) {
			children.add(getNodeObject((Element)child));
		}
		return children;



	}
	protected Map<String, Object> getNodeObject(Element element)  {

		Map<String, Object> fieldObj = new HashMap<>();

		fieldObj.put("name", element.attributeValue("name"));
		fieldObj.put("value", element.element("dynamic-content").getTextTrim());

		List<Map<String, Object>> children = new ArrayList<>();

		for (Node child: element.selectNodes("dynamic-element")) {
			children.add(getNodeObject((Element)child));
		}

		fieldObj.put("children", children);
		return fieldObj;
	}


	private Format _format = FastDateFormatFactoryUtil.getSimpleDateFormat(
		"yyyy-MM-dd");

	protected class Occurrence {

		Occurrence(String name, int index) {
			this.name = name;
			this.index = index;
		}

		final String name;
		final int index;
	}
    
    
    protected static List<String> getArticlePath(JournalArticle journalArticle)
        throws PortalException, SystemException {
        
        JournalFolder folder = journalArticle.getFolder();
        List<String> pathElements = new ArrayList<>();
        while (folder != null) {
            pathElements.add(folder.getName());
            folder = folder.getParentFolder();
        }

        Collections.reverse(pathElements);
        return Collections.unmodifiableList(pathElements);
    }
}