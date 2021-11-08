# OnlineTests
Online tests simulator 


  This project is an application that supports the creation and usage of a
questions database that can be used to generate midterm tests and exams. 

  The application is aimed at course instructors. With this application, instructors can create questions,
record correction criteria, tag questions with keywords, and use those keywords to make filtered searches
on their questions data bank. Moreover, they can create tests by selecting questions for inclusion in those tests,
and assign the weight for each of the selected questions. Last, but not the
least, instructors can record the success rate of students while answering each of the questions
in their data bank, establishing a difficulty rank for each question.

  Each test can have differentquestion sets and each question may be used in different tests. This also allows ranking the
tests by difficulty, helping instructors gauging the desired difficulty level for their tests.
Each question has a unique id, which is a sequential number assigned when the question is
created. All questions include a description (i.e. the question itself), a collection of the tests
in which they were used, and, when available, the number of students who had that question
in a particular test and their average classification in that question in that test. This allows
computing the weighted success of students while answering a question, which is an indicator of
the difficulty level for the question. A question can be of one of several kinds: in this version of
the system, we will have only three kinds of questions: open questions, multiple-choice questions,and numerical questions.

  We only have these three kinds for this project, but new question types can be easily added:
	• Open questions allow the student to enter a free-form answer. The system supports
	classification notes, where the instructor will record his classification criteria, in natural
	language. For the sake of our questions database, these criteria are expressed in a String.
	• Numerical questions are questions that allow a numerical response, possibly with tolerances.
	• Multiple-choice questions allow the selection of a single or multiple responses from a predefined list. 
	Each option can be true or false. The number of options can range from 2 to as many as the instructor desires.

  A test includes a set of questions. Each question is worth a given percentage of the test
classification. The sum of questions’ percentages must be greater or equal to 100 percent (to
allow for bonus questions, in case the instructor decides to have them on the test) for the test
to be considered valid. Note some tests in the repository may be \under construction" and not
have 100 percent of their points assigned, yet. The instructor must explicitly mark a "valid"
test as complete, before he can add classifications to its questions. Note that the same question
may be included in different tests and with different percentages.

COMMANDS:
  Run program and type "help" to see all available commands and their functionality.
