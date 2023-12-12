package eapli.base.classmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.ExtraClass;
import eapli.base.classmanagement.repositories.ExtraClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import eapli.base.usermanagement.domain.BaseRoles;

public class ShowTeacherExtraClassesController {
    ExtraClassRepository classRepository = PersistenceContext.repositories().extraclasses();
    TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public Iterable<ExtraClass> listTeacherClasses(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
        String email = authz.session().get().authenticatedUser().email().toString();
        Teacher teacher = teacherRepository.findTeacherByEmail(email);
        String acronym = teacher.getAcronym().toString();
        return classRepository.findAllClassesByAcronym(acronym);
    }

}
