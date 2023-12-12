package eapli.base.exammanagement.application;
import eapli.base.exammanagement.domain.Exam;
import java.util.List;

/**
 * @author Jorge Lima
 */

public class ListExamsCourseController {
    ListExamsCourseService service = new ListExamsCourseService();

    public List<Exam> listAllExams(String course){ return service.listAllExams(course); }
}
