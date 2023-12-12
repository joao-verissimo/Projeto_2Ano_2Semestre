package eapli.base.exammanagement.application;

import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.domain.Student;

public class ExamManagementController {

    ExamManagementService examManagementService = new ExamManagementService();

    public void appendStudents(Student student, Exam examCode){
        examManagementService.appendStudent(student,examCode);
    }
    public Exam findByCode(String code) {
        return examManagementService.findByCode(code);
    }

}
