import java.util.Scanner;
import dataBase.*;
import array.*;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045
 *
 */

public class Main {

	// Question types constants
	private static final String OPEN_QUESTION = "open";
	private static final String NUMERICAL_QUESTION = "numerical";
	private static final String MULTIPLE_CHOICE_QUESTION = "multiple";

	// Numerical constants
	private static final int MINIMAL_NUMBER_OPTIONS = 2;
	private static final double MINIMAL_WEIGHT = 0;

	private static final double MAXIMUM_WEIGHT = 1;
	private static final int MINIMAL_NUMBER_PARTICIPANTS = 0;
	private static final double MINIMAL_AVERAGE_GRADE = 0;
	private static final double MAXIMUM_AVERAGE_GRADE = 1;
	// Question messages constants
	private static final String UNKNOWN_TYPE = "Unknown question kind.";
	private static final String TRUE_OR_FALSE = "Answer must be either true or false.";
	private static final String NO_QUESTIONS = "No questions yet.";
	private static final String NO_QUESTIONS_ANSWERED = "No questions answered yet.";
	private static final String TRICKIEST_QUESTIONS = "Trickiest questions:";
	// Test messages constants
	private static final String ALREADY_INCLUDED = "Question already included in that test.";
	private static final String NOT_INCLUDED = "Question is not included in that test.";
	private static final String INVALID_WEIGHT = "Invalid weight.";
	private static final String TEST_CLOSED = "Test closed.";
	private static final String CANNOT_CLOSE = "Cannot close the test.";
	private static final String EMPTY_TEST = "Empty test.";
	private static final String NO_TESTS = "There are no tests registered.";
	private static final String ALL_QUESTIONS = "All questions:";
	private static final String FINAL_MESSAGE = "Bye!";

	// Formatted strings
	private static final String NEW_OPEN_QUESTION = "Question %d. %s [%s]\n";
	private static final String NEW_NUMERICAL_QUESTION = "Question %d. %s [%f .. %f]\n";
	private static final String NEW_MULTIPLE_CHOICE_QUESTION = "Question %d. %s [%d options]\n";
	private static final String INVALID_OPTION_SIZE = "Invalid options size %d.\n";
	private static final String QUESTION = "Q%d. %s %d %.02f [%s]\n";
	private static final String LIST_QUESTION = "Q%d. %s [%s]\n";
	private static final String TAG = "Added tag %s to question %d.\n";
	private static final String ALREADY_HAS_TAG = "Question %d already has tag %s.\n";
	private static final String NEW_TEST = "%s %d. %s. [%d]\n";
	private static final String QUESTION_ADDED = "Question added. [%.2f]\n";
	private static final String UNKNOWN_QUESTION = "Unknown question %d.\n";
	private static final String UNKNOWN_TEST = "Unknown test %s %d %s.\n";
	private static final String QUESTION_REMOVED = "Question removed. [%.2f]\n";
	private static final String ALREADY_CLOSED = "Already closed test %s %d %s.\n";
	private static final String TEST_IS_OPEN = "%s %d %s open %.2f\n";
	private static final String TEST_IS_CLOSED = "%s %d %s closed %.2f\n";
	private static final String TEST = "%s %d %s %s.\n";
	private static final String MARK = "Q%d. %.2f (%d)\n";
	private static final String INVALID_NUMBER_PARTICIPANTS = "%d is an invalid number of participants.\n";
	private static final String INVALID_AVERAGE_GRADE = "%.2f is an invalid average grade.\n";
	private static final String QUESTION_DOES_NOT_EXIST = "Question %d does not exist.\n";
	private static final String QUESTION_DOES_NOT_EXIST_IN_CLOSED_TESTS = "Question %d does not exixt in any closed test.\n";
	private static final String FREQUENT = "Q%d. %d.\n";
	private static final String TRICKY_QUESTION = "Q%d. %.2f %d\n";
	private static final String LIST_TEST_QUESTION = "Q%d. %s %.2f %d %.2f.\n";
	private static final String NUMERICAL_EVALUATION_CRITERIA = "[%f .. %f]\n";
	private static final String OPEN_EVALUATION_CRITERIA = "[%s]\n";
	private static final String MULTIPLE_EVALUATION = "[%s] %s [%s]\n";
	private static final String NO_QUESTIONS_TO_LIST = "No questions to list.";
	private static final String QUESTIONS_ABOUT = "Questions about %s...\n";
	private static final String UNKNOWN_TAG = "Unknown tag %s.\n";
	private static final String REGISTRED_TESTS = "Registered tests:";
	private static final String CLOSED_TEST = "Closed test %s %d %s.\n";
	private static final String TEST_ALREADY_EXIST = "%s %d %s already exists.\n";
	private static final String IS_OPEN = "open";
	private static final String IS_CLOSED = "closed";

