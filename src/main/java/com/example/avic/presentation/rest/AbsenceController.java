package com.example.avic.presentation.rest;

import com.example.avic.domaine.vo.AbsenceVo;
import com.example.avic.services.IAbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController


@RequestMapping("/rest/absence")
public class AbsenceController {
    @Autowired
    private IAbsenceService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AbsenceVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        AbsenceVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createAbsence(@Validated @RequestBody AbsenceVo vo) {
        service.save(vo);
        return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAbsence(@PathVariable(value = "id") Long voId, @RequestBody AbsenceVo vo) {
        AbsenceVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        vo.setId(voId);
        service.update(voId, vo);
        return new ResponseEntity<>("updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAbsence(@PathVariable(name = "id") Long voId) {
        AbsenceVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        service.delete(voId);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}
