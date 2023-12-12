package eapli.base.exammanagement.application;

import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exammanagement.domain.*;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.exammanagement.repositories.QuestionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.List;

public class CreateExamController {
    ExamRepository examRepository = PersistenceContext.repositories().exams();
    CourseRepository courseRepository = PersistenceContext.repositories().Course();
    QuestionRepository questionRepository = PersistenceContext.repositories().questions();

    public void createExam(String course,List<Question> qt,Date dt, SequenceofSections ss, Title title,Header header) {
        Exam newExam = new Exam(qt, dt, ss, title, courseRepository.findByCode(course),header);
        examRepository.save(newExam);
    }

    public Iterable<Exam> listExams() {
        return examRepository.findAll();
    }

    public Iterable<Question> getrandomquestion() {
       return questionRepository.findAll();
    }
}