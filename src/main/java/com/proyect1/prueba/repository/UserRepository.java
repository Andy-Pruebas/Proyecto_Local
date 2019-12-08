package com.proyect1.prueba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyect1.prueba.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
