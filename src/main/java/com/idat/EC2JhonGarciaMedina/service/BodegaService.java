package com.idat.EC2JhonGarciaMedina.service;

import java.util.List;

import com.idat.EC2JhonGarciaMedina.dto.BodegaDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.BodegaDTOResponse;



public interface BodegaService {
	
	public void guardarBodega(BodegaDTORequest bodega);
	
	public void editarBodega(BodegaDTORequest bodega);
	
	public void eliminarBodega(Integer id);
	
	public List<BodegaDTOResponse> listarBodega();
	
	public BodegaDTOResponse obtenerBodega(Integer id);

}
