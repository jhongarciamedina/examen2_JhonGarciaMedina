package com.idat.EC2JhonGarciaMedina.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2JhonGarciaMedina.dto.BodegaDTORequest;
import com.idat.EC2JhonGarciaMedina.dto.BodegaDTOResponse;
import com.idat.EC2JhonGarciaMedina.model.Bodega;
import com.idat.EC2JhonGarciaMedina.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {
	
	@Autowired
	public BodegaRepository bodegaRepository;

	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		b.setIdBoleta(bodega.getIdBoletaDTO());
		b.setNombre(bodega.getNombreDTO());
		b.setDireccion(bodega.getDireccionDTO());
		
		bodegaRepository.save(b);
		
	}

	@Override
	public void editarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		b.setIdBoleta(bodega.getIdBoletaDTO());
		b.setNombre(bodega.getNombreDTO());
		b.setDireccion(bodega.getDireccionDTO());
		
		bodegaRepository.saveAndFlush(b);
		
	}

	@Override
	public void eliminarBodega(Integer id) {
		bodegaRepository.deleteById(id);
		
	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {
		List<BodegaDTOResponse> lista = new ArrayList<BodegaDTOResponse>();
		BodegaDTOResponse b= null;
		for(Bodega bodega : bodegaRepository.findAll()) {
			b= new BodegaDTOResponse();
			b.setIdBoletaDTO(bodega.getIdBoleta());
			b.setNombreDTO(bodega.getNombre());
			b.setDireccionDTO(bodega.getDireccion());
			lista.add(b);
		}
		return lista;
	}

	@Override
	public BodegaDTOResponse obtenerBodega(Integer id) {
		Bodega bodega= bodegaRepository.findById(id).orElse(null);
		BodegaDTOResponse b= new BodegaDTOResponse();
		b.setIdBoletaDTO(bodega.getIdBoleta());
		b.setNombreDTO(bodega.getNombre());
		b.setDireccionDTO(bodega.getDireccion());
		return b;
	}

}
