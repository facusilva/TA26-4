package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServiceImpl EquipoServiceImpl;
	
	//listar todos los Equipos
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return EquipoServiceImpl.listarEquipos();
	}
	
	//guardar un Equipo
	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo Equipo) {//los datos del Equipo llegan en formato JSON desde el Request Body
		return EquipoServiceImpl.guardarEquipo(Equipo);
	}
	
	//muestro un Equipo según el ID indicada
	@GetMapping("/equipos/{numSerie}") 
	public Equipo EquipoXID(@PathVariable(name="numSerie") String numSerie){ // el id del Equipo llega desde la variable del path
		Equipo Equipo_xid = new Equipo();//creo una instancia de la clase Equipo
		
		Equipo_xid=EquipoServiceImpl.findByNumSerie(numSerie);//busco el Equipo según el ID y le asigno los datos a la instancia de la clase Equipo
		
		System.out.println("Equipo XID: "+Equipo_xid);
		
		return Equipo_xid;//devuelvo el Equipo en formato JSON
	}
	
	//Actualizo los datos de un Equipo según el ID indicada
	@PutMapping("/equipos/{numSerie}")
	public Equipo actualizarEquipo(@PathVariable(name="numSerie")String numSerie,@RequestBody Equipo Equipo) {
		
		Equipo Equipo_seleccionado= new Equipo();
		Equipo Equipo_actualizado= new Equipo();
		
		Equipo_seleccionado= EquipoServiceImpl.findByNumSerie(numSerie);
		
		Equipo_seleccionado.setNombre(Equipo.getNombre());
		Equipo_seleccionado.setFacultad(Equipo.getFacultad());
		Equipo_seleccionado.setReservas(Equipo.getReservas());
		
		Equipo_actualizado = EquipoServiceImpl.actualizarEquipo(Equipo_seleccionado);
		
		System.out.println("El Equipo actualizado es: "+ Equipo_actualizado);
		
		return Equipo_actualizado;
	}
	
	//borro el Equipo indicado por el ID que llega en la variable del path
	@DeleteMapping("/equipos/{numSerie}")
	public void eleiminarEquipo(@PathVariable(name="numSerie")String numSerie) {
		EquipoServiceImpl.eliminarEquipo(numSerie);
	}
}
