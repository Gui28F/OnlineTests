package dataBase;

import array.Array;
import array.ArrayClass;
import array.Iterator;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Class that handles
 *         multiple choice questions' methods
 * 
 */

public class MultipleChoiceQuestionClass extends AbstractQuestionClass implements MultipleChoiceQuestion, Multiple {

	// Variable
	private Array<LineOfMultipleChoiceQuestion> options; // collection of question's options

	/**
	 * Classes constructor
	 * 
	 * @param questionID  question's id
	 * @param description question's description
	 */
	public MultipleChoiceQuestionClass(int questionID, String description) {
		super(questionID, description);
		this.options = new ArrayClass<>();
	}

	@Override
	public void addOption(boolean isTrue, String option, String evaluationCriteria) {
		options.insertLast(new LineOfMultipleChoiceQuestionClass(isTrue, option, evaluationCriteria));
	}

	@Override
	public int getNumberOfLines() {
		return options.size();
	}

	@Override
	public Iterator<LineOfMultipleChoiceQuestion> options() {
		return options.iterator();
	}

}
