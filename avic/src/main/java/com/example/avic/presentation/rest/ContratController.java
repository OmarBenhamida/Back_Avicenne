package com.example.avic.presentation.rest;

import com.example.avic.domaine.vo.ContratVo;
import com.example.avic.services.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/rest/contrat")
public class ContratController {
    @Autowired
    private IContratService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ContratVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        ContratVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createContrat(@Validated @RequestBody ContratVo vo) {
        service.save(vo);
        return new ResponseEntity<>("Contrat created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateContrat(@PathVariable(value = "id") Long voId, @RequestBody ContratVo vo) {
        ContratVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        vo.setId(voId);
        service.update(voId, vo);
        return new ResponseEntity<>("updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteContrat(@PathVariable(name = "id") Long voId) {
        ContratVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(voId);
        return new ResponseEntity<>("deleted successsfully", HttpStatus.OK);
    }
}
