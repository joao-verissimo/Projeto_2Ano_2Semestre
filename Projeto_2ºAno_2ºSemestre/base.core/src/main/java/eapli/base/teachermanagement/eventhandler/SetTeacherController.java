package eapli.base.teachermanagement.eventhandler;


import eapli.base.coursemanagement.application.CourseManagementService;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.teachermanagement.domain.Teacher;


public class SetTeacherController {

    private final  SetTeacherManagementService  teacherService = new SetTeacherManagementService();
    private final CourseManagementService courseService = new CourseManagementService();


    public void appendTeacher(String acronym, String CourseCode){
        Teacher teacher =teacherService.findByAcronym(acronym);
        Course course = courseService.findByCode(CourseCode);
        courseService.appendTeacher(teacher,course);
    }

    public Iterable<Teacher> listTeachers() {
       return teacherService.findAllTeachers();

    }
    public Iterable<Course> listCourses(){
        return  courseService.findAllActive();
    }

    public Teacher findByAcronym(String acronym) {
        return teacherService.findByAcronym(acronym);
    }

}



