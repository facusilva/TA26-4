package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Investigador {

	//atributos de la entidad
	@Id
	private String dni;
	private String nomApels;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name="investigador")
	private List<Reserva> reservas;
	
	//constructores
	
	public Investigador() {
		
	}

	public Investigador(String dni, String nomApels, Facultad facultad, List<Reserva> reservas) {
		this.dni = dni;
		this.nomApels = nomApels;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	//getters y setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "investigador")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nomApels=" + nomApels + ", facultad=" + facultad + "]";
	}
	
	
}
