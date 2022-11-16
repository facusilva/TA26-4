package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Investigador;

public interface IInvestigadorDAO extends JpaRepository<Investigador, Long>{

	public Investigador findByDni(String dni);

	public void deleteByDni(String dni);
	
}
