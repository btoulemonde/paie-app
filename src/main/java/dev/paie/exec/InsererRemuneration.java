package dev.paie.exec;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.PaieBulletinRepository;
import dev.paie.repository.PaieEntrepriseRepository;
import dev.paie.repository.PaieGradeRepository;
import dev.paie.repository.PaieProfilRepository;
import dev.paie.repository.PaieRemunerationRepository;
//@Controller
public class InsererRemuneration implements Runnable {
	
	private PaieRemunerationRepository paieRemunerationRepository;
	/**
	 * @param paieRemunerationRepository
	 * @param paieGradeRepository
	 * @param paieEntrepriseRepository
	 * @param paieProfilRepository
	 */
	public InsererRemuneration(PaieRemunerationRepository paieRemunerationRepository,
			PaieGradeRepository paieGradeRepository, PaieEntrepriseRepository paieEntrepriseRepository,
			PaieProfilRepository paieProfilRepository) {
		super();
		this.paieRemunerationRepository = paieRemunerationRepository;
		this.paieGradeRepository = paieGradeRepository;
		this.paieEntrepriseRepository = paieEntrepriseRepository;
		this.paieProfilRepository = paieProfilRepository;
	}



	private PaieGradeRepository paieGradeRepository;
	private PaieEntrepriseRepository paieEntrepriseRepository;
	private PaieProfilRepository paieProfilRepository;
	
	




	@Override
	public void run() {
		ProfilRemuneration profilRemuneration = this.paieProfilRepository.findById(1).get();
		Grade grade = this.paieGradeRepository.findById(1).get();
		Entreprise entreprise = this.paieEntrepriseRepository.findById(1).get();
		RemunerationEmploye remuneration = new RemunerationEmploye();
		remuneration.setEntreprise(entreprise);
		remuneration.setGrade(grade);
		remuneration.setMatricule("M01");
		remuneration.setProfilRemuneration(profilRemuneration);
		this.paieRemunerationRepository.save(remuneration);
	

	}

}