	public static void main(String[] Args) {

		Scanner in = new Scanner(System.in);

		Command command = getCommandSimple(in);
		TestsRUs tests = new TestsRUsClass();

		while (!command.equals(Command.EXIT)) {

			switch (command) {
			case NEW:
				newMethod(in, tests);
				break;
			case QUESTION:
				questionMethod(in, tests);
				break;
			case TAG:
				tagMethod(in, tests);
				break;
			case QUESTIONS:
				questionsMethod(tests);
				break;
			case TAGGED:
				taggedMethod(in, tests);
				break;
			case NEWTEST:
				newTestMethod(in, tests);
				break;
			case ADD:
				addMethod(in, tests);
				break;
			case REMOVE:
				removeMethod(in, tests);
				break;
			case CLOSE:
				closeMethod(in, tests);
				break;
			case TEST:
				testMethod(in, tests);
				break;
			case TESTS:
				testsMethod(tests);
				break;
			case MARK:
				markMethod(in, tests);
				break;
			case FREQUENT:
				frequentMethod(in, tests);
				break;
			case TRICKY:
				trickyMethod(tests);
				break;
			case HELP:
				help();
				break;
			default:
				System.out.println(Command.UNKNOWN);
			}
			command = getCommandSimple(in);
		}
		System.out.println(FINAL_MESSAGE);
		in.close();

	}

	private static Command getCommandSimple(Scanner in) {
		try {
			String comd = in.next();
			return Command.valueOf(comd.toUpperCase());
		} catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}

	private static void help() {
		for (Command c : Command.values())
			if (c != Command.UNKNOWN)
				System.out.println(c);
	}

	private static void newMethod(Scanner in, TestsRUs tests) {
		String questionType = in.next();
		String description = in.nextLine().replaceFirst(" ", "");
		if (questionType.equals(OPEN_QUESTION)) {
			newOpenQuestion(in, tests, description);
		} else if (questionType.equals(NUMERICAL_QUESTION)) {
			newNumericalQuestion(in, tests, description);
		} else if (questionType.equals(MULTIPLE_CHOICE_QUESTION)) {
			newMultipleQuestion(in, tests, description);
		} else {
			System.out.println(UNKNOWN_TYPE);
		}
	}

	private static void newOpenQuestion(Scanner in, TestsRUs tests, String description) {
		String evaluationCriteria = in.nextLine();
		int questionID = tests.addOpenQuestion(description, evaluationCriteria);
		System.out.printf(NEW_OPEN_QUESTION, questionID, description, evaluationCriteria);
	}

	private static void newNumericalQuestion(Scanner in, TestsRUs tests, String description) {
		double bound1 = in.nextDouble();
		double bound2 = in.nextDouble();
		int questionID = tests.addNumericalQuestion(description, Math.min(bound1, bound2), Math.max(bound1, bound2));
		System.out.printf(NEW_NUMERICAL_QUESTION, questionID, description, Math.min(bound1, bound2),
				Math.max(bound1, bound2));
	}

