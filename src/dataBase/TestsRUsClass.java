package dataBase;

import array.Array;
import array.ArrayClass;
import array.Iterator;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Class that controls
 *         the database and all its collections like questions and tests
 *
 */

public class TestsRUsClass implements TestsRUs {

	// Constants
	private static final int NUMBER_OF_TRICKY_QUESTIONS = 3; // max number of tricky questions

	// Variables
	private Array<Question> questions; // collection of questions in the database
	private Array<Test> tests; // collection of tests in the database
	private Array<Tag> tags; // collection of tags in the database
	private Array<Question> trickyQuestions; // collection of trickier questions

	/**
	 * Classe's constructor
	 */
	public TestsRUsClass() {
		questions = new ArrayClass<Question>();
		tests = new ArrayClass<Test>();
		tags = new ArrayClass<Tag>();
		trickyQuestions = new ArrayClass<Question>(NUMBER_OF_TRICKY_QUESTIONS);
	}

	@Override
	public int addOpenQuestion(String description, String evaluationCriteria) {
		int questionID = questions.size() + 1;
		questions.insertLast(new OpenQuestionClass(questionID, description, evaluationCriteria));
		return questionID;
	}

	@Override
	public int addNumericalQuestion(String description, double lowerBound, double upBound) {
		int questionID = questions.size() + 1;
		questions.insertLast(new NumericQuestionClass(questionID, description, lowerBound, upBound));
		return questionID;
	}

	@Override
	public int addMultipleChoiceQuestion(String description, int numberOfOptions) {
		int questionID = questions.size() + 1;
		questions.insertLast(new MultipleChoiceQuestionClass(questionID, description));
		return questionID;
	}

	@Override
	public void addChoices(int questionID, boolean isTrue, String option, String evaluationCriteria) {
		((MultipleChoiceQuestion) getQuestion(questionID)).addOption(isTrue, option, evaluationCriteria);
	}

	@Override
	public Question getQuestion(int questionID) {
		return questions.get(questionID - 1);
	}

	@Override
	public boolean hasQuestion(int questionID) {
		return questionID > 0 && questionID <= questions.size();
	}

