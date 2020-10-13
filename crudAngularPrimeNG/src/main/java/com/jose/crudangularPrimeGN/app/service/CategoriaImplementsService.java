package com.jose.crudangularPrimeGN.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.crudangulaPrimeNG.app.modelDTO.CategoriaDTO;
import com.jose.crudangularPrimeNG.app.interfazDAO.ICategoriaDAO;
import com.jose.crudangularPrimeNG.app.interfazService.ICategoriaService;
import com.jose.crudangularPrimeNG.app.model.Categoria;

@Service
public class CategoriaImplementsService implements ICategoriaDAO{
	
	@Autowired
	private ICategoriaService categoriaService;

	@Override
	public Boolean crear(CategoriaDTO categoriaDTO) {
		try {
			categoriaService.save(maperCategoriaDTOToCategoria(categoriaDTO));
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean eliminar(Long id) {
		try {
			categoriaService.deleteById(id);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public List<CategoriaDTO> obtener() {
		List<CategoriaDTO> lisCategoriaDTOs = new ArrayList<CategoriaDTO>();
		for (Categoria categoria : categoriaService.findAll()) {
			lisCategoriaDTOs.add(mapeoCategoriaToCategoriaDTO(categoria));
		}
		return lisCategoriaDTOs;
	}

	private CategoriaDTO mapeoCategoriaToCategoriaDTO(Categoria categori) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setFechaCreacion(categori.getFechaCreacion());
		categoriaDTO.setId(categori.getId());
		categoriaDTO.setNombre(categori.getNombre());
		return categoriaDTO;
	}
	
	private Categoria maperCategoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		categoria.setFechaCreacion(categoriaDTO.getFechaCreacion());
		categoria.setId(categoriaDTO.getId());
		categoria.setNombre(categoriaDTO.getNombre());
		return categoria;
	}

	@Override
	public Boolean actualizar(CategoriaDTO categoriaDTO) {
		Categoria categoria = categoriaService.findById(categoriaDTO.getId()).orElse(null);
		try {
			categoria.setFechaCreacion(categoriaDTO.getFechaCreacion());
			categoria.setId(categoriaDTO.getId());
			categoria.setNombre(categoriaDTO.getNombre());
			categoriaService.save(categoria);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
