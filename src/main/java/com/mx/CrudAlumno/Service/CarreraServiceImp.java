package com.mx.CrudAlumno.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.CrudAlumno.DAO.ICarreraDao;
import com.mx.CrudAlumno.Dominio.Carrera;

@Service
public class CarreraServiceImp implements IMetodos<Carrera>{

	//inyeccion
	@Autowired
	private ICarreraDao dao;
	
	@Override
	public void guardar(Carrera entidad) {
		// TODO Auto-generated method stub
		dao.save(entidad);
	}

	@Override
	public void editar(Carrera entidad) {
		// TODO Auto-generated method stub
		dao.save(entidad);
	}

	@Override
	public void elimnar(Carrera entidad) {
		// TODO Auto-generated method stub
		dao.delete(entidad);
	}

	@Override
	public List<Carrera> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idCarrera"));
	}

	@Override
	public Carrera buscar(Carrera entidad) {
		// TODO Auto-generated method stub
		return dao.findById(entidad.getIdCarrera()).orElse(null);
	}
	
	
	
	public Carrera porIdCarrera(int idCarrera) {
		return dao.findByIdCarrera(idCarrera);
	}
	
	//buscra nombre y apellido
		public Carrera porNombre(String nombre) {
			return dao.findByNombreIgnoringCaseContaining(nombre);
	}
		
		
}
