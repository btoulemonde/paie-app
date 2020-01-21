package dev.paie.exec;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.PaieBulletinRepository;
import dev.paie.repository.PaiePeriodeRpository;
import dev.paie.repository.PaieRemunerationRepository;

//@Controller
public class InsererBulletin implements Runnable {
	
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
		Periode periode = this.paiePeriodeRepository.findById(1).get();
		RemunerationEmploye remunerationEmploye = this.paieRemunerationRepository.findById(1).get();
		bulletin.setPeriode(periode);
		bulletin.setPrimeExceptionnelle(new BigDecimal(1000));
		bulletin.setRemunerationEmploye(remunerationEmploye);
		this.paieBulletinRepository.save(bulletin);
	}

}
