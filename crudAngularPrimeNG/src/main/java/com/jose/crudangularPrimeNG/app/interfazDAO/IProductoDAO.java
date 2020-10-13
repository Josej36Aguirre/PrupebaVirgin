package com.jose.crudangularPrimeNG.app.interfazDAO;

import java.util.List;

import com.jose.crudangulaPrimeNG.app.modelDTO.ProductoDTO;

public interface IProductoDAO {

	public List<ProductoDTO> listarProducto();
	public Boolean eliminarProducto(Long id);
	public Boolean  crearProducto(ProductoDTO productoDTO); 
	public ProductoDTO consultarId(Long id);
	public Boolean editarProducto(ProductoDTO productoDTO);
	
}
