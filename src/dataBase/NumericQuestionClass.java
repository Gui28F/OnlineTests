package dataBase;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Class that handles
 *         numeric question's methods
 * 
 */

public class NumericQuestionClass extends AbstractQuestionClass implements NumericQuestion, Numerical {

	// Variables
	private double lowerBound; // question's lower bound
	private double upBound; // question's higher bound

	/**
	 * Classe's constructor
	 * 
	 * @param questionID  question's id
	 * @param description question's description
	 * @param lowerBound  question's lower bound
	 * @param upBound     question's higher bound
	 */
	public NumericQuestionClass(int questionID, String description, double lowerBound, double upBound) {
		super(questionID, description);
		this.lowerBound = lowerBound;
		this.upBound = upBound;
	}

	@Override
	public double getLowerBound() {
		return lowerBound;
	}

	@Override
	public double getUpBound() {
		return upBound;
	}

}
