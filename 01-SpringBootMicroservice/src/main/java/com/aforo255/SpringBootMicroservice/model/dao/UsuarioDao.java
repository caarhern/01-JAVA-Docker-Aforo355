package com.aforo255.SpringBootMicroservice.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aforo255.SpringBootMicroservice.model.entity.Usuario;

@Repository
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{
	
	public Usuario findByUsername(@Param("username") String username);
	
}
