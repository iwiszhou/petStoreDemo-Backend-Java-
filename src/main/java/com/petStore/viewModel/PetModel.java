package com.petStore.viewModel;

import com.petStore.jpa.entity.Category;
import com.petStore.jpa.entity.Tag;

import java.util.List;


/**
 * Created by iwis on 2016-10-05.
 */
public class PetModel {

    private long id;

    private Category category;

    private List<Tag> tags;

    private List<String> photoUrls;

    private String name;

    private String status;

    public PetModel() {

    }

    public PetModel(long id, Category category, List<Tag> tags, List<String> photoUrls, String name, String status) {
        this.id = id;
        this.category = category;
        this.tags = tags;
        this.photoUrls = photoUrls;
        this.name = name;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
