package com.example.avic.presentation.rest;
import com.example.avic.domaine.vo.DemandeAttestationVo;
import com.example.avic.services.IDemandeAttestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin("*")

@RequestMapping("/rest/demandeAttestation")
public class DemandeAttestationController {
@Autowired
private IDemandeAttestationService service;
@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public List<DemandeAttestationVo> getAll() {
return service.getAll();
}
@GetMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
DemandeAttestationVo voFound = service.getById(voId);
if (voFound == null)
return new ResponseEntity<>("doen't exist", HttpStatus.OK);
return new ResponseEntity<>(voFound, HttpStatus.OK);
}
@PostMapping
public ResponseEntity<Object> createDemandeAttestation(@Validated @RequestBody DemandeAttestationVo vo) {
service.save(vo);
return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
}
@PutMapping
public ResponseEntity<Object> updateDemandeAttestation(@PathVariable(value = "id") Long voId,@RequestBody DemandeAttestationVo vo) {
DemandeAttestationVo voFound = service.getById(voId);
if (voFound == null)
return new ResponseEntity<>("doen't exist", HttpStatus.OK);
vo.setId(voId);
service.save(vo);
return new ResponseEntity<>("updated successsfully", HttpStatus.OK);
}
@DeleteMapping(value = "/{id}")
public ResponseEntity<Object> deleteDemandeAttestation(@PathVariable(name = "id")Long voId) {
DemandeAttestationVo voFound = service.getById(voId);
if (voFound == null)
return new ResponseEntity<>("doen't exist", HttpStatus.OK);
service.delete(voId);
return new ResponseEntity<>("deleted successsfully", HttpStatus.OK);
}
}
