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

import com.idat.EC2JhonGarciaMedina.dto.BodegaDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.BodegaDTOResponse;
import com.idat.EC2JhonGarciaMedina.service.BodegaService;


@RestController
@RequestMapping("/bodega/ec2")
public class BodegaController {
	
	@Autowired
	private BodegaService bodegaService;
	
	@GetMapping
	@RequestMapping(path = "/listar")
	public ResponseEntity <List<BodegaDTOResponse>>  listarBodegas(){
		return new ResponseEntity<List<BodegaDTOResponse>>(bodegaService.listarBodega(), HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody BodegaDTORequest bodega){
		bodegaService.guardarBodega(bodega);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<BodegaDTOResponse>  listarPorId(@PathVariable Integer id) {
		BodegaDTOResponse b= bodegaService.obtenerBodega(id);
		if (b != null) {
			return new ResponseEntity<BodegaDTOResponse>(b, HttpStatus.OK);
		}else {
			return new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody BodegaDTORequest bodega){
		BodegaDTOResponse b = bodegaService.obtenerBodega(bodega.getIdBoletaDTO());
		
		if (b != null) {
			bodegaService.editarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}")
	@DeleteMapping
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		BodegaDTOResponse b = bodegaService.obtenerBodega(id);
		
		if (b != null) {
			bodegaService.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
