package eapli.base.app.backoffice.console.presentation.Student;

import application.AuthorizationService;
import application.AuthzRegistry;
import domain.model.Username;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.application.NextExamsController;
import eapli.base.studentmanagement.domain.Student;

public class NextExamsUI {
    NextExamsController nextExamsController = new NextExamsController();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    public boolean  show() {
        /*
        Username student  = authorizationService.session().get().authenticatedUser().identity();
        System.out.println("Courses:");
        Iterable<Course> courses = nextExamsController.nextExams();
        for (Exam c: exams) {
            System.out.println(c.toString());

        }
        return true;

         */
        return true;
    }
}
