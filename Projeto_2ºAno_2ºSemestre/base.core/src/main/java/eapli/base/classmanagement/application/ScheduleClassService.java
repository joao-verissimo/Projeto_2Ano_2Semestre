package eapli.base.classmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.classmanagement.builder.ClassBuilder;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * The type Schedule class service.
 */
public class ScheduleClassService {

    private final ClassRepository classRepository = PersistenceContext.repositories().classes();
    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * Schedule.
     *
     * @param title        the title
     * @param initialTime  the initial time
     * @param finishTime   the finish time
     * @param dayoftheweek the dayoftheweek
     */
    public void schedule(String title, String initialTime, String finishTime,String dayoftheweek){
        String acronym = findTeacherAcronym();
        Set<Boolean> booleanSet = new HashSet<>();
        if (verifyIfTeacherHasClass(acronym)) {
            LocalTime time1 = LocalTime.parse(initialTime);
            LocalTime time2 = LocalTime.parse(finishTime);
            for (Class classes : classRepository.findAllClassesByAcronym(acronym)) {
                boolean test = true;
                boolean initialT = isBetween(time1, classes.getDuration().getInitialTime(), classes.getDuration().getFinishTime());
                boolean finalT = isBetween(time2, classes.getDuration().getInitialTime(), classes.getDuration().getFinishTime());
                if (dayoftheweek.equals(classes.getDayoftheweek().getDayoftheweek())) {
                    if (initialT == true || finalT == true) {
                        test = false;
                    }
                }
                booleanSet.add(test);
            }
            boolean allTrue = areAllTrue(booleanSet);
            try {
                if (allTrue) {
                    scheduleClass(acronym, title, initialTime, finishTime, dayoftheweek);
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("There's already a class scheduled with this given time");
            }
        }else {
            scheduleClass(acronym,title,initialTime,finishTime,dayoftheweek);
        }
    }

    /**
     * Schedule class class.
     *
     * @param acronym      the acronym
     * @param title        the title
     * @param initialTime  the initial time
     * @param finishTime   the finish time
     * @param dayoftheweek the dayoftheweek
     * @return the class
     */
    public Class scheduleClass(String acronym, String title, String initialTime, String finishTime,String dayoftheweek){
        final ClassBuilder builder = new ClassBuilder();
        builder.with(title,initialTime,finishTime,dayoftheweek,teacherRepository.findByAcronym(acronym));
        final var newClass = builder.build();
        return classRepository.save(newClass);
    }

    /**
     * Is between boolean.
     *
     * @param time        the time
     * @param initialTime the initial time
     * @param finalTime   the final time
     * @return the boolean
     */
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

    /**
     * Verify if teacher has class boolean.
     *
     * @param acronym the acronym
     * @return the boolean
     */
    public boolean verifyIfTeacherHasClass(String acronym){
        List<Class> result = StreamSupport.stream(classRepository.findAllClassesByAcronym(acronym).spliterator(), false).collect(Collectors.toList());
        if (result.size() != 0){
            return true;
        }
        return false;
    }

    /**
     * Are all true boolean.
     *
     * @param booleanSet the boolean set
     * @return the boolean
     */
    public static boolean areAllTrue(Set<Boolean> booleanSet) {
        for (boolean value : booleanSet) {
            if (!value) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find teacher acronym string.
     *
     * @return the string
     */
    public String findTeacherAcronym(){
        Teacher teacher = teacherRepository.findTeacherByEmail(authz.session().get().authenticatedUser().email().toString());
        String acronym = teacher.getAcronym().toString();
        return acronym;
    }

    /**
     * Show my classes iterable.
     *
     * @return the iterable
     */
    public Iterable<Class> showMyClasses(){
        String acronym = findTeacherAcronym();
        return classRepository.findAllClassesByAcronym(acronym);
    }
}
