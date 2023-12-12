package eapli.base.classmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.DayOfTheWeek;
import eapli.base.classmanagement.domain.Duration;
import eapli.base.usermanagement.domain.BaseRoles;

public class UpdateClassController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UpdateClassService svc = new UpdateClassService();





    public void updateClass(Long id, String newInitalTime,String newFinishTime, String newDayOfTheWeek){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
        svc.update(id,newInitalTime,newFinishTime,newDayOfTheWeek);

    }
    public Iterable<Class> showMyClasses (){
        return svc.showMyClasses();
    }


}
