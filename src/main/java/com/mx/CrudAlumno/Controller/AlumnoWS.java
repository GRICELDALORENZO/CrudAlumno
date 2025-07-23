package com.mx.CrudAlumno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CrudAlumno.Dominio.Alumno;
import com.mx.CrudAlumno.Service.AlumnoServiceImp;

@RestController
@RequestMapping(path = "api/alumno")
@CrossOrigin
public class AlumnoWS {

	@Autowired
	private AlumnoServiceImp service;

	// listar ------> http://localhost:8002/api/alumno/listar
	@GetMapping(path = "/listar")
	public ResponseEntity<?> listar() {
		List<Alumno> alumnos = service.listar();
		if (alumnos.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(alumnos);
		}

	}

	// guardar ------> http://localhost:8002/api/alumno/guardar
	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Alumno a) {
		Alumno nuevo = service.buscar(a);
		if (nuevo == null) {
			service.guardar(a);
			return ResponseEntity.status(HttpStatus.CREATED).body("SE HA ALMACENADO EL ALUMNO " + a.getIdAlumno());

		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("EL ALUMNO CON EL ID " + a.getIdAlumno() + "YA EXISTE NO SE ALMECENADO");
		}
	}

	// EDITAR ------> http://localhost:8002/api/alumno/editar
	@PutMapping(path = "/editar")
	public ResponseEntity<?> editar(@RequestBody Alumno a) {
		Alumno encontrado = service.buscar(a);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("EL AlUMNO " + a.getIdAlumno() + " NO EXISTE. NO SE EDITO");
		} else {
			service.editar(a);
			return ResponseEntity.status(HttpStatus.OK).body("SE HA ACTUALIZADO EL ALUMNO " + a.getIdAlumno());
		}

	}

	// ELIMINAR -----> http://localhost:8002/api/alumno/eliminar
	@DeleteMapping(path = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Alumno a) {
		service.elimnar(a);
		return ResponseEntity.noContent().build();
	}

	// BUSCAR -----> http://localhost:8002/api/alumno/buscar
	@PostMapping(path = "/buscar")
	public ResponseEntity<?> buscar(@RequestBody Alumno a) {
		Alumno encontrado = service.buscar(a);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("EL ALUMNO " + a.getIdAlumno() + " NO SE HA LOCALIZADO");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
}

