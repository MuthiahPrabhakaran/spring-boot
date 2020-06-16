package com.guitar.db.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
//@NamedQuery(name="Model.findAllModelsByType", query="select m from Model m")
@NamedQueries({
		@NamedQuery(name="Model.findMpModels", query = "select m from Model m"),
		@NamedQuery(name = "Model.findKrish", query = "select m from Model m where m.name = :name")
})
public class Model {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;	
	private BigDecimal price;
	private int frets;
	private String woodType;
	private Date yearFirstMade;

	public Model(){	}

	public Model(String name, BigDecimal price, String woodType, ModelType modelType){
		this.name = name;
		this.price = price;
		this.woodType = woodType;
		this.modelType = modelType;
	}
	@ManyToOne
	private Manufacturer manufacturer;

	@ManyToOne
	private ModelType modelType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getFrets() {
		return frets;
	}

	public void setFrets(int frets) {
		this.frets = frets;
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public Date getYearFirstMade() {
		return yearFirstMade;
	}

	public void setYearFirstMade(Date yearFirstMade) {
		this.yearFirstMade = yearFirstMade;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public ModelType getModelType() {
		return modelType;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

	public Long getId() {
		return id;
	}
}
