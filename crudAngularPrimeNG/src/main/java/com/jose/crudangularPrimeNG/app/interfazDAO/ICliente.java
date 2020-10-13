package com.jose.crudangularPrimeNG.app.interfazDAO;

import java.util.List;

import com.jose.crudangulaPrimeNG.app.modelDTO.ClienteDTO;

public interface ICliente {
	
	public Boolean crear(ClienteDTO clienteDTO);
	public Boolean eliminar(Long id);
	public List<ClienteDTO> obtener();
	public Boolean actualizar(ClienteDTO clienteDTO);

}
