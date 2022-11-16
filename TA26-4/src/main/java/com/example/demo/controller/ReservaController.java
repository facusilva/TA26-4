package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

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
public class ReservaController {

	@Autowired
	ReservaServiceImpl ReservaServiceImpl;
	
	//listar todos los Reservas
	@GetMapping("/reservas")
	public List<Reserva> listarReservas(){
		return ReservaServiceImpl.listarReservas();
	}
	
	//guardar un Reserva
	@PostMapping("/reservas")
	public Reserva salvarReserva(@RequestBody Reserva Reserva) {//los datos del Reserva llegan en formato JSON desde el Request Body
		return ReservaServiceImpl.guardarReserva(Reserva);
	}
	
	//muestro un Reserva según el ID indicada
	@GetMapping("/reservas/{id}") 
	public Reserva ReservaXID(@PathVariable(name="id") Long id){ // el id del Reserva llega desde la variable del path
		Reserva Reserva_xid = new Reserva();//creo una instancia de la clase Reserva
		
		Reserva_xid=ReservaServiceImpl.ReservaXID(id);//busco el Reserva según el ID y le asigno los datos a la instancia de la clase Reserva
		
		System.out.println("Reserva XID: "+Reserva_xid);
		
		return Reserva_xid;//devuelvo el Reserva en formato JSON
	}
	
	//Actualizo los datos de un Reserva según el ID indicada
	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")Long id,@RequestBody Reserva Reserva) {
		
		Reserva Reserva_seleccionado= new Reserva();
		Reserva Reserva_actualizado= new Reserva();
		
		Reserva_seleccionado= ReservaServiceImpl.ReservaXID(id);
		
		Reserva_seleccionado.setEquipo(Reserva.getEquipo());
		Reserva_seleccionado.setInvestigador(Reserva.getInvestigador());
		Reserva_seleccionado.setComienzo(Reserva.getComienzo());
		Reserva_seleccionado.setFin(Reserva.getFin());
		
		Reserva_actualizado = ReservaServiceImpl.actualizarReserva(Reserva_seleccionado);
		
		System.out.println("El Reserva actualizado es: "+ Reserva_actualizado);
		
		return Reserva_actualizado;
	}
	
	//borro el Reserva indicado por el ID que llega en la variable del path
	@DeleteMapping("/reservas/{id}")
	public void eleiminarReserva(@PathVariable(name="id")Long id) {
		ReservaServiceImpl.eliminarReserva(id);
	}
}
