package dataBase;

import array.*;

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045 Class that handles
 *         most methods related to tags
 *
 */

public class TagClass implements Tag {

	// Variables
	private String tag; // tag name
	private Array<Question> tagQuestions; // collection of questions the tag is associated with

	/**
	 * Classe's constructor
	 * 
	 * @param tag tag name
	 */
	public TagClass(String tag) {
		this.tag = tag;
		this.tagQuestions = new ArrayClass<>();
	}

	@Override
	public void addQuestion(Question question) {
		tagQuestions.insertLast(question);
	}

	@Override
	public Iterator<Question> tagQuestions() {
		return tagQuestions.iterator();
	}

	@Override
	public String getTag() {
		return tag;
	}

	@Override
	public boolean hasQuestion(Question question) {
		return tagQuestions.searchIndexOf(question) != -1;
	}

	// Compares this tag's name with the other
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tag))
			return false;
		TagClass other = (TagClass) obj;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

}
