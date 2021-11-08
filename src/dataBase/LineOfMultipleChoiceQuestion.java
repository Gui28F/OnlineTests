package dataBase;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface implemented
 *         in LineOfMultipleChoiceQuestionClass
 *
 */

public interface LineOfMultipleChoiceQuestion {

	/**
	 * Returns the option's truth value
	 * 
	 * @return <code>true</code> if the option's true <code>false</code> if it isn't
	 */
	boolean isTheRightAnswer();

	/**
	 * Returns option's description
	 * 
	 * @return option's description
	 */
	String getDescription();

	/**
	 * Returns option's evaluation criteria
	 * 
	 * @return option's evaluation criteria
	 */
	String getEvaluationCriteria();

}
