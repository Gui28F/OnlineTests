package dataBase;

import array.Iterator;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Interface implemented
 *         in TagClass
 *
 */

public interface Tag {

	/**
	 * Adds question <code>question</code> to tag
	 * 
	 * @param question question added to tag
	 */
	void addQuestion(Question question);

	/**
	 * Retruns questions with tag iterator
	 * 
	 * @return questions with tag iterator
	 */
	Iterator<Question> tagQuestions();

	/**
	 * Returns tag name
	 * 
	 * @return tag name
	 */
	String getTag();

	/**
	 * Verifies if tag has question <code>question</code> associated with it
	 * 
	 * @param question searched question
	 * @return <code>true</code> if the question is associated <code>false</code> if
	 *         it isn't
	 */
	boolean hasQuestion(Question question);
}
