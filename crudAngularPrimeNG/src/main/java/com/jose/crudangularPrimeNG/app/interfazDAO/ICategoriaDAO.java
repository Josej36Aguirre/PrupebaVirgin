package com.jose.crudangularPrimeNG.app.interfazDAO;

import java.util.List;

import com.jose.crudangulaPrimeNG.app.modelDTO.CategoriaDTO;

public interface ICategoriaDAO {

	Boolean crear(CategoriaDTO categoriaDTO);
	Boolean eliminar(Long id);
	List<CategoriaDTO> obtener();
	Boolean actualizar(CategoriaDTO categoriaDTO);
	
}
