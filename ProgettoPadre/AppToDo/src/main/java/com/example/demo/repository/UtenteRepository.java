package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente,Long>{

	Optional<Utente> findByEmailAndPassword(String email, String password);
	
	
	Optional<Utente> findByEmail(String email);


	Optional<Utente> findByNumero(String numero);

	Optional<Utente> findById(Long id);


	public void  deleteAll();






}
