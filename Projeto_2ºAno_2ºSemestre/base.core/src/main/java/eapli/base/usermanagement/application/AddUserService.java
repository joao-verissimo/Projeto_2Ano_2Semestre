package eapli.base.usermanagement.application;

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

public class AddUserService {

    StudentRepository studentRepository = PersistenceContext.repositories().students();
    TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();
    ManagerRepository managerRepository = PersistenceContext.repositories().managers();

    public Manager registerManager(final String email, final String rawPassword, final String fullName, final String shortName) {
        final var managerBuilder = new ManagerBuilder();
        managerBuilder.with(email, rawPassword, fullName, shortName);
        final var newManager = managerBuilder.build();
        return managerRepository.save(newManager);
    }

    public Teacher registerTeacher(final String email, final String rawPassword, final String fullName, final String shortName,final String acronym,final String birthDate, final String taxPayerNumber) {
        final var teacherBuilder = new TeacherBuilder();
        teacherBuilder.with(email, rawPassword, fullName, shortName,acronym,birthDate,taxPayerNumber);
        final var newTeacher = teacherBuilder.build();
        return teacherRepository.save(newTeacher);
    }

    public Student registerStudent(final String email, final String rawPassword, final String fullName, final String shortName,final String birthDate, final String taxPayerNumber) {
        final var studentBuilder = new StudentBuilder();
        studentBuilder.with(email, rawPassword, fullName, shortName,birthDate,taxPayerNumber);
        final var newStudent = studentBuilder.build();
        return studentRepository.save(newStudent);
    }

}
