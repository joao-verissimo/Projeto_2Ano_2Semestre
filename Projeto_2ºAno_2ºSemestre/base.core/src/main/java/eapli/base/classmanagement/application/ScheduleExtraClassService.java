package eapli.base.classmanagement.application;


import eapli.base.classmanagement.builder.ExtraClassBuilder;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.ExtraClass;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.classmanagement.repositories.ExtraClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.repositories.TeacherRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ScheduleExtraClassService {

    private final ClassRepository classRepository = PersistenceContext.repositories().classes();
    private final ExtraClassRepository extraClassRepository = PersistenceContext.repositories().extraclasses();
    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

    public void schedule(String acronym, String title, String initialTime, String finishTime,String newdate,List<Student> extra_class_access_list){
        if (verifyIfTeacher(acronym)) {
            LocalTime time1 = LocalTime.parse(initialTime);
            LocalTime time2 = LocalTime.parse(finishTime);
            for (Class classes : classRepository.findAllClassesByAcronym(acronym)) {
                boolean initialT = isBetween(time1, classes.getDuration().getInitialTime(), classes.getDuration().getFinishTime());
                boolean finalT = isBetween(time2, classes.getDuration().getInitialTime(), classes.getDuration().getFinishTime());
                if (newdate.equals(classes.getDayoftheweek().getDayoftheweek())) {
                    if (initialT == false && finalT == false) {
                        scheduleClass(acronym, title, initialTime, finishTime, newdate,extra_class_access_list);
                    }
                    break;
                } else {
                    scheduleClass(acronym, title, initialTime, finishTime, newdate,extra_class_access_list);
                }
            }
        }else {
            scheduleClass(acronym,title,initialTime,finishTime,newdate,extra_class_access_list);
        }
    }

    public ExtraClass scheduleClass(String acronym, String title, String initialTime, String finishTime, String newdate, List<Student> extra_class_access_list){
        final ExtraClassBuilder builder = new ExtraClassBuilder();
        builder.with(title,initialTime,finishTime,newdate,teacherRepository.findByAcronym(acronym),extra_class_access_list);
        final var newExtraClass = builder.build();
        return extraClassRepository.save(newExtraClass);
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

    public boolean verifyIfTeacher(String acronym){
        List<ExtraClass> result = StreamSupport.stream(extraClassRepository.findAllClassesByAcronym(acronym).spliterator(), false).collect(Collectors.toList());
        if (result.size() != 0){
            return true;
        }
        return false;
    }
}
