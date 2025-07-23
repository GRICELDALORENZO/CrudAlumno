package com.mx.CrudAlumno.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.CrudAlumno.DAO.IAlumnoDao;
import com.mx.CrudAlumno.Dominio.Alumno;
import com.mx.CrudAlumno.Dominio.Carrera;

@Service
public class AlumnoServiceImp implements IMetodos<Alumno>{
	
	@Autowired
	private IAlumnoDao dao;

	@Override
	public void guardar(Alumno entidad) {
		// TODO Auto-generated method stub
		dao.save(entidad);
	}

	@Override
	public void editar(Alumno entidad) {
		// TODO Auto-generated method stub
		dao.save(entidad);
	}

	@Override
	public void elimnar(Alumno entidad) {
		// TODO Auto-generated method stub
		dao.delete(entidad);
	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idAlumno"));
	}

	@Override
	public Alumno buscar(Alumno entidad) {
		// TODO Auto-generated method stub
		return dao.findById(entidad.getIdAlumno()).orElse(null);
	}

	public List<Alumno> porCarreraId(Carrera carreraId) {
		return dao.findByCarreraId(carreraId);
	}
	/*
	 * //buscra nombre y apellido
	public Padre porNombreYApellido(String nombre, String apellido) {
		return dao.findByNombreIgnoringCaseContainingAndApellidoIgnoringCaseContaining(nombre, apellido);
	}
	
	 */
		public Alumno porNombreYApellido(String nombre, String apellido) {
			return dao.findByNombreIgnoringCaseContainingAndApellidoIgnoringCaseContaining(nombre, apellido);
		}
		
		
}
	
	


