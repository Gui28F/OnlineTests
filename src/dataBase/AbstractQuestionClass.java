package dataBase;

import array.*;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Abstract class that
 *         handles general questions' methods
 *
 */

public abstract class AbstractQuestionClass implements Question {

	// Variables
	private int questionID; // question's id
	private String description; // question's description
	private double average; // question's average quotation
	private int numberOfRespondents; // question's number of respondents
	private Array<Test> testsWhichWasUsed; // collection of tests that have the question
	private Array<String> tags; // collection of question's tags

	/**
	 * Classes constructor
	 * 
	 * @param questionID  question's id
	 * @param description question's description
	 */
	protected AbstractQuestionClass(int questionID, String description) {
		this.questionID = questionID;
		this.description = description;
		this.average = 0;
		this.numberOfRespondents = 0;
		this.testsWhichWasUsed = new ArrayClass<Test>();
		this.tags = new ArrayClass<String>();
	}

	public String getDescription() {
		return description;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void addTag(String tag) {
		tags.insertLast(tag);
	}

	public boolean hasTag(String tag) {
		return tags.searchIndexOf(tag) != -1;
	}

	public void addTest(Test test) {
		testsWhichWasUsed.insertLast(test);
	}

	public void removeTest(Test test) {
		testsWhichWasUsed.removeAt(searchTest(test));
	}

	public int getNumberOfTests() {
		return testsWhichWasUsed.size();
	}

	public double getQuestionAverage() {
		return average;
	}

	public boolean isInClosedTests() {
		Iterator<Test> it = testsWhichWasUsed.iterator();
		Test test;
		while (it.hasNext()) {
			test = it.next();
			if (!test.isOpen())
				return true;
		}
		return false;
	}

	public void markQuestion(int numberOfAnswers, double average) {
		this.average = (this.average * this.numberOfRespondents + average * numberOfAnswers)
				/ (this.numberOfRespondents + numberOfAnswers);
		this.numberOfRespondents += numberOfAnswers;
	}

	public int getNumberOfRespondents() {
		return numberOfRespondents;
	}

	public boolean isTrickierThan(Question otherQuestion) {
		boolean isTrickiestThan = false;
		if (this.getNumberOfRespondents() == 0)
			return false;
		if (otherQuestion.getNumberOfRespondents() == 0)
			return true;
		if (this.getQuestionAverage() < otherQuestion.getQuestionAverage())
			isTrickiestThan = true;
		else if (this.getQuestionAverage() == otherQuestion.getQuestionAverage())
			if (this.getNumberOfRespondents() >= otherQuestion.getNumberOfRespondents())
				isTrickiestThan = true;
		return isTrickiestThan;
	}

	public Iterator<String> tags() {
		return tags.iterator();
	}

	// Compares this question's id with the other
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Question))
			return false;
		AbstractQuestionClass other = (AbstractQuestionClass) obj;
		if (questionID != other.questionID)
			return false;
		return true;
	}

	/**
	 * Returns index of test <code>test</code>
	 * 
	 * @param test test
	 * @return index of test
	 */
	private int searchTest(Test test) {
		return testsWhichWasUsed.searchIndexOf(test);
	}
}
