package com.proyect1.prueba.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "respondidas")
public class Respondidas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respondidas")
	private int id_respondidas;
	@Column(name = "id_usu")
	private int id_usu;
	@Column(name = "id_respu")
	private int id_respu;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_respuesta", referencedColumnName = "id_respu")
	private List<Respuesta> respuesta = new ArrayList<>();

	public int getId_respondidas() {
		return id_respondidas;
	}

	public void setId_respondidas(int id_respondidas) {
		this.id_respondidas = id_respondidas;
	}

	public int getId_usu() {
		return id_usu;
	}

	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}

	public int getId_respu() {
		return id_respu;
	}

	public void setId_respu(int id_respu) {
		this.id_respu = id_respu;
	}

	public List<Respuesta> getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(List<Respuesta> respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Respondidas [id_respondidas=" + id_respondidas + ", id_usu=" + id_usu + ", id_respu=" + id_respu
				+ ", respuesta=" + respuesta + "]";
	}

}