	private static void newMultipleQuestion(Scanner in, TestsRUs tests, String description) {
		int numberOfOptions = in.nextInt();
		if (!(numberOfOptions < MINIMAL_NUMBER_OPTIONS)) {
			int questionID = tests.addMultipleChoiceQuestion(description, numberOfOptions);
			int numberOfOptionsAdded = 0;
			while (numberOfOptionsAdded < numberOfOptions) {
				boolean isTrue;
				if (in.hasNextBoolean()) {
					isTrue = in.nextBoolean();
					String option = in.nextLine().replaceFirst(" ", "");
					String evaluationCriteria = in.nextLine();
					tests.addChoices(questionID, isTrue, option, evaluationCriteria);
					numberOfOptionsAdded++;
				} else {
					in.next();
					in.nextLine();
					in.nextLine();
					System.out.println(TRUE_OR_FALSE);
				}
			}
			System.out.printf(NEW_MULTIPLE_CHOICE_QUESTION, questionID, description, numberOfOptions);
		} else
			System.out.printf(INVALID_OPTION_SIZE, numberOfOptions);
	}

	private static void questionMethod(Scanner in, TestsRUs tests) {
		int questionID = in.nextInt();
		if (tests.hasQuestion(questionID)) {
			Question quest = tests.getQuestion(questionID);
			String tags = "";
			Iterator<String> iter = quest.tags();
			while (iter.hasNext()) {
				tags += iter.next();
				if (iter.hasNext())
					tags += ", ";
			}
			System.out.printf(QUESTION, questionID, quest.getDescription(), quest.getNumberOfRespondents(),
					quest.getQuestionAverage(), tags);
		} else {
			System.out.printf(UNKNOWN_QUESTION, questionID);
		}
	}

	private static void tagMethod(Scanner in, TestsRUs tests) {
		int questionID = in.nextInt();
		String tag = in.nextLine().replaceFirst(" ", "");
		if (!tests.hasQuestion(questionID)) {
			System.out.printf(UNKNOWN_QUESTION, questionID);
		} else if (tests.questionHasTag(questionID, tag)) {
			System.out.printf(ALREADY_HAS_TAG, questionID, tag);
		} else {
			tests.addTag(questionID, tag);
			System.out.printf(TAG, tag, questionID);
		}
	}

	private static void questionsMethod(TestsRUs tests) {
		if (tests.getNumberOfQuestions() == 0)
			System.out.println(NO_QUESTIONS_TO_LIST);
		else {
			System.out.println(ALL_QUESTIONS);
			Iterator<Question> it = tests.listQuestions();
			while (it.hasNext()) {
				Question quest = it.next();
				String tags = "";
				Iterator<String> iter = quest.tags();
				while (iter.hasNext()) {
					tags += iter.next();
					if (iter.hasNext())
						tags += ", ";
				}
				System.out.printf(LIST_QUESTION, quest.getQuestionID(), quest.getDescription(), tags);
			}
		}
	}

	private static void taggedMethod(Scanner in, TestsRUs tests) {
		String tag = in.nextLine().replaceFirst(" ", "");
		if (!tests.tagExist(tag))
			System.out.printf(UNKNOWN_TAG, tag);
		else {
			Iterator<Question> it = tests.listByTag(tag);
			System.out.printf(QUESTIONS_ABOUT, tag);
			while (it.hasNext()) {
				Question quest = it.next();
				String tags = "";
				Iterator<String> iter = quest.tags();
				while (iter.hasNext()) {
					tags += iter.next();
					if (iter.hasNext())
						tags += ", ";
				}
				System.out.printf(LIST_QUESTION, quest.getQuestionID(), quest.getDescription(), tags);

			}
		}

	}

