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

package com.liferay.skinny.service.base;

import com.liferay.dynamic.data.lists.service.persistence.DDLRecordSetPersistence;
import com.liferay.dynamic.data.mapping.service.persistence.DDMStructurePersistence;
import com.liferay.journal.service.persistence.JournalArticlePersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.GroupPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.skinny.service.SkinnyService;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the skinny remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.skinny.service.impl.SkinnyServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.skinny.service.impl.SkinnyServiceImpl
 * @generated
 */
public abstract class SkinnyServiceBaseImpl
	extends BaseServiceImpl implements IdentifiableOSGiService, SkinnyService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SkinnyService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.skinny.service.SkinnyServiceUtil</code>.
	 */

	/**
	 * Returns the skinny remote service.
	 *
	 * @return the skinny remote service
	 */
	public SkinnyService getSkinnyService() {
		return skinnyService;
	}

	/**
	 * Sets the skinny remote service.
	 *
	 * @param skinnyService the skinny remote service
	 */
	public void setSkinnyService(SkinnyService skinnyService) {
		this.skinnyService = skinnyService;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the ddl record set local service.
	 *
	 * @return the ddl record set local service
	 */
	public com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService
		getDDLRecordSetLocalService() {

		return ddlRecordSetLocalService;
	}

	/**
	 * Sets the ddl record set local service.
	 *
	 * @param ddlRecordSetLocalService the ddl record set local service
	 */
	public void setDDLRecordSetLocalService(
		com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService
			ddlRecordSetLocalService) {

		this.ddlRecordSetLocalService = ddlRecordSetLocalService;
	}

	/**
	 * Returns the ddl record set remote service.
	 *
	 * @return the ddl record set remote service
	 */
	public com.liferay.dynamic.data.lists.service.DDLRecordSetService
		getDDLRecordSetService() {

		return ddlRecordSetService;
	}

	/**
	 * Sets the ddl record set remote service.
	 *
	 * @param ddlRecordSetService the ddl record set remote service
	 */
	public void setDDLRecordSetService(
		com.liferay.dynamic.data.lists.service.DDLRecordSetService
			ddlRecordSetService) {

		this.ddlRecordSetService = ddlRecordSetService;
	}

	/**
	 * Returns the ddl record set persistence.
	 *
	 * @return the ddl record set persistence
	 */
	public DDLRecordSetPersistence getDDLRecordSetPersistence() {
		return ddlRecordSetPersistence;
	}

	/**
	 * Sets the ddl record set persistence.
	 *
	 * @param ddlRecordSetPersistence the ddl record set persistence
	 */
	public void setDDLRecordSetPersistence(
		DDLRecordSetPersistence ddlRecordSetPersistence) {

		this.ddlRecordSetPersistence = ddlRecordSetPersistence;
	}

	/**
	 * Returns the ddm structure local service.
	 *
	 * @return the ddm structure local service
	 */
	public com.liferay.dynamic.data.mapping.service.DDMStructureLocalService
		getDDMStructureLocalService() {

		return ddmStructureLocalService;
	}

	/**
	 * Sets the ddm structure local service.
	 *
	 * @param ddmStructureLocalService the ddm structure local service
	 */
	public void setDDMStructureLocalService(
		com.liferay.dynamic.data.mapping.service.DDMStructureLocalService
			ddmStructureLocalService) {

		this.ddmStructureLocalService = ddmStructureLocalService;
	}

	/**
	 * Returns the ddm structure remote service.
	 *
	 * @return the ddm structure remote service
	 */
	public com.liferay.dynamic.data.mapping.service.DDMStructureService
		getDDMStructureService() {

		return ddmStructureService;
	}

	/**
	 * Sets the ddm structure remote service.
	 *
	 * @param ddmStructureService the ddm structure remote service
	 */
	public void setDDMStructureService(
		com.liferay.dynamic.data.mapping.service.DDMStructureService
			ddmStructureService) {

		this.ddmStructureService = ddmStructureService;
	}

	/**
	 * Returns the ddm structure persistence.
	 *
	 * @return the ddm structure persistence
	 */
	public DDMStructurePersistence getDDMStructurePersistence() {
		return ddmStructurePersistence;
	}

	/**
	 * Sets the ddm structure persistence.
	 *
	 * @param ddmStructurePersistence the ddm structure persistence
	 */
	public void setDDMStructurePersistence(
		DDMStructurePersistence ddmStructurePersistence) {

		this.ddmStructurePersistence = ddmStructurePersistence;
	}

	/**
	 * Returns the journal article local service.
	 *
	 * @return the journal article local service
	 */
	public com.liferay.journal.service.JournalArticleLocalService
		getJournalArticleLocalService() {

		return journalArticleLocalService;
	}

	/**
	 * Sets the journal article local service.
	 *
	 * @param journalArticleLocalService the journal article local service
	 */
	public void setJournalArticleLocalService(
		com.liferay.journal.service.JournalArticleLocalService
			journalArticleLocalService) {

		this.journalArticleLocalService = journalArticleLocalService;
	}

	/**
	 * Returns the journal article remote service.
	 *
	 * @return the journal article remote service
	 */
	public com.liferay.journal.service.JournalArticleService
		getJournalArticleService() {

		return journalArticleService;
	}

	/**
	 * Sets the journal article remote service.
	 *
	 * @param journalArticleService the journal article remote service
	 */
	public void setJournalArticleService(
		com.liferay.journal.service.JournalArticleService
			journalArticleService) {

		this.journalArticleService = journalArticleService;
	}

	/**
	 * Returns the journal article persistence.
	 *
	 * @return the journal article persistence
	 */
	public JournalArticlePersistence getJournalArticlePersistence() {
		return journalArticlePersistence;
	}

	/**
	 * Sets the journal article persistence.
	 *
	 * @param journalArticlePersistence the journal article persistence
	 */
	public void setJournalArticlePersistence(
		JournalArticlePersistence journalArticlePersistence) {

		this.journalArticlePersistence = journalArticlePersistence;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.kernel.service.GroupLocalService
		getGroupLocalService() {

		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.kernel.service.GroupLocalService groupLocalService) {

		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group remote service.
	 *
	 * @return the group remote service
	 */
	public com.liferay.portal.kernel.service.GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(
		com.liferay.portal.kernel.service.GroupService groupService) {

		this.groupService = groupService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SkinnyService.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = SkinnyService.class)
	protected SkinnyService skinnyService;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService.class
	)
	protected com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService
		ddlRecordSetLocalService;

	@ServiceReference(
		type = com.liferay.dynamic.data.lists.service.DDLRecordSetService.class
	)
	protected com.liferay.dynamic.data.lists.service.DDLRecordSetService
		ddlRecordSetService;

	@ServiceReference(type = DDLRecordSetPersistence.class)
	protected DDLRecordSetPersistence ddlRecordSetPersistence;

	@ServiceReference(
		type = com.liferay.dynamic.data.mapping.service.DDMStructureLocalService.class
	)
	protected com.liferay.dynamic.data.mapping.service.DDMStructureLocalService
		ddmStructureLocalService;

	@ServiceReference(
		type = com.liferay.dynamic.data.mapping.service.DDMStructureService.class
	)
	protected com.liferay.dynamic.data.mapping.service.DDMStructureService
		ddmStructureService;

	@ServiceReference(type = DDMStructurePersistence.class)
	protected DDMStructurePersistence ddmStructurePersistence;

	@ServiceReference(
		type = com.liferay.journal.service.JournalArticleLocalService.class
	)
	protected com.liferay.journal.service.JournalArticleLocalService
		journalArticleLocalService;

	@ServiceReference(
		type = com.liferay.journal.service.JournalArticleService.class
	)
	protected com.liferay.journal.service.JournalArticleService
		journalArticleService;

	@ServiceReference(type = JournalArticlePersistence.class)
	protected JournalArticlePersistence journalArticlePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.GroupLocalService.class
	)
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.GroupService.class
	)
	protected com.liferay.portal.kernel.service.GroupService groupService;

	@ServiceReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

}