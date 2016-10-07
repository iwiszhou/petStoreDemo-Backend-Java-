package com.petStore.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Tag database table.
 * 
 */
@Entity
@Table(name="Tag")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	//bi-directional many-to-many association to Pet
	@ManyToMany(mappedBy = "tags")
	private List<Pet> pets;

	@Column(name="name")
	private String name;

	/** Constructor **/

	public Tag() {}

	public Tag(String name, List<Pet> pets) {
		this.name = name;
		this.pets = pets;
	}

	/** Getter & Setter **/

	public long getId() {
		return this.id;
	}

	public void setId(long id) { this.id = id; }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<Pet> getPets() {
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}