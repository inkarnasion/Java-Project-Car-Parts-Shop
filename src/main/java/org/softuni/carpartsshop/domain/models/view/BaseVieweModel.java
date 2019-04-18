package org.softuni.carpartsshop.domain.models.view;

import java.io.Serializable;

public abstract class BaseVieweModel implements Serializable {

	private String id;

	protected BaseVieweModel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}