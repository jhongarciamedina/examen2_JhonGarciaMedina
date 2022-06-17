package com.idat.EC2JhonGarciaMedina.service;

import java.util.List;

import com.idat.EC2JhonGarciaMedina.dto.ClienteDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.ClienteDTOResponse;



public interface ClienteService {
	
	public void guardarCliente(ClienteDTORequest cliente);
	
	public void editarCliente(ClienteDTORequest cliente);
	
	public void eliminarCliente(Integer id);
	
	public List<ClienteDTOResponse> listarCliente();
	
	public ClienteDTOResponse obtenerCliente(Integer id);

}
