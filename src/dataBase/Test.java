package dataBase;

import array.*;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface implemented
 *         in TestClass
 *
 */

public interface Test {

	/**
	 * Verifies if the test is open
	 * 
	 * @return <code>true</code> if the the test is open <code>false</code> if it
	 *         isn't
	 */
	boolean isOpen();

	/**
	 * Adds question <code>question</code> to the test with its respective quotation
	 * <code>questionQuotation</code>
	 * 
	 * @param question          question added to the test
	 * @param questionQuotation question's quotation
	 */
	void addQuestion(Question question, double questionQuotation);

	/**
	 * Returns year when the test will take place
	 * 
	 * @return year when the test will take place
	 */
	int getYear();

	/**
	 * Returns test's course id
	 * 
	 * @return test's course id
	 */
	String getCourseID();

	/**
	 * Returns test id
	 * 
	 * @return test id
	 */
	String getTestID();

	/**
	 * Verifies if test is shown first of after the other <code>otherTest</code>
	 * 
	 * @param otherTest test compared to the current one
	 * @return <code>true</code> if the test is greater than the other
	 *         <code>false</code> if it isn't
	 */
	boolean greaterThan(Test otherTest);

	/**
	 * Returns total percentage at the current moment
	 * 
	 * @return total percentage at the current moment
	 */
	double getCurrentPercentage();

	/**
	 * Removes question with <code>questionID</code> from the test
	 * 
	 * @param questionID question's id
	 */
	void removeQuestion(int questionID);

	/**
	 * Verifies if question with <code>questionID</code> exists in the test
	 * 
	 * @param questionID question's id
	 * @return <code>true</code> if the question exists <code>false</code> if it
	 *         doesn't
	 */
	boolean questionExists(int questionID);

	/**
	 * Returns quotation from question with <code>questionID</code>
	 * 
	 * @param questionID quetsion's id
	 * @return quotation from question
	 */
	double getQuestionCotation(int questionID);

	/**
	 * Closes the test
	 */
	void closeTest();

	/**
	 * Verifies if the test can be closed
	 * 
	 * @return <code>true</code> if the test can be closed <code>false</code> if it
	 *         can't
	 */
	boolean canCloseTest();

	/**
	 * Returns test's questions iterator
	 * 
	 * @return test's questions iterator
	 */
	Iterator<TestQuestion> iterator();
}
