package eapli.base.app.student.presentation;

import application.AuthorizationService;
import application.AuthzRegistry;
import domain.model.Username;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.application.EnrollStudentController;
import eapli.base.studentmanagement.application.NextExamsController;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.framework.general.domain.model.EmailAddress;

public class NextExamsUI {
    NextExamsController nextExamsController = new NextExamsController();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    public boolean  show() {

        EmailAddress email  = authorizationService.session().get().authenticatedUser().email();
        StudentRepository studentRepository = PersistenceContext.repositories().students();
        Student student = studentRepository.findStudentByEmail(email.toString());

        System.out.println("Exams:");
        Iterable<Exam> exams = nextExamsController.nextExams(student);
        for (Exam c: exams) {
            System.out.println(c.toString());

        }
        return true;
    }
}
