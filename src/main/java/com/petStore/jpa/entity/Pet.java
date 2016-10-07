package com.petStore.jpa.entity;

import com.petStore.jpa.Enum.Status;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Pet database table.
 * 
 */
@Entity
@Table(name="Pet")
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	//bi-directional many-to-one association to Category
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName="id")
	private Category category;

	//bi-directional many-to-many association to Tag
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Pet_Tag_Ref",
			joinColumns = @JoinColumn(name = "pet_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private List<Tag> tags;

    //bi-directional one-to-many association to Pet_Image
    @OneToMany(mappedBy = "pets", cascade = CascadeType.ALL)
    private List<PetImage> photoUrls;

	@Column(name="name")
	private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

	/** Constructor **/

	public Pet() {}

    public Pet(Category category, List<Tag> tags, List<PetImage> photoUrls, String name, Status status) {
        this.category = category;
        this.tags = tags;
        this.photoUrls = photoUrls;
        this.name = name;
        this.status = status;
    }

    /** Getter & Setter **/

	public Category getCategory(){
		return category;
	}

	public void setCategory(Category category){
		this.category = category;
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

    public List<PetImage> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<PetImage> photoUrls) {
        this.photoUrls = photoUrls;
    }

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}