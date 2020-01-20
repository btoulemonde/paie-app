package dev.paie.exec;

import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.PaieCotisationRepository;


//@Controller
public class ListerCotisations implements Runnable {

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
		for(Cotisation c:listeCotisations){
			System.out.println(c.getLibelle());
		}
		

	}

}
