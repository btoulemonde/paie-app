package dev.paie.exec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.PaieAvantageRepository;
import dev.paie.repository.PaieCotisationRepository;
import dev.paie.repository.PaieProfilRepository;

//@Controller
public class InsererProfil implements Runnable {

	private PaieProfilRepository paieProfilRepository;
	/**
	 * @param paieProfilRepository
	 * @param paieCotisationRepository
	 */
	public InsererProfil(PaieProfilRepository paieProfilRepository, PaieCotisationRepository paieCotisationRepository) {
		super();
		this.paieProfilRepository = paieProfilRepository;
		this.paieCotisationRepository = paieCotisationRepository;
	}

	private PaieCotisationRepository paieCotisationRepository;

	@Override
	public void run() {
		List<Integer> listeId = new ArrayList<>();
		listeId.add(1);
		listeId.add(2);
		
		List<Cotisation> cotisations = this.paieCotisationRepository.findAllById( listeId);
		ProfilRemuneration profil = new ProfilRemuneration();
		profil.setCode("apprenti");
		profil.setCotisations(cotisations);
		
		this.paieProfilRepository.save(profil);

	}

}
