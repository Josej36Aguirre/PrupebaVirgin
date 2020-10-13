package com.jose.crudangularPrimeNG.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jose.crudangulaPrimeNG.app.modelDTO.ProductoDTO;
import com.jose.crudangularPrimeGN.app.service.ProductoImplementService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("producto")
public class ProductRestController {

	@Autowired
	private ProductoImplementService produtoService;
	@GetMapping("/consultarProducto")
	public ResponseEntity<?> listar(){
		Map<String, Object> response = new HashMap<>();
		response.put("body", produtoService.listarProducto());
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	

	@PutMapping("/editar")
	public ResponseEntity<?> editar(@RequestBody ProductoDTO productoDTO) {
		Map<String, Object> response = new HashMap<>();
		response.put("body", produtoService.editarProducto(productoDTO));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	@PostMapping("/crearProducto")
	public ResponseEntity<?> crear(@RequestBody ProductoDTO productoDTO){
		Map<String, Object> response = new HashMap<>();
		response.put("body", produtoService.crearProducto(productoDTO));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		response.put("body", produtoService.eliminarProducto(id));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	@GetMapping("/consultarId/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
	Map<String, Object> response = new HashMap<>();
	response.put("body", produtoService.consultarId(id));
	return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
}
	
	}
