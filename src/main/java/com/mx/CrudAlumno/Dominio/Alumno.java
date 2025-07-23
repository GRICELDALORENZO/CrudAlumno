package com.mx.CrudAlumno.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALUMNO")
public class Alumno {
	/*
	 * ID_ALUMNO NUMBER,
    NOMBRE NVARCHAR2(100),
    APELLIDO NVARCHAR2(100),
    EDAD NUMBER,
	 */
	@Id
	@Column
	private int idAlumno;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private int edad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CARRERA_ID")
	private Carrera carreraId;

	public Alumno() {
		
	}

	public Alumno(int idAlumno, String nombre, String apellido, int edad, Carrera carreraId) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.carreraId = carreraId;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", carreraId=" + carreraId + "]\n";
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Carrera getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(Carrera carreraId) {
		this.carreraId = carreraId;
	}
	
	
}
