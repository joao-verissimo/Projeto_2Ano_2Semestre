package eapli.base.app.backoffice.console.presentation.teacher;

import eapli.base.exammanagement.application.CreateExamController;
import eapli.base.exammanagement.application.CreateQuestionController;
import eapli.base.exammanagement.domain.*;
import eapli.base.exammanagement.domain.Code;
import eapli.base.exammanagement.domain.Description;
import eapli.base.exammanagement.domain.Title;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        return "Create a new course";
    }

    public boolean doShow() {
        return false;
    }

    @Override
    protected Visitor<Exam> elementPrinter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementPrinter'");
    }
}
