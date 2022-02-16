package com.example.avic.presentation.rest;
import com.example.avic.domaine.vo.DemandeCongeVo;
import com.example.avic.services.IDemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin("*")

@RequestMapping("/rest/demandeConge")
public class DemandeCongeController {
@Autowired
private IDemandeCongeService service;
@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public List<DemandeCongeVo> getAll() {
return service.getAll();
}
@GetMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
DemandeCongeVo voFound = service.getById(voId);
if (voFound == null)
return new ResponseEntity<>("doen't exist", HttpStatus.OK);
return new ResponseEntity<>(voFound, HttpStatus.OK);
}
@PostMapping
public ResponseEntity<Object> createDemandeConge(@Validated @RequestBody DemandeCongeVo vo) {
service.save(vo);
return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
}
@PutMapping
public ResponseEntity<Object> updateDemandeConge(@PathVariable(value = "id") Long voId,@RequestBody DemandeCongeVo vo) {
DemandeCongeVo voFound = service.getById(voId);
if (voFound == null)
return new ResponseEntity<>("doen't exist", HttpStatus.OK);
vo.setId(voId);
service.save(vo);
return new ResponseEntity<>("updated successsfully", HttpStatus.OK);
}
@DeleteMapping(value = "/{id}")
public ResponseEntity<Object> deleteDemandeConge(@PathVariable(name = "id")Long voId) {
DemandeCongeVo voFound = service.getById(voId);
if (voFound == null)
return new ResponseEntity<>("doen't exist", HttpStatus.OK);
service.delete(voId);
return new ResponseEntity<>("deleted successsfully", HttpStatus.OK);
}
}
