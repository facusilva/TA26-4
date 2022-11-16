package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadServiceImpl;

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
public class FacultadController {

	@Autowired
	FacultadServiceImpl FacultadServiceImpl;
	
	//listar todos los Facultads
	@GetMapping("/facultades")
	public List<Facultad> listarFacultads(){
		return FacultadServiceImpl.listarFacultads();
	}
	
	//guardar un Facultad
	@PostMapping("/facultades")
	public Facultad salvarFacultad(@RequestBody Facultad Facultad) {//los datos del Facultad llegan en formato JSON desde el Request Body
		return FacultadServiceImpl.guardarFacultad(Facultad);
	}
	
	//muestro un Facultad según el ID indicada
	@GetMapping("/facultades/{id}") 
	public Facultad FacultadXID(@PathVariable(name="id") Long id){ // el id del Facultad llega desde la variable del path
		Facultad Facultad_xid = new Facultad();//creo una instancia de la clase Facultad
		
		Facultad_xid=FacultadServiceImpl.FacultadXID(id);//busco el Facultad según el ID y le asigno los datos a la instancia de la clase Facultad
		
		System.out.println("Facultad XID: "+Facultad_xid);
		
		return Facultad_xid;//devuelvo el Facultad en formato JSON
	}
	
	//Actualizo los datos de un Facultad según el ID indicada
	@PutMapping("/facultades/{id}")
	public Facultad actualizarFacultad(@PathVariable(name="id")Long id,@RequestBody Facultad Facultad) {
		
		Facultad Facultad_seleccionado= new Facultad();
		Facultad Facultad_actualizado= new Facultad();
		
		Facultad_seleccionado= FacultadServiceImpl.FacultadXID(id);
		
		Facultad_seleccionado.setNombre(Facultad.getNombre());
		Facultad_seleccionado.setEquipos(Facultad.getEquipos());
		Facultad_seleccionado.setInvestigadores(Facultad.getInvestigadores());
		
		Facultad_actualizado = FacultadServiceImpl.actualizarFacultad(Facultad_seleccionado);
		
		System.out.println("El Facultad actualizado es: "+ Facultad_actualizado);
		
		return Facultad_actualizado;
	}
	
	//borro el Facultad indicado por el ID que llega en la variable del path
	@DeleteMapping("/facultades/{id}")
	public void eleiminarFacultad(@PathVariable(name="id")Long id) {
		FacultadServiceImpl.eliminarFacultad(id);
	}
}
