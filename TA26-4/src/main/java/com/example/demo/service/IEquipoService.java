package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipo;

public interface IEquipoService {

	//Métodos del CRUD
	public List<Equipo> listarEquipos(); //Listar All
	
	public Equipo guardarEquipo(Equipo Equipo); //Guarda un Equipo CREATE
	
	//public Equipo EquipoXID(String id); //Leer datos de un Equipo READ
	
	public Equipo findByNumSerie(String numSerie);//buscar cientifico por dni
	
	public Equipo actualizarEquipo(Equipo Equipo); //Actualiza datos del Equipo UPDATE
	
	public void eliminarEquipo(String numSerie);//Elimina el Equipo DELETE
}
