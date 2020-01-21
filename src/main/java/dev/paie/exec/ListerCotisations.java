package dev.paie.exec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.paie.entite.Cotisation;
import dev.paie.repository.PaieCotisationRepository;

//@Controller
public class ListerCotisations implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(ListerCotisations.class);

	private PaieCotisationRepository paieCotisationRepository;

	/**
	 * @param paieCotisationRepository
	 */
	public ListerCotisations(PaieCotisationRepository paieCotisationRepository) {
		super();
		this.paieCotisationRepository = paieCotisationRepository;
	}

	@Override
	public void run() {
		List<Cotisation> listeCotisations = this.paieCotisationRepository.findAll();
		for (Cotisation c : listeCotisations) {
			LOG.info("libelle={}", c.getLibelle());
		}

	}

}
