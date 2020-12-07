package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.Cliente;

@Repository
public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
}
