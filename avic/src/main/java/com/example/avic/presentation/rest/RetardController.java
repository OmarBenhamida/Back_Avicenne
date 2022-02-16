package com.example.avic.presentation.rest;

import com.example.avic.domaine.vo.RetardVo;
import com.example.avic.services.IRetardService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")

@RequestMapping("/rest/retard")
public class RetardController {
    @Autowired
    private IRetardService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RetardVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        RetardVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createRetard(@Validated @RequestBody RetardVo vo) {
        service.save(vo);
        return new ResponseEntity<>("retard created successfully", HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateRetard(@PathVariable(value = "id") Long voId, @RequestBody RetardVo vo) {
        RetardVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        vo.setId(voId);
        service.update(voId, vo);
        return new ResponseEntity<>("updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteRetard(@PathVariable(name = "id") Long voId) {
        RetardVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(voId);
        return new ResponseEntity<>("deleted successsfully", HttpStatus.OK);
    }
}
