package eapli.base.studentmanagement.application;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.managermanagement.builder.ManagerBuilder;
import eapli.base.managermanagement.domain.Manager;
import eapli.base.managermanagement.repository.ManagerRepository;
import eapli.base.studentmanagement.builder.StudentBuilder;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.teachermanagement.builder.TeacherBuilder;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Enroll student service.
 */
public class EnrollStudentService {
    /**
     * The Student repository.
     */
    StudentRepository studentRepository = PersistenceContext.repositories().students();

    /**
     * The Course repository.
     */
    CourseRepository courseRepository = PersistenceContext.repositories().Course();
    /*
    public Student registerStudent(final String email, final String rawPassword, final String fullName, final String shortName, final String birthDate, final String taxPayerNumber) {
        final var studentBuilder = new StudentBuilder();
        studentBuilder.with(email, rawPassword, fullName, shortName,birthDate,taxPayerNumber);
        final var newStudent = studentBuilder.build();
        return newStudent;
    }*/

    /**
     * Load csv.
     *
     * @param path   the path
     * @param course the course
     * @throws IOException the io exception
     */
    public void loadCSV(String path, Course course) throws IOException {
        List<Student> studentList = new ArrayList<>();
        Path pathToFile = Paths.get(path);
        String line;
        String[] atributes;
        BufferedReader br = Files.newBufferedReader(pathToFile);
        line = br.readLine();
        while (line != null) {
            atributes = line.split(",");
            studentList.add(studentRepository.findStudentByEmail(atributes[0].replaceAll("[\uFEFF\u200B]", "")));
            line = br.readLine();
        }
        courseRepository.appendStudent(studentList,course);
        }

    /**
     * Search by email student.
     *
     * @param email the email
     * @return the student
     */
    public Student searchByEmail(String email){
         return studentRepository.findStudentByEmail(email);
        }
    }
