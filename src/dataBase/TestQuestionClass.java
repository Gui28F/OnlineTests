package dataBase;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045
 * Class that handles methods related to questions in tests
 */

public class TestQuestionClass implements TestQuestion {
	
	//Variables
	private Question question; //question that's in the test
	private double quotation; //question's quotation
	private int numberOfRespondents; //question's number of respondents
	private double average; //question's average

	/**
	 * Classe's constructor
	 * @param question question that's in the test
	 * @param quotation question's quotation
	 */
	public TestQuestionClass(Question question, double quotation) {
		this.question = question;
		this.quotation = quotation;
		this.average = 0;
		this.numberOfRespondents = 0;
	}

	@Override
	public double getCotation() {
		return quotation;
	}
	
	@Override
	public void giveMark(double mark, int respondents) {
		average = (average * respondents + mark * respondents)
				/ (this.numberOfRespondents + respondents);
		this.numberOfRespondents += respondents;
	}

	
	@Override
	public int getQuestionID() {
		return question.getQuestionID();
	}

	@Override
	public double getAverage() {
		return average;
	}

	@Override
	public int getNumberOfRespondents() {
		return numberOfRespondents;
	}

	@Override
	public Question getQuestion() {
		return question;
	}

}
