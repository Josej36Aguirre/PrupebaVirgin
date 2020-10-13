package com.jose.crudangularPrimeNG.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.crudangulaPrimeNG.app.modelDTO.PersonaDTO;
import com.jose.crudangularPrimeGN.app.service.PersonaimplementsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("persona")
public class PersonaRestController {
	
	@Autowired
	private PersonaimplementsService personasService;
	
	@RequestMapping("/listar")
	public ResponseEntity<?> listar(){
		Map<String, Object> responce = new HashMap<String, Object>();
		responce.put("body", personasService.listar());
		return new ResponseEntity<Map<String, Object>>(responce, HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?>  eliminar(@PathVariable Long id) {
		Map<String, Object> responce = new HashMap<String, Object>();
		responce.put("body", personasService.eliminar(id));
		return new ResponseEntity<Map<String, Object>>(responce, HttpStatus.OK);
	}
	@PostMapping("/agregar")
	public ResponseEntity<?>   crear(@RequestBody PersonaDTO personaDTO) {
		Map<String, Object> responce = new HashMap<String, Object>();
		responce.put("body", personasService.crear(personaDTO));
		return new ResponseEntity<Map<String, Object>>(responce, HttpStatus.OK);
	}
	@GetMapping("/consulaId/{id}")
	public ResponseEntity<?>  consultarId(@PathVariable Long id) {
		Map<String, Object> responce = new HashMap<String, Object>();
		responce.put("body", personasService.consultarId(id));
		return new ResponseEntity<Map<String, Object>>(responce, HttpStatus.OK);
	}
	@PutMapping("/editar")
	public ResponseEntity<?>  editar(@RequestBody PersonaDTO personaDTO) {
		Map<String, Object> responce = new HashMap<String, Object>();
		responce.put("body", personasService.editar(personaDTO));
		return new ResponseEntity<Map<String, Object>>(responce, HttpStatus.OK);
	}

}
