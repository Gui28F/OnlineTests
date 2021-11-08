package dataBase;

import array.*;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface implemented
 *         in TestRUsClass
 *
 */

public interface TestsRUs {

	/**
	 * Adds open question with its description <code>description</code> and
	 * evaluation criteria <code>evaluationCriteria</code> to the database
	 * 
	 * @param description        question's description
	 * @param evaluationCriteria question's evaluation criteria
	 * @return Returns question's id
	 */
	int addOpenQuestion(String description, String evaluationCriteria);

	/**
	 * Adds open question with its description <code>description</code> and lower
	 * bound <code>lowerBound</code> and higher bound <code>upBound</code>
	 * 
	 * @param description question's description
	 * @param lowerBound  question's lower bound
	 * @param upBound     question's higher bound
	 * @return question's id
	 */
	int addNumericalQuestion(String description, double lowerBound, double upBound);

	/**
	 * Adds choices to multiple question with id <code>questionID</code> giving the
	 * truth value <code>isTrue</code> the option's description <code>option</code>
	 * and the evaluation criteria <code>evaluationCriteria</code>
	 * 
	 * @param questionID         question's id
	 * @param isTrue             option's truth value
	 * @param option             option's description
	 * @param evaluationCriteria option's evaluation criteria
	 */
	void addChoices(int questionID, boolean isTrue, String option, String evaluationCriteria);

	/**
	 * Adds multiple choice question with its description <code>description</code>
	 * and the number of different options <code>numberOfOptions</code>
	 * 
	 * @param description     question's description
	 * @param numberOfOptions question's number of options
	 * @return question's id
	 */
	int addMultipleChoiceQuestion(String description, int numberOfOptions);

	/**
	 * Returns question with question id <code>questionID</code>
	 * 
	 * @param questionID question's id
	 * @return question
	 */
	Question getQuestion(int questionID);

	/**
	 * Verifies if the database has the question with the id <code>questionID</code>
	 * 
	 * @param questionID question's id
	 * @return <code>true</code> if the question exists in the database
	 *         <code>false</code> if it doesn't
	 */
	boolean hasQuestion(int questionID);

	/**
	 * Verifies if the database has any questions
	 * 
	 * @return <code>true</code> if the database has questions <code>false</code> if
	 *         it doesn't
	 */
	boolean hasQuestions();

	/**
	 * Verifies if the database has questions that have been answered
	 * 
	 * @return <code>true</code> if the database has answered questions
	 *         <code>false</code> if it doesn't
	 */
	boolean hasQuestionsAnswered();

	/**
	 * Verifies if question with id <code>questionID</code> has the tag
	 * <code>tag</code>
	 * 
	 * @param questionID question's id
	 * @param tag        tag that is verified
	 * @return <code>true</code> if the question has the tag <code>false</code> if
	 *         it doesn't
	 */
	boolean questionHasTag(int questionID, String tag);

	/**
	 * Adds tag <code>tag</code> to question with id <code>questionID</code>
	 * 
	 * @param questionID question's id
	 * @param tag        tag that's added
	 */
	void addTag(int questionID, String tag);

	/**
	 * Verifies if the database has the test with course id <code>courseID</code>
	 * year <code>year</code> and id <code>testID</code>
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 * @return <code>true</code> if the database has the test <code>false</code> if
	 *         it doesn't
	 */
	boolean hasTest(String courseID, int year, String testID);

	/**
	 * Verifies if the test with <code>courseID</code> year <code>year</code> and ID
	 * <code>testID</code> has the question with id <code>questionID</code>
	 * 
	 * @param courseID   course's id
	 * @param year       year that the test takes place
	 * @param testID     test's id
	 * @param questionID question's id
	 * @return <code>true</code> if the the test has the question <code>false</code>
	 *         if it doesn't
	 */
	boolean doesTestHaveQuestion(String courseID, int year, String testID, int questionID);

	/**
	 * Verifies if the test with course id <code>courseID</code> year
	 * <code>year</code> and id <code>testID</code> is open
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 * @return <code>true</code> if the test is open <code>false</code> if it isn't
	 */
	boolean isTestOpen(String courseID, int year, String testID);

	/**
	 * Returns questions iterator
	 * 
	 * @return questions iterator
	 */
	Iterator<Question> listQuestions();

