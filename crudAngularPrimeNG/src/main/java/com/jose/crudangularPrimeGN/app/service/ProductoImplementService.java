package com.jose.crudangularPrimeGN.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.crudangulaPrimeNG.app.modelDTO.ProductoDTO;
import com.jose.crudangularPrimeNG.app.interfazDAO.IProductoDAO;
import com.jose.crudangularPrimeNG.app.interfazService.IProductoService;
import com.jose.crudangularPrimeNG.app.model.Producto;

@Service
public class ProductoImplementService implements IProductoDAO {
	
	@Autowired
	private IProductoService dataProductoService;

	@Override
	public List<ProductoDTO> listarProducto() {
		List<ProductoDTO> productoDTO = new ArrayList<ProductoDTO>();
		for (Producto producto : dataProductoService.findAll()) {
			productoDTO.add(mapeoProductoToProductoDTO(producto));
		}
		return  productoDTO;
	}

	@Override
	public Boolean eliminarProducto(Long id) {
		
		try {
			dataProductoService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean crearProducto(ProductoDTO productoDTO) {
		try {
			dataProductoService.save(mapeoProductoDTOToProducto(productoDTO));
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		 return Boolean.TRUE;

	}

	@Override
	public ProductoDTO consultarId(Long id) {
		// TODO Auto-generated method stub
		return mapeoProductoToProductoDTO(dataProductoService.findById(id).orElse(null));
	}
	@SuppressWarnings("unused")
	private ProductoDTO mapeoProductoToProductoDTO(Producto producto) {
		ProductoDTO productoDTO = new ProductoDTO();
		if (!producto.equals(null)) {
			productoDTO.setId(producto.getId());
			productoDTO.setNombre(producto.getNombre()); 
			productoDTO.setFechaCreacion(producto.getFechaCreacion());
			productoDTO.setFechaVencimiernto(producto.getFechaVencimiernto());
			productoDTO.setCantidad(producto.getCantidad());
		}else {
			return null;
		}
		return productoDTO;
	}
	
	private Producto mapeoProductoDTOToProducto(ProductoDTO productoDTO) {
		Producto producto = new Producto();
		if (productoDTO!=null) {
			producto.setNombre(productoDTO.getNombre());
			producto.setFechaCreacion(productoDTO.getFechaCreacion());
			producto.setFechaVencimiernto(productoDTO.getFechaVencimiernto());
			producto.setCantidad(productoDTO.getCantidad());
		}else {
			return null;
		}
		return producto;
	}

	@Override
	public Boolean editarProducto(ProductoDTO productoDTO) {
		
		try {
			Producto productoActual = dataProductoService.findById(productoDTO.getId()).orElse(null);	
			productoActual.setId(productoDTO.getId());
			productoActual.setNombre(productoDTO.getNombre());
			productoActual.setFechaVencimiernto(productoDTO.getFechaVencimiernto());
			productoActual.setCantidad(productoDTO.getCantidad());
			dataProductoService.save(productoActual);
			
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
