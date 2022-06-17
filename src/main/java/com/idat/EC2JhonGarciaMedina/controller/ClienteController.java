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

import com.idat.EC2JhonGarciaMedina.dto.ClienteDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.ClienteDTOResponse;
import com.idat.EC2JhonGarciaMedina.service.ClienteService;

@RestController
@RequestMapping("/cliente/ec2")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@RequestMapping(path = "/listar")
	public ResponseEntity <List<ClienteDTOResponse>>  listarClientes(){
		return new ResponseEntity<List<ClienteDTOResponse>>(clienteService.listarCliente(), HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest cliente){
		clienteService.guardarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ClienteDTOResponse>  listarPorId(@PathVariable Integer id) {
		ClienteDTOResponse c= clienteService.obtenerCliente(id);
		if (c != null) {
			return new ResponseEntity<ClienteDTOResponse>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody ClienteDTORequest cliente){
		ClienteDTOResponse c = clienteService.obtenerCliente(cliente.getIdClienteDTO());
		
		if (c != null) {
			clienteService.editarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}")
	@DeleteMapping
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ClienteDTOResponse p = clienteService.obtenerCliente(id);
		
		if (p != null) {
			clienteService.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}