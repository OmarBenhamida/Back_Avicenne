package com.example.avic.presentation.rest;

import com.example.avic.domaine.vo.PersonnelVo;
import com.example.avic.services.IPersonnelService;
import com.example.avic.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/personnel")
public class PersonnelController {
    @Autowired
    private IPersonnelService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PersonnelVo> getAll() {

        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        PersonnelVo voFound = service.getById(voId);
        voFound.setImg(ImageUtility.decompressImage(voFound.getImg()));
        if (voFound == null)
            return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    // get personnels by emailandpassword
    @GetMapping(value = "/auth/{email}/{password}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PersonnelVo> getAllByEmailandPassword(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
        return service.findByEmailEqualsAndAndPassewordEquals(email, password);
    }

    // get personnels by email
    @GetMapping(value = "/byemail/{email}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PersonnelVo> getAllByEmail(@PathVariable(value = "email") String email) {
        return service.findByEmail(email);
    }


    // get personnels by cin
    @GetMapping(value = "/bycin/{cin}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PersonnelVo> getAllByCin(@PathVariable(value = "cin") String cin) {
        return service.findByCin(cin);
    }


    @PostMapping
    public ResponseEntity<Object> createPersonnel(@Validated @RequestBody PersonnelVo vo) {
        vo.setImg(ImageUtility.compressImage(vo.getImg()));
        service.save(vo);
        return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePersonnel(@PathVariable(value = "id") Long voId, @RequestBody PersonnelVo vo) {
        PersonnelVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
        vo.setId(voId);
        vo.setImg(ImageUtility.compressImage(vo.getImg()));
        service.save(vo);
        return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePersonnel(@PathVariable(name = "id") Long voId) {
        PersonnelVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
        service.delete(voId);
        return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
    }
}
