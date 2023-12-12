package eapli.base.exammanagement.application;


import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;

public class ExamManagementService {
    ExamRepository examRepository = PersistenceContext.repositories().exams();
    CreateExamController createExamController = new CreateExamController();


    public Iterable<Exam> findAll() {
        return examRepository.findAll();
    }


    public Exam findByCode(String code) {
        return examRepository.findByCode(code);
    }

    public void appendStudent(Student student, Exam ExamCode){
        examRepository.appendStudent(student, ExamCode);
    }
}

