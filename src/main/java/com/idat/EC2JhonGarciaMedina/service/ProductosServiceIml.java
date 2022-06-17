package com.idat.EC2JhonGarciaMedina.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2JhonGarciaMedina.dto.ProductoDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.ProductoDTOResponse;
import com.idat.EC2JhonGarciaMedina.model.Productos;
import com.idat.EC2JhonGarciaMedina.repository.ProductosRepository;

@Service
public class ProductosServiceIml implements ProductosService {
	
	@Autowired
	public ProductosRepository productoRepository;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		
		Productos p = new Productos();
		p.setIdProducto(producto.getIdProductoDTO());
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		productoRepository.save(p);
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		Productos p = new Productos();
		p.setIdProducto(producto.getIdProductoDTO());
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		productoRepository.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public List<ProductoDTOResponse> listarProducto() {
		List<ProductoDTOResponse> lista = new ArrayList<ProductoDTOResponse>();
		ProductoDTOResponse p= null;
		for(Productos producto : productoRepository.findAll()) {
			p= new ProductoDTOResponse();
			p.setIdProductoDTO(producto.getIdProducto());
			p.setProductoDTO(producto.getProducto());
			p.setDescripcionDTO(producto.getDescripcion());
			p.setPrecioDTO(producto.getPrecio());
			p.setStockDTO(producto.getStock());
			lista.add(p);
		}
		return lista;
	}

	@Override
	public ProductoDTOResponse obtenerProducto(Integer id) {
		Productos producto= productoRepository.findById(id).orElse(null);
		ProductoDTOResponse p= new ProductoDTOResponse();
		p.setIdProductoDTO(producto.getIdProducto());
		p.setProductoDTO(producto.getProducto());
		p.setDescripcionDTO(producto.getDescripcion());
		p.setPrecioDTO(producto.getPrecio());
		p.setStockDTO(producto.getStock());
		return p;
	}

}
