package eapli.base.teachermanagement.eventhandler;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;

public class SetTeacherManagementService {
    TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();
    public Iterable<Teacher> findAllTeachers() {return teacherRepository.findAllTeachers();
    }
    public Teacher findByAcronym(String acronym) {
        return teacherRepository.findByAcronym(acronym);
    }
}
