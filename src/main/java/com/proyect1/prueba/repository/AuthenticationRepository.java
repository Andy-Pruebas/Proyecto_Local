package com.proyect1.prueba.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Repository;

import com.proyect1.prueba.domain.User;

@Repository
public class AuthenticationRepository {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public User login(String usuario, String contraseña) throws BadCredentialsException {
		String sql = "select count(*) from usuarios where usuario=? and contraseña=?";
		Integer exists = jdbctemplate.queryForObject(sql, Integer.class, usuario, contraseña);

		if (exists == 0) {
			throw new BadCredentialsException("Credenciales Incorrectas");
		}
		return findByusuario(usuario);
	}

	public User findByusuario(String usuario) throws EmptyResultDataAccessException {
		String sql = "select * from usuarios where usuario=?";
		User user = jdbctemplate.queryForObject(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUsuario(rs.getString("usuario"));
				user.setNombres(rs.getString("nombres"));
				user.setApellidos(rs.getString("apellidos"));
				user.setDni(rs.getInt("dni"));
				user.setCorreo(rs.getString("correo"));
				user.setContraseña(rs.getString("contraseña"));
				return user;
			}
		}, usuario);
		return user;
	}
}
