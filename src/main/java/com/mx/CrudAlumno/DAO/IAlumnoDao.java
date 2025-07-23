package com.mx.CrudAlumno.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.CrudAlumno.Dominio.Alumno;

public interface IAlumnoDao extends JpaRepository<Alumno, Integer> {

}
