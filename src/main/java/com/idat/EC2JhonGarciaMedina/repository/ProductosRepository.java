package com.idat.EC2JhonGarciaMedina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EC2JhonGarciaMedina.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
