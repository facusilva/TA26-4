package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facultades")
public class Facultad {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="facultad")
	private List<Equipo> equipos;
	
	@OneToMany
	@JoinColumn(name="facultad")
	private List<Investigador> investigadores;
	
	//constructores
	
	public Facultad() {
		
	}
	
	public Facultad(Long id, String nombre, List<Equipo> equipos, List<Investigador> investigadores) {
		this.id = id;
		this.nombre = nombre;
		this.equipos = equipos;
		this.investigadores = investigadores;
	}


	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad")
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad")
	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	@Override
	public String toString() {
		return "Facultad [id=" + id + ", nombre=" + nombre + ", equipos=" + equipos + ", investigadores="
				+ investigadores + "]";
	}
	
	
}
