package eapli.base.classmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.DayOfTheWeek;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


public class UpdateClassService {

    private final ClassRepository classRepository = PersistenceContext.repositories().classes();

    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();



    public void update (Long id, String newInitalTime,String newFinishTime, String newDayofTheWeek){
        Class c=findClassById(id);
        Set<Boolean> booleanSet = new HashSet<>();
        Teacher teacher = teacherRepository.findTeacherByEmail(authz.session().get().authenticatedUser().email().toString());
        String acronym = teacher.getAcronym().toString();

        LocalTime time1 = LocalTime.parse(newInitalTime);
        LocalTime time2 = LocalTime.parse(newFinishTime);
        for (Class classes : classRepository.findAllClassesByAcronym(acronym)) {
            boolean test = true;
            boolean initialT = isBetween(time1, classes.getDuration().getInitialTime(), classes.getDuration().getFinishTime());
            boolean finalT = isBetween(time2, classes.getDuration().getInitialTime(), classes.getDuration().getFinishTime());
            if (newDayofTheWeek.equals(classes.getDayoftheweek().getDayoftheweek())) {
                if (initialT == true || finalT == true) {
                    test = false;
                }
            }
            booleanSet.add(test);
        }
        boolean allTrue = areAllTrue(booleanSet);
        try {
            if (allTrue) {
                classRepository.setUpdateClass(id,c,newInitalTime,newFinishTime, DayOfTheWeek.valueOf(newDayofTheWeek));
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("There's already a class scheduled with this given time");
        }
    }


    public Class findClassById (Long id){

       return classRepository.findClassById(id);
    }
    public static boolean isBetween(LocalTime time, LocalTime initialTime, LocalTime finalTime) {
        boolean isInBetween = false;
        if (finalTime.isAfter(initialTime)) {
            if (initialTime.isBefore(time) && finalTime.isAfter(time)) {
                isInBetween = true;
            }
        } else if (time.isAfter(initialTime) || time.isBefore(finalTime)) {
            isInBetween = true;
        }
        return isInBetween;
    }


    public static boolean areAllTrue(Set<Boolean> booleanSet) {
        for (boolean value : booleanSet) {
            if (!value) {
                return false;
            }
        }
        return true;
    }

    public Iterable<Class> showMyClasses(){
        Teacher teacher = teacherRepository.findTeacherByEmail(authz.session().get().authenticatedUser().email().toString());
        String acronym = teacher.getAcronym().toString();
        return classRepository.findAllClassesByAcronym(acronym);
    }




}