	private static void newTestMethod(Scanner in, TestsRUs tests) {
		String courseID = in.next();
		int year = in.nextInt();
		String testID = in.nextLine().replaceFirst(" ", "");
		if (tests.hasTest(courseID, year, testID)) {
			System.out.printf(TEST_ALREADY_EXIST, courseID, year, testID);
		} else {
			tests.newTest(courseID, year, testID);
			System.out.printf(NEW_TEST, courseID, year, testID, tests.getCourseNumberOfTests(courseID));
		}
	}

	private static void addMethod(Scanner in, TestsRUs tests) {
		int questionID = in.nextInt();
		double questionPercentage = in.nextDouble();
		String courseID = in.next();
		int year = in.nextInt();
		String testID = in.nextLine().replaceFirst(" ", "");
		if (!tests.hasQuestion(questionID)) {
			System.out.printf(UNKNOWN_QUESTION, questionID);
		} else if (!tests.hasTest(courseID, year, testID)) {
			System.out.printf(UNKNOWN_TEST, courseID, year, testID);
		} else if (!tests.isTestOpen(courseID, year, testID)) {
			System.out.printf(CLOSED_TEST, courseID, year, testID);
		} else if (tests.doesTestHaveQuestion(courseID, year, testID, questionID)) {
			System.out.println(ALREADY_INCLUDED);
		} else if (questionPercentage <= MINIMAL_WEIGHT || questionPercentage > MAXIMUM_AVERAGE_GRADE) {
			System.out.println(INVALID_WEIGHT);
		} else {
			tests.addQuestionToTest(questionID, courseID, year, testID, questionPercentage);
			System.out.printf(QUESTION_ADDED, tests.getCurrentPercentage(courseID, year, testID));
		}
	}

	private static void removeMethod(Scanner in, TestsRUs tests) {
		int questionID = in.nextInt();
		String courseID = in.next();
		int year = in.nextInt();
		String testID = in.nextLine().replaceFirst(" ", "");
		if (!tests.hasQuestion(questionID)) {
			System.out.printf(UNKNOWN_QUESTION, questionID);
		} else if (!tests.hasTest(courseID, year, testID)) {
			System.out.printf(UNKNOWN_TEST, courseID, year, testID);
		} else if (!tests.isTestOpen(courseID, year, testID)) {
			System.out.printf(CLOSED_TEST, courseID, year, testID);
		} else if (!tests.doesTestHaveQuestion(courseID, year, testID, questionID)) {
			System.out.println(NOT_INCLUDED);
		} else {
			tests.removeQuestionFromTest(questionID, courseID, year, testID);
			double currentPercentage = Math.abs(tests.getCurrentPercentage(courseID, year, testID));
			System.out.printf(QUESTION_REMOVED, currentPercentage);
		}
	}

	private static void closeMethod(Scanner in, TestsRUs tests) {
		String courseID = in.next();
		int year = in.nextInt();
		String testID = in.nextLine().replaceFirst(" ", "");
		if (!tests.hasTest(courseID, year, testID)) {
			System.out.printf(UNKNOWN_TEST, courseID, year, testID);
		} else if (!tests.isTestOpen(courseID, year, testID)) {
			System.out.printf(ALREADY_CLOSED, courseID, year, testID);
		} else if (tests.getCurrentPercentage(courseID, year, testID) < MAXIMUM_WEIGHT) {
			System.out.println(CANNOT_CLOSE);
		} else {
			tests.closeTest(courseID, year, testID);
			System.out.println(TEST_CLOSED);
		}
	}

