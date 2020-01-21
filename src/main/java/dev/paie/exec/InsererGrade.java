package dev.paie.exec;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Grade;
import dev.paie.repository.PaieGradeRepository;

@Controller
public class InsererGrade implements Runnable {

	private PaieGradeRepository paieGradeRepository;

	/**
	 * @param paieRepository
	 */
	public InsererGrade(PaieGradeRepository paieGradeRepository) {
		super();
		this.paieGradeRepository = paieGradeRepository;
	}

	@Override
	public void run() {
		Grade grade = new Grade();
		grade.setNbHeuresBase(new BigDecimal("152"));
		grade.setTauxBase(new BigDecimal("25"));
		grade.setCode("Grade_D");
		this.paieGradeRepository.save(grade);

	}

}
