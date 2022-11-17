package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;

@Service 
public class InvestigadorServiceImpl implements IInvestigadorService{

	@Autowired
	IInvestigadorDAO iInvestigadorDAO;
	
	@Override
	public List<Investigador> listarInvestigadors() {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.findAll();
	}

	@Override
	public Investigador guardarInvestigador(Investigador Investigador) {
		// TODO Auto-generated method stub
			return iInvestigadorDAO.save(Investigador); //guardo el nuevo Investigador	
	}

	public Investigador findByDni(String dni) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.findByDni(dni);
	}

	@Override
	public Investigador actualizarInvestigador(Investigador Investigador) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.save(Investigador);
	}

	@Override
	@Transactional
	public void eliminarInvestigador(String dni) {
		iInvestigadorDAO.deleteByDni(dni);
		
	}

}
