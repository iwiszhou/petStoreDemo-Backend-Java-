package com.petStore.service;

import com.petStore.jpa.Enum.Status;
import com.petStore.jpa.entity.Pet;
import com.petStore.jpa.entity.PetImage;
import com.petStore.jpa.entity.Tag;
import com.petStore.jpa.repository.PetRepository;

import com.petStore.jpa.repository.TagRepository;
import com.petStore.viewModel.PetModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwis on 2016-10-05.
 */
@Service
public class PetService {
    private final PetRepository rr;
    private final TagRepository tr;

    public List<PetModel> getAllPets(){
        List<Pet> pets =  this.rr.findAll();
        return convertPetToPetModel(pets);
    }

    public PetModel getPetById(long petId){
        return convertSinglePetToPetModel(this.rr.findById(petId));
    }

    public PetModel savePet(PetModel petModel){
        Pet p = rr.save(convertPetModelToPet(petModel));

        if( p != null ){
            return petModel;
        }else{
            return null;
        }
    }
    @Transactional
    public boolean deletePetById(long petId){
        if( petId < 0 ){
            return false;
        }

        if(this.rr.findById(petId) == null){
            return false;
        }

        this.rr.delete(petId);

        return true;
    }

    /** Helper Mehtods **/
    private List<PetModel> convertPetToPetModel(List<Pet> pets){
        List<PetModel> viewModelPets = new ArrayList<>(pets.size());

        if(pets.size() <=0){
            return viewModelPets;
        }

        pets.forEach( pet ->{
            viewModelPets.add(convertSinglePetToPetModel(pet));

        });

        return viewModelPets;
    }

    private PetModel convertSinglePetToPetModel(Pet pet){
        PetModel petModel = new PetModel();
        List<String> urls = new ArrayList<>();

        if(pet == null){
            return null;
        }

        if(pet.getPhotoUrls() !=null && pet.getPhotoUrls().size()>0){
            pet.getPhotoUrls().forEach( photot-> {
                urls.add(photot.getUrl());
            });
        }

        //Exception case should contact DB to check
        if(pet.getStatus()==null){
            pet.setStatus(Status.available);
        }

        petModel = new PetModel( pet.getId(), pet.getCategory(), pet.getTags(), urls, pet.getName(), pet.getStatus().toString());

        return petModel;
    }

    private Pet convertPetModelToPet(PetModel petModel){
        Pet pet = new Pet();
        List<PetImage> photoUrls;
        int urlsSize = 0;

        if(petModel.getPhotoUrls()!=null){
            urlsSize = petModel.getPhotoUrls().size();
        }

        if(petModel.getCategory() != null){
            pet.setCategory(petModel.getCategory());
        }

        if(petModel.getTags() != null){
            pet.setTags(petModel.getTags());
        }

        pet.setName(petModel.getName());

        if(petModel.getStatus() != null && !petModel.getStatus().toString().isEmpty()){
            try {
                pet.setStatus(Status.valueOf(petModel.getStatus().toString()));
            } catch (IllegalArgumentException iae) {
                pet.setStatus(Status.available);
            }
        }else{
            //Set default value
            pet.setStatus(Status.available);
        }

        if(urlsSize>0){
            photoUrls = new ArrayList<>(urlsSize);
            petModel.getPhotoUrls().forEach(photo ->{
                System.out.println(photo);
                photoUrls.add(new PetImage(pet, photo));
            });
            pet.setPhotoUrls(photoUrls);
        }else{
            //Set default photo
            photoUrls = new ArrayList<>(1);
            photoUrls.add(new PetImage(pet, "pet001.jpg"));
            pet.setPhotoUrls(photoUrls);
        }

        return pet;
    }

    public PetService(PetRepository rr, TagRepository tr) {
        this.rr = rr;
        this.tr = tr;
    }
}
