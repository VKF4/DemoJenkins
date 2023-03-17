package com.demo.jenkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jenkins.model.TypePlat;
import com.demo.jenkins.repository.TypePlatRepository;

@RestController
public class TypePlatController {
    @Autowired
    private TypePlatRepository typePlatRepository;

    @PostMapping("typeplat/new")
    public TypePlat postTypePlat(@RequestBody TypePlat typePlat) {
        typePlatRepository.save(typePlat);
        return typePlat;
    }

    @GetMapping("/typeplat")
    public Iterable<TypePlat> getTypePlat() {
        Iterable<TypePlat> typesPlat = typePlatRepository.findAll();
        return typesPlat;
    }
    
    @PutMapping("/typeplat/edit/{id}")
    public TypePlat putTypePlat(@PathVariable(value = "id") Long typeplat_id, @RequestBody TypePlat typePlatDetails) {
        TypePlat typePlat = typePlatRepository.findById(typeplat_id).get();   
        typePlat.setNom(typePlatDetails.getNom());
        typePlatRepository.save(typePlat);
        return typePlat;        
    }

    @DeleteMapping("/typeplat/delete/{id}")
    public void deleteTypePlat(@PathVariable(value = "id") Long typeplat_id) {
        typePlatRepository.deleteById(typeplat_id);        
    }
}
