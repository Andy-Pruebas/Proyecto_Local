package com.proyect1.prueba.domain;

import javax.persistence.Column;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "respuestas")
public class Respuesta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
	private int id_respuesta;
	@Column(name = "resp1")
	private String resp1;
	@Column(name = "peso")
	private int peso;

	public int getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(int id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public String getResp1() {
		return resp1;
	}

	public void setResp1(String resp1) {
		this.resp1 = resp1;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Respuesta [id_respuesta=" + id_respuesta + ", resp1=" + resp1 + ", peso=" + peso + "]";
	}

}
