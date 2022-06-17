package com.idat.EC2JhonGarciaMedina.service;

import java.util.List;

import com.idat.EC2JhonGarciaMedina.dto.ProductoDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.ProductoDTOResponse;

public interface ProductosService {
	
	public void guardarProducto(ProductoDTORequest producto);
	
	public void editarProducto(ProductoDTORequest producto);
	
	public void eliminarProducto(Integer id);
	
	public List<ProductoDTOResponse> listarProducto();
	
	public ProductoDTOResponse obtenerProducto(Integer id);

}
