package com.example.avic.presentation.rest;

import com.example.avic.domaine.vo.CongeVo;
import com.example.avic.services.ICongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/conge")
public class CongeController {
    @Autowired
    private ICongeService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CongeVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        CongeVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createConge(@Validated @RequestBody CongeVo vo) {
        service.save(vo);
        return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateConge(@PathVariable(value = "id") Long voId, @RequestBody CongeVo vo) {
        CongeVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
        service.update(voId, vo);
        return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteConge(@PathVariable(name = "id") Long voId) {
        CongeVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
        service.delete(voId);
        return new ResponseEntity<>("{\"res\":\" successfully\"}", HttpStatus.OK);
    }
}
