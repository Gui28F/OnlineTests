package dataBase;

import array.Iterator;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface that
 *         implements MultipleChoiceQuestionClass
 * 
 */

public interface MultipleChoiceQuestion extends Question {

	/**
	 * Adds different option to question with truth value <code>isTrue</code>
	 * description <code>option</code> and evaluation criteria
	 * <code>evaluationCriteria</code>
	 * 
	 * @param isTrue             option's truth value
	 * @param option             option's description
	 * @param evaluationCriteria option's evaluation criteria
	 */
	void addOption(boolean isTrue, String option, String evaluationCriteria);

	/**
	 * Returns number of options
	 * 
	 * @return number of options
	 */
	int getNumberOfLines();

	/**
	 * Returns different options iterator
	 * 
	 * @return different options iterator
	 */
	Iterator<LineOfMultipleChoiceQuestion> options();
}
