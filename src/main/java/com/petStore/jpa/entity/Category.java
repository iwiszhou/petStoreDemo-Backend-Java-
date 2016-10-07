package com.petStore.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


/**
 * The persistent class for the Category database table.
 * 
 */
@Entity
@Table(name="Category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	//bi-directional one-to-many association to Pet
	@OneToMany(mappedBy = "category",  cascade = CascadeType.ALL)
	private List<Pet> pets;

	@Column(name="name")
	private String name;

	/** Constructor **/

	public Category() {}

	public Category(String name, List<Pet> pets) {
		this.name = name;
		this.pets = pets;
	}

	/** Getter & Setter **/

	@JsonIgnore
	public List<Pet> getPets(){
		return this.pets;
	}

	public void setPets(List<Pet> pets){
		this.pets = pets;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}