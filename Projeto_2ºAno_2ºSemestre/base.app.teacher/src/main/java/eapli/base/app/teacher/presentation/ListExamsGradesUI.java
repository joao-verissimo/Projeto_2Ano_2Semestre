package eapli.base.app.teacher.presentation;

import eapli.base.coursemanagement.domain.Course;

import eapli.base.exammanagement.application.ExamManagementController;
import eapli.base.exammanagement.application.ListExamsGradesPerCourseController;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.teachermanagement.eventhandler.ShowTeachingCoursesController;

import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ListExamsGradesUI extends AbstractUI {




    private final ShowTeachingCoursesController Teachercontroller = new ShowTeachingCoursesController();
    private final ListExamsGradesPerCourseController ExamsController = new ListExamsGradesPerCourseController();
    private final ExamManagementController ExamMangeController = new ExamManagementController();



    @Override
    protected boolean doShow() {
        final List<Course> listTeaching = new ArrayList<>();
        final Iterable<Course> iterableTeaching = this.Teachercontroller.showTeachingCourses();
        if (!iterableTeaching.iterator().hasNext()) {
            System.out.println("There are no teaching courses");
        } else {
            int cont = 1;
            for (final Course course : iterableTeaching) {
                listTeaching.add(course);
                System.out.printf("%-6d%-10s%n", cont, course.getName().getValue());
                cont++;
                System.out.println();

                Exam exam = ExamMangeController.findByCode(course.getCode().getValue());
                if (exam == null) {
                    System.out.println("No exams found for this course.");
                } else {
                    final List<Evaluation> listGrades = ExamsController.GradesPerCourse(String.valueOf(exam.getId()));
                    if (listGrades.isEmpty()) {
                        System.out.println("No exams found in this course.");
                    } else {
                        for (Evaluation e : listGrades) {
                            System.out.printf("%-6d%-10s%n", e.getStudent().getMecanographicNumber(), e.getGrade());
                        }
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String headline() {
        return null;
    }
}
