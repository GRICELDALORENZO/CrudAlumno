package com.mx.CrudAlumno.DAO;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.CrudAlumno.Dominio.Alumno;
import com.mx.CrudAlumno.Dominio.Carrera;

@Repository
public interface IAlumnoDao extends JpaRepository<Alumno, Integer> {
	List<Alumno> findByCarreraId(Carrera carreraId);
	Alumno findByNombreIgnoringCaseContainingAndApellidoIgnoringCaseContaining(String nombre, String apellido);
}
