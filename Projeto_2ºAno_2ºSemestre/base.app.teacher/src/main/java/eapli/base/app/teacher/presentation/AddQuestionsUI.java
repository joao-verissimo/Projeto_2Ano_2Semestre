package eapli.base.app.teacher.presentation;

import antlr.ParseTree;
import eapli.base.exammanagement.application.AddQuestionsController;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.domain.Question;
import eapli.framework.presentation.console.AbstractUI;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;


public class AddQuestionsUI extends AbstractUI {
    AddQuestionsController addQuestionsController = new AddQuestionsController();

    @Override
    protected boolean doShow() {
        System.out.println(System.getProperty("user.dir"));
        /*
        CharStream fis = CharStreams.fromFileName("docs/TemplateExam");
        QuestionGrammarLexer lexer = new QuestionGrammarLexer(fis);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionGrammarParser parser = new QuestionGrammarParser(tokens);
        ParseTree tree = parser.start(); // parse
        QuestionGrammarVisitor eval = new QuestionGrammarVisitor();
        eval.visit(tree);
        ParseTreeWalker walker = new ParseTreeWalker();
        QuestionGrammarListener listner = new QuestionGrammarListener();
        walker.walk(listner, tree);
        System.out.println(listner.getResult());*/


        return true;
    }

    @Override
    public String headline() {
        return "Add questions";
    }
}
