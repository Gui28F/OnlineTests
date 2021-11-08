package dataBase;

import array.*;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Class that handles
 *         most methods related to tests
 *
 */

public class TestClass implements Test {

	// Variables
	private String testID; // test's id
	private String courseID; // course's id
	private int year; // year that the test will take place
	private double currentPercentage; // total percentage at the current moment
	private boolean isOpen; // saved value of test status
	private Array<TestQuestion> questions; // collection of question in the test

	/**
	 * Classes constructor
	 * 
	 * @param testID   test's id
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 */
	public TestClass(String testID, String courseID, int year) {
		this.testID = testID;
		this.courseID = courseID;
		this.year = year;
		this.currentPercentage = 0;
		this.isOpen = true;
		this.questions = new ArrayClass<>();
	}

	@Override
	public boolean isOpen() {
		return isOpen;
	}

	@Override
	public void addQuestion(Question question, double questionQuotation) {
		questions.insertLast(new TestQuestionClass(question, questionQuotation));
		currentPercentage += questionQuotation;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public String getCourseID() {
		return courseID;
	}

	@Override
	public String getTestID() {
		return testID;
	}

	@Override
	public boolean greaterThan(Test otherTest) {
		boolean isGreater = false;
		if (this.getCourseID().compareTo(otherTest.getCourseID()) < 0)
			isGreater = true;
		else if (this.getCourseID().compareTo(otherTest.getCourseID()) == 0)
			if (this.getYear() > otherTest.getYear())
				isGreater = true;
			else if (this.getYear() == otherTest.getYear())
				if (this.getTestID().compareTo(otherTest.getTestID()) < 0)
					isGreater = true;
		return isGreater;
	}

	@Override
	public double getCurrentPercentage() {
		return currentPercentage;
	}

	@Override
	public void removeQuestion(int questionID) {
		TestQuestion quest = questions.get(searchIndexOf(questionID));
		currentPercentage -= quest.getCotation();
		questions.removeAt(searchIndexOf(questionID));
	}

	@Override
	public boolean questionExists(int questionID) {
		return searchIndexOf(questionID) != -1;
	}

	@Override
	public double getQuestionCotation(int questionID) {
		return questions.get(searchIndexOf(questionID)).getCotation();
	}

	@Override
	public void closeTest() {
		isOpen = false;
	}

	// Compares this test's characteristics with the other
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Test))
			return false;
		TestClass other = (TestClass) obj;
		if (courseID == null) {
			if (other.courseID != null)
				return false;
		} else if (!courseID.equals(other.courseID))
			return false;
		if (testID == null) {
			if (other.testID != null)
				return false;
		} else if (!testID.equals(other.testID))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public boolean canCloseTest() {
		return currentPercentage >= 0;
	}

	@Override
	public Iterator<TestQuestion> iterator() {
		return questions.iterator();
	}

	/**
	 * Searches question by id <code>questionID</code>
	 * 
	 * @param questionID question's id
	 * @return index of question
	 */
	private int searchIndexOf(int questionID) {
		Iterator<TestQuestion> it = questions.iterator();
		int i = 0;
		while (it.hasNext()) {
			TestQuestion quest = it.next();
			if (quest.getQuestionID() == questionID)
				return i;
			i++;
		}
		return -1;
	}

}
