package com.jose.crudangularPrimeNG.app.interfazService;

import org.springframework.data.repository.CrudRepository;

import com.jose.crudangularPrimeNG.app.model.Categoria;

public interface ICategoriaService extends CrudRepository<Categoria, Long> {

}
