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

import com.mx.CrudAlumno.Dominio.Carrera;
import com.mx.CrudAlumno.Service.CarreraServiceImp;

@RestController
@RequestMapping(path = "api/carrera")
@CrossOrigin
public class CarreraWS {

	@Autowired
	private CarreraServiceImp service;
	
	//listar http://localhost:8002/api/carrera/listar
	@GetMapping(path = "/listar")
	public ResponseEntity<?> listar(){
		List<Carrera> carreras = service.listar();
		if(carreras.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(carreras);
		}
	}
	
	//GUARDAR http://localhost:8002/api/carrera/guardar
	@PostMapping(path = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Carrera c){
		Carrera nuevo = service.buscar(c);
		if(nuevo == null) {
			service.guardar(c);
			return ResponseEntity.status(HttpStatus.CREATED).body("SE HA ALMACENADO LA CARRERA " + c.getIdCarrera() );
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("LA CARRERA CON ID "+c.getIdCarrera()+ " YA EXISTE");
		}
	}
	
	//EDITAR  http://localhost:8002/api/carrera/editar
	@PutMapping(path = "/editar")
	public ResponseEntity<?> editar(@RequestBody Carrera c){
		Carrera encontrado = service.buscar(c);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LA CARRERA " +c.getIdCarrera()+ " NO HA SIDO ACTUALIZADO");
		}else {
			service.editar(c);
			return ResponseEntity.status(HttpStatus.OK).body("SE HA ACTUALIZADO LA CARRERA "+ c.getIdCarrera());
		}
	}
	
	//eliminar  http://localhost:8002/api/carrera/eliminar
	@DeleteMapping(path = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Carrera c){
		service.elimnar(c);
		return ResponseEntity.noContent().build();
	}
	
	//BUSCAR http://localhost:8002/api/carrera/buscar
	@PostMapping(path = "/buscar")
	public ResponseEntity<?> buscar(@RequestBody Carrera c){
		Carrera encontrado = service.buscar(c);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LA CARRERA "+c.getIdCarrera()+"NO HA SIDO LOCALIZADO");
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
}
