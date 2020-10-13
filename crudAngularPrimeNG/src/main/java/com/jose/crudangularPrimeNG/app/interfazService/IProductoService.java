package com.jose.crudangularPrimeNG.app.interfazService;

import org.springframework.data.repository.CrudRepository;

import com.jose.crudangularPrimeNG.app.model.Producto;

public interface IProductoService extends CrudRepository<Producto, Long>{

}
