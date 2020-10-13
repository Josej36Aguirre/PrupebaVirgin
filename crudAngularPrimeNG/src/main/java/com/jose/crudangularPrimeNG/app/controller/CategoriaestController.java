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

import com.jose.crudangulaPrimeNG.app.modelDTO.CategoriaDTO;
import com.jose.crudangularPrimeGN.app.service.CategoriaImplementsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("categorias")
public class CategoriaestController {

	@Autowired
	private CategoriaImplementsService categoriaService;
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(CategoriaDTO categoriaDTO) {
		Map<String, Object> response = new HashMap<>();
		response.put("body", categoriaService.crear(categoriaDTO));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		response.put("body", categoriaService.eliminar(id));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<?> obtener(){
		Map<String, Object> response = new HashMap<>();
		response.put("body", categoriaService.obtener());
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody CategoriaDTO categoriaDTO) {
		Map<String, Object> response = new HashMap<>();
		response.put("body", categoriaService.actualizar(categoriaDTO));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
}
