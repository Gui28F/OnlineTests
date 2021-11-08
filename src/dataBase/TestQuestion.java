package dataBase;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface implemented
 *         in TestQuestionClass
 *
 */

public interface TestQuestion {

	/**
	 * Returns question quotation
	 * 
	 * @return question quotation
	 */
	double getCotation();

	/**
	 * Returns question's id
	 * 
	 * @return question's id
	 */
	int getQuestionID();

	/**
	 * Marks question with the number of answers <code>numberOfRespondents</code>
	 * and their average <code>mark</code>
	 * 
	 * @param mark                average quotation
	 * @param numberOfRespondents number of students that answered the question
	 */
	void giveMark(double mark, int numberOfRespondents);

	/**
	 * Returns question's average
	 * 
	 * @return question's average
	 */
	double getAverage();

	/**
	 * Returns number of respondents
	 * 
	 * @return number of respondents
	 */
	int getNumberOfRespondents();

	/**
	 * Returns question
	 * 
	 * @return question
	 */
	Question getQuestion();
}
