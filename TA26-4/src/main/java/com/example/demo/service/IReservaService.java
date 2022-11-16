package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Reserva;

public interface IReservaService {

	//Métodos del CRUD
	public List<Reserva> listarReservas(); //Listar All
	
	public Reserva guardarReserva(Reserva Reserva); //Guarda un Reserva CREATE
	
	public Reserva ReservaXID(Long id); //Leer datos de un Reserva READ
	
	public Reserva actualizarReserva(Reserva Reserva); //Actualiza datos del Reserva UPDATE
	
	public void eliminarReserva(Long id);//Elimina el Reserva DELETE
}
