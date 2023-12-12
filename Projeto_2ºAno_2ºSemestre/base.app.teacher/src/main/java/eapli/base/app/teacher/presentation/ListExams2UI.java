package eapli.base.app.teacher.presentation;

import eapli.base.exammanagement.application.CreateExamController;
import eapli.base.exammanagement.domain.Exam;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ListExams2UI extends AbstractUI {
    CreateExamController createExamController = new CreateExamController();
    @Override
    protected boolean doShow() {
        Iterable<Exam> list = createExamController.listExams();
        System.out.println("Title        | Date         | Header     | SequenceofSections | Coursecode | Questions");

        for (Exam exam : list) {
            String formattedOutput = String.format("%-12s | %-12s | %-15s | %-18s | %s | %s",
                    exam.getTitle().getValue(),
                    exam.getDate().date(),
                    exam.getHeader().toString(),
                    exam.getSequenceofSections().getValue(),
                    exam.getCourse().getCode().getValue(),
                    exam.getQuestions().toString()
            );

            System.out.println(formattedOutput);
        }

        return true;
    }

    @Override
    public String headline() {
        return "Show created exams";
    }
}
