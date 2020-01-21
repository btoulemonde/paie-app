package dev.paie.exec;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.PaieEntrepriseRepository;
import dev.paie.repository.PaieGradeRepository;
import dev.paie.repository.PaieProfilRepository;
import dev.paie.repository.PaieRemunerationRepository;

//@Controller
public class InsererRemuneration implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(InsererRemuneration.class);
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

		RemunerationEmploye remuneration = new RemunerationEmploye();
		try {
			ProfilRemuneration profilRemuneration = this.paieProfilRepository.findById(1)
					.orElseThrow(() -> new EntityNotFoundException("profil non trouvé"));

			Grade grade = this.paieGradeRepository.findById(1)
					.orElseThrow(() -> new EntityNotFoundException("grade non trouvé"));

			Entreprise entreprise = this.paieEntrepriseRepository.findById(1)
					.orElseThrow(() -> new EntityNotFoundException("entreprise non trouvée"));
			remuneration.setEntreprise(entreprise);
			remuneration.setGrade(grade);
			remuneration.setMatricule("M01");
			remuneration.setProfilRemuneration(profilRemuneration);
		} catch (EntityNotFoundException e) {
			LOG.error("problème d'accès à une donnée en base : " + e.getMessage());
		}
		this.paieRemunerationRepository.save(remuneration);
		LOG.info("Remuneration insérée en bdd");

	}

}
