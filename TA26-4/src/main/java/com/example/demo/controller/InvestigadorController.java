package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

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
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl InvestigadorServiceImpl;
	
	//listar todos los Investigadors
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadors(){
		return InvestigadorServiceImpl.listarInvestigadors();
	}
	
	//guardar un Investigador
	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador Investigador) {//los datos del Investigador llegan en formato JSON desde el Request Body
		return InvestigadorServiceImpl.guardarInvestigador(Investigador);
	}
	
	//muestro un Investigador según el ID indicada
	@GetMapping("/investigadores/{dni}") 
	public Investigador InvestigadorXID(@PathVariable(name="dni") String dni){ // el id del Investigador llega desde la variable del path
		Investigador Investigador_xid = new Investigador();//creo una instancia de la clase Investigador
		
		Investigador_xid=InvestigadorServiceImpl.findByDni(dni);//busco el Investigador según el ID y le asigno los datos a la instancia de la clase Investigador
		
		System.out.println("Investigador XID: "+Investigador_xid);
		
		return Investigador_xid;//devuelvo el Investigador en formato JSON
	}
	
	//Actualizo los datos de un Investigador según el ID indicada
	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name="dni")String dni,@RequestBody Investigador Investigador) {
		
		Investigador Investigador_seleccionado= new Investigador();
		Investigador Investigador_actualizado= new Investigador();
		
		Investigador_seleccionado= InvestigadorServiceImpl.findByDni(dni);
		
		Investigador_seleccionado.setNomApels(Investigador.getNomApels());
		Investigador_seleccionado.setFacultad(Investigador.getFacultad());
		Investigador_seleccionado.setReservas(Investigador.getReservas());
		
		Investigador_actualizado = InvestigadorServiceImpl.actualizarInvestigador(Investigador_seleccionado);
		
		System.out.println("El Investigador actualizado es: "+ Investigador_actualizado);
		
		return Investigador_actualizado;
	}
	
	//borro el Investigador indicado por el ID que llega en la variable del path
	@DeleteMapping("/investigadores/{dni}")
	public void eleiminarInvestigador(@PathVariable(name="dni")String dni) {
		InvestigadorServiceImpl.eliminarInvestigador(dni);
	}
}
