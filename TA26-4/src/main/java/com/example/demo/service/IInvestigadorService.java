package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigador;

public interface IInvestigadorService {

	//Métodos del CRUD
	public List<Investigador> listarInvestigadors(); //Listar All
	
	public Investigador guardarInvestigador(Investigador Investigador); //Guarda un Investigador CREATE
	
	//public Investigador InvestigadorXID(String id); //Leer datos de un Investigador READ
	
	public Investigador findByDni(String dni);//buscar cientifico por dni
	
	public Investigador actualizarInvestigador(Investigador Investigador); //Actualiza datos del Investigador UPDATE
	
	public void eliminarInvestigador(String dni);//Elimina el Investigador DELETE
}
