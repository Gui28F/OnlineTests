package dataBase;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Class that handles
 *         options' methods
 *
 */

public class LineOfMultipleChoiceQuestionClass implements LineOfMultipleChoiceQuestion {

	// Variables
	private boolean isTrue; // option's truth value
	private String option; // option's description
	private String evaluationCriteria; // option's evaluation criteria

	/**
	 * Classe's constructor
	 * 
	 * @param isTrue             option's truth value
	 * @param option             option's description
	 * @param evaluationCriteria option's evaluation criteria
	 */
	public LineOfMultipleChoiceQuestionClass(boolean isTrue, String option, String evaluationCriteria) {
		this.isTrue = isTrue;
		this.option = option;
		this.evaluationCriteria = evaluationCriteria;
	}

	@Override
	public boolean isTheRightAnswer() {
		return isTrue;
	}

	@Override
	public String getDescription() {
		return option;
	}

	@Override
	public String getEvaluationCriteria() {
		return evaluationCriteria;
	}

}
