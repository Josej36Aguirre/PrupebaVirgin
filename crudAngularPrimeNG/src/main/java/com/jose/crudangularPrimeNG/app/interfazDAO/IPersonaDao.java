package com.jose.crudangularPrimeNG.app.interfazDAO;

import java.util.List;

import com.jose.crudangulaPrimeNG.app.modelDTO.PersonaDTO;
import com.jose.crudangularPrimeNG.app.model.Persona;

public interface IPersonaDao {
	
	public List<Persona> listar();
	public Boolean eliminar(Long id);
	public Boolean  crear(PersonaDTO personaDTO); 
	public PersonaDTO consultarId(Long id);
	public Boolean editar(PersonaDTO personaDTO);

}
