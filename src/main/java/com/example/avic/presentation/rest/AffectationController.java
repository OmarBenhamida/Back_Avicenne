package com.example.avic.presentation.rest;

import com.example.avic.domaine.vo.AbsenceVo;
import com.example.avic.domaine.vo.AffectationVo;
import com.example.avic.services.IAffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/rest/affectation")
public class AffectationController {
    @Autowired
    private IAffectationService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AffectationVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        AffectationVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createAffectation(@Validated @RequestBody AffectationVo vo) {
        service.save(vo);
        return new ResponseEntity<>(" Affectation created successfully", HttpStatus.CREATED);
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAffectation(@PathVariable(value = "id") Long voId, @RequestBody AffectationVo vo) {
        AffectationVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        vo.setId(voId);
        service.update(voId,vo);
        return new ResponseEntity<>("Affectation updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAffectation(@PathVariable(name = "id") Long voId) {
        AffectationVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        service.delete(voId);
        return new ResponseEntity<>(" Affectation deleted successsfully", HttpStatus.OK);
    }
}
