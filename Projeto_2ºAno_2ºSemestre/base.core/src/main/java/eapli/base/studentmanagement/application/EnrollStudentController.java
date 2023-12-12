package eapli.base.studentmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.builder.StudentBuilder;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type Enroll student controller.
 */
public class EnrollStudentController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EnrollStudentService svc = new EnrollStudentService();

    /**
     * Load csv.
     *
     * @param path   the path
     * @param course the course
     * @throws IOException the io exception
     */
    public void loadCSV(String path, Course course) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);
        svc.loadCSV(path,course);
    }

    public Student searchByEmail(String email) {
        return svc.searchByEmail(email);
    }
}
