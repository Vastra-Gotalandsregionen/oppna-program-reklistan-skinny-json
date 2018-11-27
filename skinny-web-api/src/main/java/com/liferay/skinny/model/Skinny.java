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

package com.liferay.skinny.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Skinny service. Represents a row in the &quot;Skinny_Skinny&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SkinnyModel
 * @see com.liferay.skinny.model.impl.SkinnyImpl
 * @see com.liferay.skinny.model.impl.SkinnyModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.skinny.model.impl.SkinnyImpl")
@ProviderType
public interface Skinny extends SkinnyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.skinny.model.impl.SkinnyImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Skinny, Long> DUMMY_ID_ACCESSOR = new Accessor<Skinny, Long>() {
			@Override
			public Long get(Skinny skinny) {
				return skinny.getDummyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Skinny> getTypeClass() {
				return Skinny.class;
			}
		};
}