	/**
	 * Adds test with course id <code>courseID</code> year <code>year</code> and id
	 * <code>testID</code> to the database
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 */
	void newTest(String courseID, int year, String testID);

	/**
	 * Returns tests with the course id <code>courseID</code>
	 * 
	 * @param courseID course's id
	 * @return tests with the course id
	 */
	int getCourseNumberOfTests(String courseID);

	/**
	 * Adds question with the id <code>questionID</code> with quotation
	 * <code>quotation</code> to the test with the course id <code>courseID</code>
	 * year <code>year</code> and id <code>testID</code>
	 * 
	 * @param questionID question's id
	 * @param courseID   course's id
	 * @param year       year that the test will take place
	 * @param testID     test's id
	 * @param quotation  question's quotation
	 */
	void addQuestionToTest(int questionID, String courseID, int year, String testID, double quotation);

	/**
	 * Returns test's current percentage with course id <code>courseID</code> year
	 * <code>year</code> and id <code>testID</code>
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 * @return test's current percentage
	 */
	double getCurrentPercentage(String courseID, int year, String testID);

	/**
	 * Removes question with id <code>questionID</code> from the test with course id
	 * <code>courseID</code> year <code>year</code> and id <code>testID</code>
	 * 
	 * @param questionID question's id
	 * @param courseID   course's id
	 * @param year       year that the test will take place
	 * @param testID     test's id
	 */
	void removeQuestionFromTest(int questionID, String courseID, int year, String testID);

	/**
	 * Closes test with course id <code>courseID</code> year <code>year</code> and
	 * id <code>testID</code>
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 */
	void closeTest(String courseID, int year, String testID);

	/**
	 * Returns test with course id <code>courseID</code> year <code>year</code> and
	 * id <code>testID</code> questions iterator
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 * @return test's questions iterator
	 */
	Iterator<TestQuestion> testQuestion(String courseID, int year, String testID);

	/**
	 * Returns tests iterator
	 * 
	 * @return tests iterator
	 */
	Iterator<Test> tests();

	/**
	 * Verifies if the question with id <code>questionID</code> is in any closed
	 * test
	 * 
	 * @param questionID question's id
	 * @return if question is in any closed test
	 */
	boolean isQuestionInClosedTests(int questionID);

	/**
	 * Marks question with id <code>questionID</code> with the correspondent number
	 * of answers <code>numberOfAnsers</code> and average <code>average</code>
	 * 
	 * @param questionID      question's id
	 * @param numberOfAnswers number of answers
	 * @param average         average quotation
	 */
	void markQuestion(int questionID, int numberOfAnswers, double average);

	/**
	 * Returns mark from the question with id <code>questionID</code>
	 * 
	 * @param questionID question's id
	 * @return mark from question
	 */
	double getQuestionMark(int questionID);

	/**
	 * Returns the most frequently used question
	 * 
	 * @return the most frequently used question
	 */
	Question frequent();

	/**
	 * Returns tricky questions iterator
	 * 
	 * @return tricky questions iterator
	 */
	Iterator<Question> tricky();

	/**
	 * Returns number of questions in the database
	 * 
	 * @return number of questions in the database
	 */
	int getNumberOfQuestions();

	/**
	 * Verifies if tag with name <code>tag</code> exists in the database
	 * 
	 * @param tag tag's name
	 * @return <code>true</code> of the tag exists in the database
	 *         <code>false</code> if it doesn't
	 */
	boolean tagExist(String tag);

	/**
	 * Returns number of tests in the database
	 * 
	 * @return number of tests in the database
	 */
	int getNumberOfTests();

	/**
	 * Verifies if the test with course id <code>courseID</code> year
	 * <code>year</code> and id <code>testID</code> exists in the database
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 * @return <code>true</code> if the test exists in the database
	 *         <code>false</code> if it doesn't
	 */
	boolean testIsOpen(String courseID, int year, String testID);

	/**
	 * Returns the number of respondents from the question with the id
	 * <code>questionID</code>
	 * 
	 * @param questionID question's id
	 * @return number of respondents from question
	 */
	int getNumberOfRespondents(int questionID);

	/**
	 * Returns questions associated with the tag <code>tag</code>
	 * 
	 * @param tag tag's name
	 * @return questions associated with the tag <code>tag</code>
	 */
	Iterator<Question> listByTag(String tag);
}
