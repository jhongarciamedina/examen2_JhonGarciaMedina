package com.idat.EC2JhonGarciaMedina.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBoleta;
	private String nombre;
	private String direccion;
	
	@JoinColumn(name = "id_producto", nullable = false, unique = true,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references productos(id_producto)"))
	@ManyToOne
	private Productos producto;
	
	public Bodega(Integer idBoleta, String nombre, String direccion) {
		super();
		this.idBoleta = idBoleta;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Bodega() {
		super();
	}
	public Integer getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(Integer idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
