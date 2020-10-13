package com.jose.crudangularPrimeGN.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.crudangulaPrimeNG.app.modelDTO.PersonaDTO;
import com.jose.crudangularPrimeNG.app.interfazDAO.IPersonaDao;
import com.jose.crudangularPrimeNG.app.interfazService.IPersonaService;
import com.jose.crudangularPrimeNG.app.model.Persona;

@Service
public class PersonaimplementsService implements IPersonaDao{

	@Autowired
	private IPersonaService dataIpersonaService;
	
	@Override
	public List<Persona> listar() {
		
		return (List<Persona>) dataIpersonaService.findAll();
	}

	@Override
	public Boolean eliminar(Long id) {
		try {
			dataIpersonaService.deleteById(id);
		} catch (Exception e) {
		return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean crear(PersonaDTO personaDTO) {
		try {
			dataIpersonaService.save(mapeoPersonaDTOToPersona(personaDTO));
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public PersonaDTO consultarId(Long id) {
		
		return mapeoPersonaToPersonaDTO(dataIpersonaService.findById(id).orElse(null));
	}

	@Override
	public Boolean editar(PersonaDTO personaDTO) {
		
		try {
			Persona personaActual = dataIpersonaService.findById(personaDTO.getId()).orElse(null);
			personaActual.setId(personaDTO.getId());
			personaActual.setNombres(personaDTO.getNombres());
			personaActual.setApellidos(personaDTO.getApellidos());
			personaActual.setEdad(personaDTO.getEdad());
			personaActual.setGenero(personaDTO.getGenero());
			dataIpersonaService.save(personaActual);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	@SuppressWarnings("unused")
	private PersonaDTO mapeoPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (!persona.equals(null)) {
			personaDTO.setId(persona.getId());
			personaDTO.setNombres(persona.getNombres()); 
			personaDTO.setApellidos(persona.getApellidos()); 
			personaDTO.setEdad(persona.getEdad());
			personaDTO.setGenero(persona.getGenero());
		}else {
			return null;
		}
		return personaDTO;
	}
	
	private Persona mapeoPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if (personaDTO!=null) {
			persona.setId(personaDTO.getId());
			persona.setNombres(personaDTO.getNombres());
			persona.setApellidos(personaDTO.getApellidos());;
			persona.setEdad(personaDTO.getEdad());
			persona.setGenero(personaDTO.getGenero());
		}else {
			return null;
		}
		return persona;
	}

}
