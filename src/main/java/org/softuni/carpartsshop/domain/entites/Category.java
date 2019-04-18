package org.softuni.carpartsshop.domain.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

	@NotNull
	@Column(name = "category_name", nullable = false, unique = true)
	private String name;

	public Category() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
