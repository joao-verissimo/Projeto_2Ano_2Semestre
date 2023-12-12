package eapli.base.app.teacher.teacher;

import eapli.base.app.teacher.ExamGrammarBaseListener;
import eapli.base.app.teacher.ExamGrammarBaseVisitor;
import eapli.base.app.teacher.ExamGrammarLexer;
import eapli.base.app.teacher.ExamGrammarParser;
import eapli.base.exammanagement.application.CreateExamController;
import eapli.base.exammanagement.application.CreateQuestionController;
import eapli.base.exammanagement.domain.*;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.stream.StreamSupport;


import static eapli.base.exammanagement.domain.TypeofQuestion.MATCHING_QUESTION;
import static eapli.base.exammanagement.domain.TypeofQuestion.SINGLE_ANSWER_QUESTION;

public class CreateExamUI extends AbstractListUI<Exam> {
    private final CreateExamController controller;

    public CreateExamUI() {
        this.controller = new CreateExamController();
    }

    @Override
    protected Iterable<Exam> elements() {
        return controller.listExams();
    }

    @Override
    protected String elementName() {
        return "exam";
    }

    @Override
    protected String listHeader() {
        return "List of exams:";
    }

    @Override
    protected String emptyMessage() {
        return "No exams available";
    }


    @Override
    public String headline() {
        return "Create a new Exam";
    }

    public boolean doShow() {
        CreateExamController controller = new CreateExamController();
        CreateQuestionController questionController = new CreateQuestionController();
        System.out.println("Create from file or manually?");
        System.out.println("1. From Text");
        System.out.println("2. Manually");
        int choice = Integer.parseInt(Console.readLine("Type the number"));
        if(choice == 1) {
            ExamGrammarLexer lexer = new ExamGrammarLexer(CharStreams.fromString(Console.readLine("Enter Text ")));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExamGrammarParser parser = new ExamGrammarParser(tokens);
            ParseTree tree = parser.start();
            String treeString = tree.toStringTree(parser);
            System.out.println(treeString);
            ParseTreeWalker walker = new ParseTreeWalker();
            ExamGrammarBaseListener listener = new ExamGrammarBaseListener();
            walker.walk(listener, tree);
        } else if (choice == 2) {
            final String title = Console.readLine("Enter the exam title: ");
            final String description = Console.readLine("Enter the exam description: ");
            final String sequenceOfSections = Console.readLine("Enter the sequence of sections: ");
            String date = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);

            while (true) {
                String input = Console.readLine("Enter the date (yyyy-MM-dd): ");

                try {
                    dateFormat.parse(input);
                    date = input;
                    break;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");}}

            final String code = Console.readLine("Enter the course code: ");
            int numQuestions = 0;

            while (true) {
                String input = Console.readLine("Enter the number of questions you want to create: ");

                try {
                    numQuestions = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }

            }        for (int i = 1; i <= numQuestions; i++) {
                System.out.println("Question #" + i);
                String questionText = Console.readLine("Enter the question: ");
                String correctAnswer = Console.readLine("Enter the correct answer: ");
                TypeofQuestion type = choosequestionType();
                questionController.createQuestion(questionText,correctAnswer,type);
            }
            Iterable<Question> asd = questionController.getRandomQuestions();
            Iterator<Question> teste = asd.iterator();
            List<Question> qt= new ArrayList<Question>();
            while(teste.hasNext()){
                qt.add(teste.next());
            }
            Header.Feedback feedback = chooseFeedBack();
            Header.Grade grade = chooseGrade();
            String globalsetttings = Console.readLine("Enter the global settings: ");
            Header header = new Header(new Description(description),feedback,grade,globalsetttings);
            controller.createExam(code,qt,new Date(date), new SequenceofSections(sequenceOfSections), new Title(title),header);
        }
        else {
            System.out.println("Invalid option. Please try again.");
        }
        return false;
    }

    @Override
    protected Visitor<Exam> elementPrinter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementPrinter'");
    }

    public TypeofQuestion choosequestionType(){
        System.out.println("Select the question type:");
        System.out.println("1. Matching Question");
        System.out.println("2. Single Answer Question");
        System.out.println("3. Short Answer Question");
        System.out.println("4. Numerical Question");
        System.out.println("5. Select Missing Words Question");
        System.out.println("6. True/False Question");
        int choice = Integer.parseInt(Console.readLine("Type the number"));
        switch (choice) {
            case 1:
                return TypeofQuestion.MATCHING_QUESTION;
            case 2:
                return TypeofQuestion.SINGLE_ANSWER_QUESTION;
            case 3:
                return TypeofQuestion.SHORT_ANSWER_QUESTION;
            case 4:
                return TypeofQuestion.NUMERICAL_QUESTION;
            case 5:
                return TypeofQuestion.SELECT_MISSING_WORDS_QUESTION;
            case 6:
                return TypeofQuestion.TRUE_FALSE_QUESTION;
            default:
                System.out.println("Invalid option. Defaulting to Matching Question.");
                return TypeofQuestion.MATCHING_QUESTION;
        }
    }

    public Header.Grade chooseGrade(){
        System.out.println("Select the grade type:");
        System.out.println("1. None");
        System.out.println("2. On Submission");
        System.out.println("3. After Closing");
        int choice = Integer.parseInt(Console.readLine("Type the number"));
        switch (choice) {
            case 1:
                return Header.Grade.NONE;
            case 2:
                return Header.Grade.ON_SUBMISSION;
            case 3:
                return Header.Grade.AFTER_CLOSING;
            default:
                System.out.println("Invalid option. Defaulting to None.");
                return Header.Grade.NONE;
        }
    }

    public Header.Feedback chooseFeedBack(){
        System.out.println("Select the grade type:");
        System.out.println("1. None");
        System.out.println("2. On Submission");
        System.out.println("3. After Closing");
        int choice = Integer.parseInt(Console.readLine("Type the number"));
        switch (choice) {
            case 1:
                return Header.Feedback.NONE;
            case 2:
                return Header.Feedback.ON_SUBMISSION;
            case 3:
                return Header.Feedback.AFTER_CLOSING;
            default:
                System.out.println("Invalid option. Defaulting to None.");
                return Header.Feedback.NONE;
        }
    }
}
