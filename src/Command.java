

/**
 * 
 * @author Diogo Santos 60003 / Guilherme Fernandes 60045
 *
 */

public enum Command {

	NEW("new - adds a new question to the database"),
	QUESTION("question - displays the info concerning a particular question"), TAG("tag - adds a keyword to a question"),
	QUESTIONS("questions - lists all questions in the database"),
	TAGGED("tagged - lists all questions with a particular keyword in the database"),
	NEWTEST("newTest - creates a new test in the database"), ADD("add - adds an existing question to a test"),
	REMOVE("remove - removes a question from a test"), CLOSE("close - closes the specification of a test"),
	TEST("test - shows the information concerning a test"), TESTS("tests - lists the registered tests"),
	MARK("mark - adds classifications to a question in a test"), FREQUENT("frequent - selects the question used in more tests"),
	TRICKY("tricky - lists the most difficult questions in the database"), HELP("help - shows the available commands"),
	EXIT("exit - terminates the execution of the program"),
	UNKNOWN("Unknown command. Type help to see available commands.");

	private String description;

	private Command(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}
