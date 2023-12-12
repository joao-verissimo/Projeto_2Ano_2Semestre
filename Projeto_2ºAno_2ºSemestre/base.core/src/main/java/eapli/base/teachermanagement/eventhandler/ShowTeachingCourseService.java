package eapli.base.teachermanagement.eventhandler;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teachermanagement.repositories.TeacherRepository;

public class ShowTeachingCourseService {

     TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

}
