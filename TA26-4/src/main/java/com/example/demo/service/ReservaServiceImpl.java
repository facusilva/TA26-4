package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service 
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	IReservaDAO iReservaDAO;
	
	@Override
	public List<Reserva> listarReservas() {
		// TODO Auto-generated method stub
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva Reserva) {
		// TODO Auto-generated method stub
			return iReservaDAO.save(Reserva); //guardo el nuevo Reserva	
	}

	@Override
	public Reserva ReservaXID(Long id) {
		// TODO Auto-generated method stub
		return iReservaDAO.findById(id).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva Reserva) {
		// TODO Auto-generated method stub
		return iReservaDAO.save(Reserva);
	}

	@Override
	public void eliminarReserva(Long id) {
		iReservaDAO.deleteById(id);
		
	}

}
