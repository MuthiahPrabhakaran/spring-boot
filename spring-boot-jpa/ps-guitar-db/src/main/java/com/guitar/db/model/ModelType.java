package com.guitar.db.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ModelType {

	public ModelType(){}

	public ModelType(Long id, String name){
		this.id = id;
		this.name = name;
	}


	@Id
	private Long id;

	private String name;	

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="MODELTYPE_ID")
	private List<Model> models = new ArrayList<Model>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
