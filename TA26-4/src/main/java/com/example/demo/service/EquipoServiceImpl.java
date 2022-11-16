package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;

@Service 
public class EquipoServiceImpl implements IEquipoService{

	@Autowired
	IEquipoDAO iEquipoDAO;
	
	@Override
	public List<Equipo> listarEquipos() {
		// TODO Auto-generated method stub
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo Equipo) {
		// TODO Auto-generated method stub
			return iEquipoDAO.save(Equipo); //guardo el nuevo Equipo	
	}

	public Equipo findByNumSerie(String numSerie) {
		// TODO Auto-generated method stub
		return iEquipoDAO.findByNumSerie(numSerie);
	}

	@Override
	public Equipo actualizarEquipo(Equipo Equipo) {
		// TODO Auto-generated method stub
		return iEquipoDAO.save(Equipo);
	}

	@Override
	public void eliminarEquipo(String numSerie) {
		iEquipoDAO.deleteByNumSerie(numSerie);
		
	}

}
