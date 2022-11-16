package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Equipo;

public interface IEquipoDAO extends JpaRepository<Equipo, Long>{

	public Equipo findByNumSerie(String numSerie);

	public void deleteByNumSerie(String numSerie);
	
}
