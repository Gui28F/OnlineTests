package dataBase;

import array.Iterator;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface implemented
 *         in AbstratcQuestionClass
 *
 */

public interface Question {

	/**
	 * Returns question's description
	 * 
	 * @return question's description
	 */
	String getDescription();

	/**
	 * Returns question's id
	 * 
	 * @return question'd id
	 */
	int getQuestionID();

	/**
	 * Adds tag <code>tag</code> to question
	 * 
	 * @param tag tag added to question
	 */
	void addTag(String tag);

	/**
	 * Returns question's average
	 * 
	 * @return question's average
	 */
	double getQuestionAverage();

	/**
	 * Verifies if question has tag <code>tag</code>
	 * 
	 * @param tag tag verified
	 * @return <code>true</code> if the question has the tag <code>false</code> if
	 *         it doesn't
	 */
	boolean hasTag(String tag);

	/**
	 * Adds test <code>test</code> to collection of tests
	 * 
	 * @param test test added to the collection of tests
	 */
	void addTest(Test test);

	/**
	 * Returns number of tests that the question is in
	 * 
	 * @return number of tests that the question is in
	 */
	int getNumberOfTests();

	/**
	 * Verifies if question is in a closed test
	 * 
	 * @return <code>true</code> if the question is in a closed test
	 *         <code>false</code> if it isn't
	 */
	boolean isInClosedTests();

	/**
	 * Marks question with the number of answers <code>numberOfAnswers</code> and
	 * their average <code>average</code>
	 * 
	 * @param numberOfAnswers number of students that answered the question
	 * @param average         average quotation
	 */
	void markQuestion(int numberOfAnswers, double average);

	/**
	 * Returns number of respondents
	 * 
	 * @return number of respondents
	 */
	int getNumberOfRespondents();

	/**
	 * Verifies if another question <code>otherQuestion</code> is trickier than this
	 * question
	 * 
	 * @param otherQuestion question that is verified
	 * @return <code>true</code> if this question is trickier <code>false</code> if
	 *         it isn't
	 */
	boolean isTrickierThan(Question otherQuestion);

	/**
	 * Returns question's tags iterator
	 * 
	 * @return question's tags iterator
	 */
	Iterator<String> tags();

	/**
	 * Removes test <code>test</code> from collection
	 * 
	 * @param test test that is removed
	 */
	void removeTest(Test test);
}
