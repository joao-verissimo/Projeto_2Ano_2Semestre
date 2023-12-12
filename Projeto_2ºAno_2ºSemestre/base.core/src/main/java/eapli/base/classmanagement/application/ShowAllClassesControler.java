package eapli.base.classmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.ExtraClass;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.classmanagement.repositories.ExtraClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;

public class ShowAllClassesControler {

    ClassRepository classRepository = PersistenceContext.repositories().classes();
    ExtraClassRepository extraClassRepository = PersistenceContext.repositories().extraclasses();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<Class> listAllClasses(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
        return classRepository.findAll();
    }

    public Iterable<ExtraClass> listExtraClasses(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
        return extraClassRepository.findAll();
    }


}
