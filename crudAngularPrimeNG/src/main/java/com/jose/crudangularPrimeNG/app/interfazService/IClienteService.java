package com.jose.crudangularPrimeNG.app.interfazService;

import org.springframework.data.repository.CrudRepository;

import com.jose.crudangularPrimeNG.app.model.Persona;

public interface IClienteService extends CrudRepository<Persona, Long> {

}
