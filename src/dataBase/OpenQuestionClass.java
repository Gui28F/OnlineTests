package dataBase;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Class that handles
 *         open questions' methods
 * 
 */

public class OpenQuestionClass extends AbstractQuestionClass implements OpenQuestion, Open {

	private String evaluationCriteria; // question's evaluation criteria

	/**
	 * Classe's constructor
	 * 
	 * @param questionID         question's id
	 * @param description        question's description
	 * @param evaluationCriteria question's evaluation criteria
	 */
	public OpenQuestionClass(int questionID, String description, String evaluationCriteria) {
		super(questionID, description);
		this.evaluationCriteria = evaluationCriteria;
	}

	@Override
	public String getEvaluationCriteria() {
		return evaluationCriteria;
	}
}
