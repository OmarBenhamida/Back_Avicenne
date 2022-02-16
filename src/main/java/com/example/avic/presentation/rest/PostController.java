package com.example.avic.presentation.rest;

import com.example.avic.domaine.vo.PostVo;
import com.example.avic.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/rest/post")
public class PostController {
    @Autowired
    private IPostService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PostVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        PostVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("dosen't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @GetMapping(value = "/bylibelle/{libelle}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PostVo> getAllByLibelle(@PathVariable(value = "libelle") String libelle) {
        return service.findByLibelle(libelle);
    }

    @PostMapping
    public ResponseEntity<Object> createPost(@Validated @RequestBody PostVo vo) {
        service.save(vo);
        return new ResponseEntity<>(" Post created successfully", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updatePost(@PathVariable(value = "id") Long voId, @RequestBody PostVo vo) {
        PostVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("dosen't exist", HttpStatus.OK);
        vo.setId(voId);
        service.save(vo);
        return new ResponseEntity<>("updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable(name = "id") Long voId) {
        PostVo voFound = service.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(voId);
        return new ResponseEntity<>("deleted successsfully", HttpStatus.OK);
    }
}
