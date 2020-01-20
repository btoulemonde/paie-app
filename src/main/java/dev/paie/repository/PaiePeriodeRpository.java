package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Periode;

public interface PaiePeriodeRpository extends JpaRepository<Periode, Integer> {

}
