package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Grade;

public interface PaieGradeRepository extends JpaRepository<Grade, Integer>{
	
}
