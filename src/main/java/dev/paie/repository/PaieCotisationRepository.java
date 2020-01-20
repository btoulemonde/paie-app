package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Cotisation;

public interface PaieCotisationRepository extends JpaRepository<Cotisation, Integer>{
	
	

}
