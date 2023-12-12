package eapli.base.app.teacher.presentation;

import eapli.base.exammanagement.application.ListExamsCourseController;
import eapli.base.exammanagement.domain.Exam;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.List;

/**
 * @author Jorge Lima
 */

public class ListExamsCourseUI extends AbstractUI {
    @Override
    public boolean doShow() {
        ListExamsCourseController lec = new ListExamsCourseController();
        String course = Console.readLine("Introduce the code of the course: ");
        List<Exam> list = lec.listAllExams(course);
        int x = 1;

        if (!list.isEmpty()) {
            System.out.println("Index | Title           | Date         | Header     | Sequence of Sections | Questions");
            System.out.println("-------------------------------------------------------------------------------");

            for (Exam e : list) {
                String formattedOutput = String.format("%-5d | %-15s | %-12s | %-15s | %s | %s",
                        x,
                        e.getTitle().getValue(),
                        e.getDate().date(),
                        e.getHeader().toString(),
                        e.getSequenceofSections().getValue(),
                        e.getQuestions().toString());

                System.out.println(formattedOutput);
                x++;
            }
        } else {
            System.out.println("There aren't any exams in this course or the course does not exist.");
        }

        return true;
    }


    @Override
    public String headline() {
        return "View all exams from a course";
    }
}
