package dataBase;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface implemented
 *         in NumericQuestionClass
 * 
 */

public interface NumericQuestion extends Question {

	/**
	 * Returns question's lowest possible answer
	 * 
	 * @return question's lowest possible answer
	 */
	double getLowerBound();

	/**
	 * Returns question's highest possible answer
	 * 
	 * @return question's highest possible answer
	 */
	double getUpBound();
}
