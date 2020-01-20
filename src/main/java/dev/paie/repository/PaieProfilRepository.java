package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.ProfilRemuneration;

public interface PaieProfilRepository extends JpaRepository<ProfilRemuneration, Integer> {

}
