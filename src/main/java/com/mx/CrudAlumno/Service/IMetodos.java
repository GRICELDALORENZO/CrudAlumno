package com.mx.CrudAlumno.Service;

import java.util.List;

public interface IMetodos<T> {
	 
	void guardar(T entidad);
	
	void editar(T entidad);
	
	void elimnar(T entidad);
	
	List<T> listar();
	
	T buscar(T entidad);
}
