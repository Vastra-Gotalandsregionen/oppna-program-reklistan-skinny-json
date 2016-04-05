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

import com.liferay.portal.kernel.json.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author James Falkner
 */
public class SkinnyBaseModel {

	private List<Map<String, Object>> fields =
		new ArrayList<>();
    
	private String uuid = null;
    
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUuid() {
		return uuid;
	}

	public void addField(Map<String, Object> field) {
		fields.add(field);
	}

	@JSON
	public List<Map<String, Object>> getFields() {
		return fields;
	}
}