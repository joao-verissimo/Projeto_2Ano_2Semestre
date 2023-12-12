package eapli.base.teachermanagement.repositories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Acronym;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TeacherRepository extends DomainRepository<Acronym, Teacher> {

     Iterable<Teacher> findAllTeachers();
     Teacher findByAcronym(String acronym);

    Teacher findTeacherByEmail(String email);
}
