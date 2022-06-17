package com.idat.EC2JhonGarciaMedina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC2JhonGarciaMedina.dto.ProductoDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.ProductoDTOResponse;
import com.idat.EC2JhonGarciaMedina.service.ProductosService;

@RestController
@RequestMapping("/producto/ec2")
public class ProductosController {
	
	@Autowired
	private ProductosService productoService;
	
	
	@GetMapping
	@RequestMapping(path = "/listar")
	public ResponseEntity <List<ProductoDTOResponse>>  listarProductos(){
		return new ResponseEntity<List<ProductoDTOResponse>>(productoService.listarProducto(), HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest producto){
		productoService.guardarProducto(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ProductoDTOResponse>  listarPorId(@PathVariable Integer id) {
		ProductoDTOResponse p= productoService.obtenerProducto(id);
		if (p != null) {
			return new ResponseEntity<ProductoDTOResponse>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<ProductoDTOResponse>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody ProductoDTORequest producto){
		ProductoDTOResponse p = productoService.obtenerProducto(producto.getIdProductoDTO());
		
		if (p != null) {
			productoService.editarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}")
	@DeleteMapping
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ProductoDTOResponse p = productoService.obtenerProducto(id);
		
		if (p != null) {
			productoService.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
