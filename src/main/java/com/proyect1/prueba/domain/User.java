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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuarios")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id_usuario;
	@NotNull(message = "campo obligatorio")
	@Column(name = "usuario")
	private String usuario;
	@NotNull(message = "campo obligatorio")
	@Column(name = "nombres")
	private String nombres;
	@NotNull(message = "campo obligatorio")
	@Column(name = "apellidos")
	private String apellidos;
	@NotNull(message = "campo obligatorio")
	@Column(name = "dni")
	private int dni;
	@NotNull(message = "campo obligatorio")
	@Email(message = "Correo Invalido")
	@Column(name = "correo")
	private String correo;
	@NotNull(message = "campo obligatorio")
	@Column(name = "contraseña")
	private String contraseña;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = ("id_usu"), referencedColumnName = "id_usuario")
	private List<Respondidas> respondidas = new ArrayList<>();

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Respondidas> getRespondidas() {
		return respondidas;
	}

	public void setRespondidas(List<Respondidas> respondidas) {
		this.respondidas = respondidas;
	}

	@Override
	public String toString() {
		return "User [id_usuario=" + id_usuario + ", usuario=" + usuario + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", dni=" + dni + ", correo=" + correo + ", contraseña=" + contraseña + ", respondidas="
				+ respondidas + "]";
	}

}
