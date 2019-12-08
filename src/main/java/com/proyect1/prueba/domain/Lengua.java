package com.proyect1.prueba.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "lenguas")
public class Lengua implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_leng")
	private int id_leng;
	@Column(name = "lengua")
	private String lengua;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = ("id_len"), referencedColumnName = "id_leng")
	private List<Info> info = new ArrayList<>();

	public int getId_leng() {
		return id_leng;
	}

	public List<Info> getInfo() {
		return info;
	}

	public void setId_leng(int id_leng) {
		this.id_leng = id_leng;
	}

	public String getLengua() {
		return lengua;
	}

	public void setLengua(String lengua) {
		this.lengua = lengua;
	}

	public void setInfo(List<Info> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Lengua [id_leng=" + id_leng + ", lengua=" + lengua + ", info=" + info + "]";
	}


}
