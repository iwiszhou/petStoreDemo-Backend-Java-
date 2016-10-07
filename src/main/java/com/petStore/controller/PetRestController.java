package com.petStore.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petStore.jpa.entity.Pet;
import com.petStore.jpa.entity.Tag;
import com.petStore.jpa.repository.PetRepository;
import com.petStore.service.PetService;
import com.petStore.viewModel.ErrorObj;
import com.petStore.viewModel.PetModel;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwis on 2016-10-05.
 */
@RestController
public class PetRestController {
    private final PetService ps;

    @CrossOrigin
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public @ResponseBody List<PetModel> getAllPets(){
        return ps.getAllPets();
    }

    @CrossOrigin
    @RequestMapping(value ="/pet/{petId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<PetModel> getPetById(@PathVariable(value = "petId") long petId){
        PetModel pm = ps.getPetById(petId);
        if(pm != null){
            return new ResponseEntity<>(pm, HttpStatus.OK);
        }else{
            return new ResponseEntity(new ErrorObj("Pet not found",HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @RequestMapping(value ="/pet", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<PetModel> savePet(@RequestBody PetModel petModel){
        PetModel pm = ps.savePet(petModel);
        if(pm != null){
            return new ResponseEntity<>(pm, HttpStatus.OK);
        }else{
            return new ResponseEntity(new ErrorObj("Save Pet Failed",HttpStatus.EXPECTATION_FAILED), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @CrossOrigin
    @RequestMapping(value ="/pet/{petId}", method = RequestMethod.DELETE)
    public ResponseEntity deletePetById(@PathVariable(value = "petId") long petId){
        boolean result = ps.deletePetById(petId);
        if(result){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(new ErrorObj("Pet not found",HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }


    public PetRestController(PetService ps) {
        this.ps = ps;
    }
}