	@Override
	public boolean hasQuestionsAnswered() {
		Iterator<Question> it = questions.iterator();
		while (it.hasNext()) {
			Question question = it.next();
			if (question.getNumberOfRespondents() > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasQuestions() {
		return questions.size() != 0;
	}

	@Override
	public boolean questionHasTag(int questionID, String tag) {
		return getQuestion(questionID).hasTag(tag);
	}

	@Override
	public void addTag(int questionID, String tag) {
		if (!tagExist(tag))
			tags.insertLast(new TagClass(tag));
		tags.get(searchTagIndex(tag)).addQuestion(getQuestion(questionID));
		getQuestion(questionID).addTag(tag);
	}

	@Override
	public boolean hasTest(String courseID, int year, String testID) {
		return searchTest(courseID, year, testID) != -1;
	}

	@Override
	public boolean doesTestHaveQuestion(String courseID, int year, String testID, int questionID) {
		return tests.get(searchTest(courseID, year, testID)).questionExists(questionID);
	}

	@Override
	public boolean isTestOpen(String courseID, int year, String testID) {
		return tests.get(searchTest(courseID, year, testID)).isOpen();
	}

	@Override
	public Iterator<Question> listQuestions() {
		return questions.iterator();
	}

	@Override
	public void newTest(String courseID, int year, String testID) {
		Test test = new TestClass(testID, courseID, year);
		int low = 0;
		int high = tests.size() - 1;
		int mid = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (tests.get(mid).greaterThan(test))
				low = mid + 1;
			else
				high = mid - 1;
		}
		tests.insertAt(test, low);
	}

	@Override
	public int getCourseNumberOfTests(String courseID) {
		Iterator<Test> it = tests.iterator();
		Test test;
		int numberOfTests = 0;
		while (it.hasNext()) {
			test = it.next();
			if (test.getCourseID().equals(courseID))
				numberOfTests++;
		}
		return numberOfTests;
	}

	@Override
	public void addQuestionToTest(int questionID, String courseID, int year, String testID, double quotation) {
		Test test = tests.get(searchTest(courseID, year, testID));
		Question question = getQuestion(questionID);
		test.addQuestion(question, quotation);
		question.addTest(test);
	}

	@Override
	public double getCurrentPercentage(String courseID, int year, String testID) {
		return tests.get(searchTest(courseID, year, testID)).getCurrentPercentage();
	}

	@Override
	public void removeQuestionFromTest(int questionID, String courseID, int year, String testID) {
		Test test = tests.get(searchTest(courseID, year, testID));
		test.removeQuestion(questionID);
		getQuestion(questionID).removeTest(test);
	}

	@Override
	public void closeTest(String courseID, int year, String testID) {
		tests.get(searchTest(courseID, year, testID)).closeTest();
	}

	@Override
	public Iterator<TestQuestion> testQuestion(String courseID, int year, String testID) {
		return tests.get(searchTest(courseID, year, testID)).iterator();
	}

	@Override
	public Iterator<Test> tests() {
		return tests.iterator();
	}

	@Override
	public boolean isQuestionInClosedTests(int questionID) {
		return getQuestion(questionID).isInClosedTests();
	}

	@Override
	public void markQuestion(int questionID, int numberOfRespondents, double mark) {
		getQuestion(questionID).markQuestion(numberOfRespondents, mark);
		updateTrickyQuestions(questionID);
	}

	@Override
	public double getQuestionMark(int questionID) {
		return getQuestion(questionID).getQuestionAverage();
	}

	@Override
	public Question frequent() {
		int max = 1;
		Question frequentQuestion = null;
		Iterator<Question> it = questions.iterator();
		Question question;
		while (it.hasNext()) {
			question = it.next();
			if (question.getNumberOfTests() >= max) {
				max = question.getNumberOfTests();
				frequentQuestion = question;
			}
		}
		return frequentQuestion;
	}

	@Override
	public Iterator<Question> tricky() {
		return trickyQuestions.iterator();
	}

	@Override
	public int getNumberOfQuestions() {
		return questions.size();
	}

	@Override
	public boolean tagExist(String tag) {
		return searchTagIndex(tag) != -1;
	}

	@Override
	public int getNumberOfTests() {
		return tests.size();
	}

	@Override
	public boolean testIsOpen(String courseID, int year, String testID) {
		return tests.get(searchTest(courseID, year, testID)).isOpen();
	}

	@Override
	public int getNumberOfRespondents(int questionID) {
		return getQuestion(questionID).getNumberOfRespondents();
	}

	private int searchTagIndex(String tag) {
		return tags.searchIndexOf(new TagClass(tag));
	}

	@Override
	public Iterator<Question> listByTag(String tag) {
		return tags.get(searchTagIndex(tag)).tagQuestions();
	}

	/**
	 * Searches test by its course id <code>courseID</code> year <code>year</code>
	 * and id <code>testID</code>
	 * 
	 * @param courseID course's id
	 * @param year     year that the test will take place
	 * @param testID   test's id
	 * @return index of test
	 */
	private int searchTest(String courseID, int year, String testID) {
		Test test = new TestClass(testID, courseID, year);
		return tests.searchIndexOf(test);
	}

	/**
	 * Updates the tricky questions' array
	 * 
	 * @param questionID question's id
	 */
	private void updateTrickyQuestions(int questionID) {
		if (trickyQuestions.size() == 0)
			trickyQuestions.insertLast(getQuestion(questionID));
		else {
			Iterator<Question> it = trickyQuestions.iterator();
			int pos = -1;
			int i = 0;
			Question question = getQuestion(questionID);
			while (it.hasNext()) {
				Question quest = it.next();
				if (!quest.equals(question) && question.isTrickierThan(quest))
					pos = i;
				else
					i++;
			}
			if (pos != -1) {
				if (trickyQuestions.size() == NUMBER_OF_TRICKY_QUESTIONS)
					trickyQuestions.removeLast();
				trickyQuestions.insertAt(question, pos);
			}
		}
	}
}
