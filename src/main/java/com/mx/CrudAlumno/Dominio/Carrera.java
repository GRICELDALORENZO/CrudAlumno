package com.mx.CrudAlumno.Dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARRERA")
public class Carrera {
/*
 * ID_CARRERA NUMBER,
    NOMBRE NVARCHAR2(100),
 */
	
	@Id
	@Column
	private int idCarrera;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "carreraId", cascade = CascadeType.ALL)
	List<Alumno> lista = new ArrayList<>();

	public Carrera() {
		
	}

	public Carrera(int idCarrera, String nombre) {
		super();
		this.idCarrera = idCarrera;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + "]\n";
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