	private static void testMethod(Scanner in, TestsRUs tests) {
		String courseID = in.next();
		int year = in.nextInt();
		String testID = in.nextLine().replaceFirst(" ", "");
		double currentPercentage = tests.getCurrentPercentage(courseID, year, testID);
		if (tests.testIsOpen(courseID, year, testID))
			System.out.printf(TEST_IS_OPEN, courseID, year, testID, currentPercentage);
		else
			System.out.printf(TEST_IS_CLOSED, courseID, year, testID, currentPercentage);
		Iterator<TestQuestion> it = tests.testQuestion(courseID, year, testID);
		if (!it.hasNext())
			System.out.println(EMPTY_TEST);
		else
			while (it.hasNext()) {
				TestQuestion testQuest = it.next();
				Question quest = testQuest.getQuestion();
				System.out.printf(LIST_TEST_QUESTION, quest.getQuestionID(), quest.getDescription(),
						testQuest.getCotation(), quest.getNumberOfRespondents(), quest.getQuestionAverage());
				if (quest instanceof Open) {
					System.out.printf(OPEN_EVALUATION_CRITERIA, ((OpenQuestion) quest).getEvaluationCriteria());
				} else if (quest instanceof Numerical) {
					System.out.printf(NUMERICAL_EVALUATION_CRITERIA, ((NumericQuestion) quest).getLowerBound(),
							((NumericQuestion) quest).getUpBound());
				} else if (quest instanceof Multiple) {
					Iterator<LineOfMultipleChoiceQuestion> iter = ((MultipleChoiceQuestion) quest).options();
					while (iter.hasNext()) {
						LineOfMultipleChoiceQuestion option = iter.next();
						System.out.printf(MULTIPLE_EVALUATION, option.isTheRightAnswer(), option.getDescription(),
								option.getEvaluationCriteria());
					}

				}
			}
	}

	private static void testsMethod(TestsRUs tests) {
		if (tests.getNumberOfTests() == 0)
			System.out.println(NO_TESTS);
		else {
			Iterator<Test> it = tests.tests();
			System.out.println(REGISTRED_TESTS);
			while (it.hasNext()) {
				Test test = it.next();
				String status;
				if (test.isOpen())
					status = IS_OPEN;
				else
					status = IS_CLOSED;
				System.out.printf(TEST, test.getCourseID(), test.getYear(), test.getTestID(), status);
			}
		}
	}

	private static void markMethod(Scanner in, TestsRUs tests) {
		int questionID = in.nextInt();
		int numberOfRespondents = in.nextInt();
		double average = in.nextDouble();
		if (!tests.hasQuestion(questionID)) {
			System.out.printf(QUESTION_DOES_NOT_EXIST, questionID);
		} else if (!tests.isQuestionInClosedTests(questionID)) {
			System.out.printf(QUESTION_DOES_NOT_EXIST_IN_CLOSED_TESTS, questionID);
		} else if (numberOfRespondents <= MINIMAL_NUMBER_PARTICIPANTS) {
			System.out.println(numberOfRespondents + INVALID_NUMBER_PARTICIPANTS);
		} else if (average < MINIMAL_AVERAGE_GRADE || average > MAXIMUM_AVERAGE_GRADE) {
			System.out.printf(average + INVALID_AVERAGE_GRADE, average);
		} else {
			tests.markQuestion(questionID, numberOfRespondents, average);
			System.out.printf(MARK, questionID, tests.getQuestionMark(questionID),
					tests.getNumberOfRespondents(questionID));
		}

	}

	private static void frequentMethod(Scanner in, TestsRUs tests) {
		if (tests.frequent() == null) {
			System.out.println(NO_QUESTIONS);
		} else {
			System.out.printf(FREQUENT, tests.frequent().getQuestionID(), tests.frequent().getNumberOfTests());
		}
	}

	private static void trickyMethod(TestsRUs tests) {
		if (!tests.hasQuestions() || !tests.hasQuestionsAnswered()) {
			System.out.println(NO_QUESTIONS_ANSWERED);
		} else {
			Iterator<Question> it = tests.tricky();
			Question trickyQ;
			System.out.println(TRICKIEST_QUESTIONS);
			while (it.hasNext()) {
				trickyQ = it.next();
				System.out.printf(TRICKY_QUESTION, trickyQ.getQuestionID(), trickyQ.getQuestionAverage(),
						trickyQ.getNumberOfRespondents());
			}
		}
	}
}