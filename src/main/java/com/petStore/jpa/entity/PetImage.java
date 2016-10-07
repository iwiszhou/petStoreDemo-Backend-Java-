package com.petStore.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by iwis on 2016-10-05.
 */
@Entity
@Table(name="Pet_Image")
public class PetImage implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //bi-directional many-to-one association to Category
    @ManyToOne()
    @JoinColumn(name = "pet_id", referencedColumnName="id")
    private Pet pets;

    @Lob
    @Column(name="url")
    private String url;

    /** Constructor **/

    public PetImage() {}

    public PetImage(Pet pets, String url) {
        this.pets = pets;
        this.url = url;
    }

    /** Getter & Setter **/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    public Pet getPets() {
        return pets;
    }

    public void setPets(Pet pets) {
        this.pets = pets;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
