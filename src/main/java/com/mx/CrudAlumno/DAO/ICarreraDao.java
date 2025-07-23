package com.mx.CrudAlumno.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.CrudAlumno.Dominio.Carrera;

@Repository
public interface ICarreraDao extends JpaRepository<Carrera, Integer> {
 
	Carrera findByIdCarrera(int idCarrera);
	Carrera findByNombreIgnoringCaseContaining(String nombre);
}
