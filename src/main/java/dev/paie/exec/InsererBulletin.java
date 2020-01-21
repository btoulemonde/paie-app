package dev.paie.exec;

import java.math.BigDecimal;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.PaieBulletinRepository;
import dev.paie.repository.PaiePeriodeRpository;
import dev.paie.repository.PaieRemunerationRepository;

//@Controller
public class InsererBulletin implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(InsererBulletin.class);

	private PaieBulletinRepository paieBulletinRepository;

	/**
	 * @param paieBulletinRepository
	 * @param paiePeriodeRepository
	 * @param paieRemunerationRepository
	 */
	public InsererBulletin(PaieBulletinRepository paieBulletinRepository, PaiePeriodeRpository paiePeriodeRepository,
			PaieRemunerationRepository paieRemunerationRepository) {
		super();
		this.paieBulletinRepository = paieBulletinRepository;
		this.paiePeriodeRepository = paiePeriodeRepository;
		this.paieRemunerationRepository = paieRemunerationRepository;
	}

	private PaiePeriodeRpository paiePeriodeRepository;
	private PaieRemunerationRepository paieRemunerationRepository;

	@Override
	public void run() {
		BulletinSalaire bulletin = new BulletinSalaire();
		try {
			Periode periode = this.paiePeriodeRepository.findById(1)
					.orElseThrow(() -> new EntityNotFoundException("periode non trouvée"));
			RemunerationEmploye remunerationEmploye = this.paieRemunerationRepository.findById(1)
					.orElseThrow(() -> new EntityNotFoundException("remunération non trouvée"));
			bulletin.setPeriode(periode);
			bulletin.setPrimeExceptionnelle(new BigDecimal(1000));
			bulletin.setRemunerationEmploye(remunerationEmploye);
		} catch (EntityNotFoundException e) {
			LOG.error("problème d'accès à une donnée en base : " + e.getMessage());
		}
		this.paieBulletinRepository.save(bulletin);
		LOG.info("bulletin inséré en bdd");
	}

}
