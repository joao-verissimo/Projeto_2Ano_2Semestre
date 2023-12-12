package eapli.base.exammanagement.application;

import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jorge Lima
 */

public class ListExamsCourseService {
    ExamRepository examRepository = PersistenceContext.repositories().exams();

    public List<Exam> listAllExams(String course) {
        return examRepository.findByCourse(course);
    }
}
