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

package com.liferay.skinny.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.liferay.skinny.exception.NoSuchSkinnyException;
import com.liferay.skinny.model.Skinny;
import com.liferay.skinny.service.persistence.SkinnyPersistence;
import com.liferay.skinny.service.persistence.SkinnyUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SkinnyPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"com.liferay.skinny.service"));

	@Before
	public void setUp() {
		_persistence = SkinnyUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Skinny> iterator = _skinnies.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Skinny skinny = _persistence.create(pk);

		Assert.assertNotNull(skinny);

		Assert.assertEquals(skinny.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Skinny newSkinny = addSkinny();

		_persistence.remove(newSkinny);

		Skinny existingSkinny = _persistence.fetchByPrimaryKey(newSkinny.getPrimaryKey());

		Assert.assertNull(existingSkinny);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSkinny();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Skinny newSkinny = _persistence.create(pk);

		_skinnies.add(_persistence.update(newSkinny));

		Skinny existingSkinny = _persistence.findByPrimaryKey(newSkinny.getPrimaryKey());

		Assert.assertEquals(existingSkinny.getDummyId(), newSkinny.getDummyId());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Skinny newSkinny = addSkinny();

		Skinny existingSkinny = _persistence.findByPrimaryKey(newSkinny.getPrimaryKey());

		Assert.assertEquals(existingSkinny, newSkinny);
	}

	@Test(expected = NoSuchSkinnyException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Skinny> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Skinny_Skinny", "dummyId",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Skinny newSkinny = addSkinny();

		Skinny existingSkinny = _persistence.fetchByPrimaryKey(newSkinny.getPrimaryKey());

		Assert.assertEquals(existingSkinny, newSkinny);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Skinny missingSkinny = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSkinny);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Skinny newSkinny1 = addSkinny();
		Skinny newSkinny2 = addSkinny();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSkinny1.getPrimaryKey());
		primaryKeys.add(newSkinny2.getPrimaryKey());

		Map<Serializable, Skinny> skinnies = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, skinnies.size());
		Assert.assertEquals(newSkinny1, skinnies.get(newSkinny1.getPrimaryKey()));
		Assert.assertEquals(newSkinny2, skinnies.get(newSkinny2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Skinny> skinnies = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(skinnies.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Skinny newSkinny = addSkinny();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSkinny.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Skinny> skinnies = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, skinnies.size());
		Assert.assertEquals(newSkinny, skinnies.get(newSkinny.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Skinny> skinnies = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(skinnies.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Skinny newSkinny = addSkinny();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSkinny.getPrimaryKey());

		Map<Serializable, Skinny> skinnies = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, skinnies.size());
		Assert.assertEquals(newSkinny, skinnies.get(newSkinny.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Skinny newSkinny = addSkinny();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Skinny.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("dummyId",
				newSkinny.getDummyId()));

		List<Skinny> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Skinny existingSkinny = result.get(0);

		Assert.assertEquals(existingSkinny, newSkinny);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Skinny.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("dummyId",
				RandomTestUtil.nextLong()));

		List<Skinny> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Skinny newSkinny = addSkinny();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Skinny.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("dummyId"));

		Object newDummyId = newSkinny.getDummyId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("dummyId",
				new Object[] { newDummyId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDummyId = result.get(0);

		Assert.assertEquals(existingDummyId, newDummyId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Skinny.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("dummyId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("dummyId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Skinny addSkinny() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Skinny skinny = _persistence.create(pk);

		_skinnies.add(_persistence.update(skinny));

		return skinny;
	}

	private List<Skinny> _skinnies = new ArrayList<Skinny>();
	private SkinnyPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}