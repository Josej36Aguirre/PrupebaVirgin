package com.jose.crudangularPrimeGN.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jose.crudangulaPrimeNG.app.modelDTO.CategoriaDTO;
import com.jose.crudangulaPrimeNG.app.modelDTO.ClienteDTO;
import com.jose.crudangulaPrimeNG.app.modelDTO.PersonaDTO;
import com.jose.crudangularPrimeNG.app.interfazDAO.ICliente;
import com.jose.crudangularPrimeNG.app.interfazService.IClienteService;
import com.jose.crudangularPrimeNG.app.model.Cliente;

public class ClienteImplementService implements ICliente{

	@Autowired
	private IClienteService clienteService;
	
	@Override
	public Boolean crear(ClienteDTO clienteDTO) {
		try {
			//clienteService.save(mapeoClienteDTOToCliente(clienteDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean actualizar(ClienteDTO clientgeDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private ClienteDTO mapeoClienteToClienteDTO(Cliente cliente) {
		ClienteDTO clientesDTO = new ClienteDTO();
		if (!cliente.equals(null)) {
			clientesDTO.setId(cliente.getId());
			clientesDTO.setNombres(cliente.getNombres()); 
			clientesDTO.setApellidos(cliente.getApellidos());; 
			clientesDTO.setFechaNacimiento(cliente.getFechaNacimiento());
			clientesDTO.setDireccion(cliente.getDireccion());
			clientesDTO.setTelefono(cliente.getTelefono());
			clientesDTO.setEmail(cliente.getEmail());
		}else {
			return null;
		}
		return clientesDTO;
	}
	
	private Cliente mapeoClienteDTOToCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		
			if (!cliente.equals(null)) {
				cliente.setId(cliente.getId());
				cliente.setNombres(clienteDTO.getNombres()); 
				cliente.setApellidos(clienteDTO.getApellidos());
				cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
				cliente.setDireccion(clienteDTO.getDireccion());
				cliente.setTelefono(clienteDTO.getTelefono());
				cliente.setEmail(clienteDTO.getEmail());
		}else {
			return null;
		}
		return cliente;
	}
}
	

