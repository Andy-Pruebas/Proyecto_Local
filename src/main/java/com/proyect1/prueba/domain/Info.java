package com.proyect1.prueba.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "informacion_c")
public class Info implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_infoc")
	private int id_infoc;
	@Column(name = "info")
	private String info;
	@Column(name = "id_len")
	private int id_len;
	
	public int getId_infoc() {
		return id_infoc;
	}
	public void setId_infoc(int id_infoc) {
		this.id_infoc = id_infoc;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getId_len() {
		return id_len;
	}
	public void setId_len(int id_len) {
		this.id_len = id_len;
	}
	@Override
	public String toString() {
		return "Info [id_infoc=" + id_infoc + ", info=" + info + ", id_len=" + id_len + "]";
	}
	

}
